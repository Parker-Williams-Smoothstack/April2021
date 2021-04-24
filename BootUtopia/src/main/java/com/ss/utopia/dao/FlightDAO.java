package com.ss.utopia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ss.utopia.de.Flight;

@Repository
public class FlightDAO extends AbstractDAO<Flight> implements ResultSetExtractor<List<Flight>> {

	@Autowired
	RouteDAO rdao;

	@Autowired
	AirplaneDAO pdao;

	@Override
	public List<Flight> extractData(ResultSet rs) throws SQLException {
		List<Flight> list = new ArrayList<>();
		while (rs.next()) {
			Flight obj = new Flight();

			obj.setId(rs.getInt("id"));
			obj.setDepatureTime(rs.getDate("departure_time"));
			obj.setReservedSeats(rs.getInt("reserved_seats"));
			obj.setSeatPrice(rs.getFloat("seat_price"));

			obj.setRoute(rdao.getData("select * from route where id = ?", rs.getInt("route_id")).get(0));
			obj.setPlane(pdao.getData("select * from airplane where id = ?", rs.getInt("route_id")).get(0));

			list.add(obj);
		}
		return list;
	}

	@Override
	public Integer create(Flight obj) {
		String query = "insert flight (route_id, airplane_id, departure_time, reserved_seats, seat_price) values (?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(query, new String[] { "id" });
			ps.setInt(1, obj.getRoute().getId());
			ps.setInt(2, obj.getPlane().getId());
			ps.setDate(3, obj.getDepatureTime());
			ps.setInt(4, obj.getReservedSeats());
			ps.setFloat(5, obj.getSeatPrice());
			return ps;
		}, keyHolder);
		Integer key = keyHolder.getKey().intValue();
		obj.setId(key);
		return key;
	}

	@Override
	public void update(Flight obj) {
		jdbcTemplate.update(
				"update flight set route_id = ?, airplane_id = ?, departure_time = ?, reserved_seats = ?, seat_price = ? where id = ?",
				obj.getRoute().getId(), obj.getPlane().getId(), obj.getDepatureTime(), obj.getReservedSeats(),
				obj.getSeatPrice(), obj.getId());

	}

	@Override
	public void delete(Flight obj) {
		jdbcTemplate.update("delete from flight where id = ?", obj.getId());

	}

	@Override
	public List<Flight> getAll() {
		return jdbcTemplate.query("select * from flight", this);
	}

	@Override
	public List<Flight> getData(String query, Object... params) {
		return jdbcTemplate.query(query, this, params);
	}

}
