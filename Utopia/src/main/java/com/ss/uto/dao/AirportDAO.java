/**
 * 
 */
package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.de.Airport;

/**
 * @author Parker W.
 *
 */
public class AirportDAO extends AbstractDAO<Airport> {

	public AirportDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<Airport> parseData(ResultSet rs) throws ClassNotFoundException, SQLException {
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
	public Integer add(Airport obj) throws ClassNotFoundException, SQLException {
		return super.addPK("INSERT INTO airport (iata_id, city) VALUES (?,?)", obj.getCode(),
				obj.getCityName());
	}

	@Override
	public void update(Airport obj) throws ClassNotFoundException, SQLException {
		super.update("UPDATE airport set city = ? where iata_id = ?", obj.getCityName(), obj.getCode());
		
	}

	@Override
	public void delete(Airport obj) throws ClassNotFoundException, SQLException {
		super.update("DELETE FROM airport where iata_id = ?", obj.getCode());
		
	}

	@Override
	public List<Airport> getAll() throws ClassNotFoundException, SQLException {
		return super.getData("SELECT * FROM airport");
	}

}
