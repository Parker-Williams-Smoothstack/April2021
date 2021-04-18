package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.de.Flight;

public class FlightDAO extends AbstractDAO<Flight> {

	public FlightDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<Flight> parseData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Flight> list = new ArrayList<>();
		while (rs.next()) {
			Flight obj = new Flight();

			obj.setId(rs.getInt("id"));
			obj.setDepatureTime(rs.getDate("departure_time"));
			obj.setReservedSeats(rs.getInt("reserved_seats"));
			obj.setSeatPrice(rs.getFloat("seat_price"));
			
			RouteDAO rdao = new RouteDAO(this.conn);
			AirplaneDAO pdao = new AirplaneDAO(this.conn);
			obj.setRoute( rdao.getData("select * from route where id = ?", rs.getInt("route_id")).get(0) );
			obj.setPlane( pdao.getData("select * from airplane where id = ?", rs.getInt("route_id")).get(0));
			

			list.add(obj);
		}
		return list;
	}

	@Override
	public Integer add(Flight obj) throws ClassNotFoundException, SQLException {
		Integer key = super.addPK("insert flight (route_id, airplane_id, departure_time, reserved_seats, seat_price) values (?,?,?,?,?)", 
				obj.getRoute().getId(), obj.getPlane().getId(), obj.getDepatureTime(), obj.getReservedSeats(), obj.getSeatPrice());
		obj.setId(key);
		return key;
	}

	@Override
	public void update(Flight obj) throws ClassNotFoundException, SQLException {
		super.update("update flight set route_id = ?, airplane_id = ?, departure_time = ?, reserved_seats = ?, seat_price = ? where id = ?", 
				obj.getRoute().getId(), obj.getPlane().getId(), obj.getDepatureTime(), obj.getReservedSeats(), obj.getSeatPrice(), obj.getId());
		
	}

	@Override
	public void delete(Flight obj) throws ClassNotFoundException, SQLException {
		super.update("delete from flight where id = ?", obj.getId());
		
	}

	@Override
	public List<Flight> getAll() throws ClassNotFoundException, SQLException {
		return super.getData("select * from flight");
	}

}
