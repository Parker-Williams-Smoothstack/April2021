/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import com.ss.utopia.de.Airport;

/**
 * @author Parker W.
 *
 */
@Repository
public class AirportDAO extends AbstractDAO<Airport> implements ResultSetExtractor<List<Airport>> {

	@Override
	public List<Airport> extractData(ResultSet rs) throws SQLException {
		List<Airport> ports = new ArrayList<>();
		while (rs.next()) {
			Airport port = new Airport();
			port.setCode(rs.getString("iata_id"));
			port.setCityName(rs.getString("city"));
			ports.add(port);
		}
		return ports;
	}

	@Override
	public Integer create(Airport obj) {
		jdbcTemplate.query("INSERT INTO airport (iata_id, city) VALUES (?,?)", this, obj.getCode(), obj.getCityName());
		return null; // airport has no key that it is given, unique id comes from iata_id
	}

	@Override
	public void update(Airport obj) {
		jdbcTemplate.update("UPDATE airport set city = ? where iata_id = ?", this, obj.getCityName(), obj.getCode());
	}

	@Override
	public void delete(Airport obj) {
		jdbcTemplate.query("DELETE FROM airport where iata_id = ?", this, obj.getCode());

	}

	@Override
	@GetMapping("/airports")
	public List<Airport> getAll() {
		return jdbcTemplate.query("SELECT * FROM airport", this);
	}
	
	@Override
	public List<Airport> getData(String query, Object...params){
		return jdbcTemplate.query(query, this, params);
	}

}
