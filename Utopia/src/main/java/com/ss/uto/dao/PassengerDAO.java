package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.de.Booking;
import com.ss.uto.de.Passenger;

public class PassengerDAO extends AbstractDAO<Passenger> {

	public PassengerDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<Passenger> parseData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Passenger> passengers = new ArrayList<>();
		while (rs.next()) {
			Passenger passenger = new Passenger();
			passenger.setId(rs.getInt("id"));
			passenger.setAddress(rs.getString("address"));

			BookingDAO bdao = new BookingDAO(conn);
			Booking booking = bdao.getData("select * from booking where id = ?", rs.getInt("booking_id")).get(0);

			passenger.setBooking(booking);
			passenger.setFamilyName(rs.getString("family_name"));
			passenger.setGivenName(rs.getString("given_name"));
			passenger.setDateOfBirth(rs.getDate("dob"));
			passenger.setGender(rs.getString("gender"));

			passengers.add(passenger);
		}
		return passengers;
	}

	@Override
	public Integer add(Passenger obj) throws ClassNotFoundException, SQLException {
		Integer key = super.addPK(
				"INSERT INTO passenger (booking_id, given_name, family_name, dob, gender, address) VALUES (?,?,?,?,?,?)",
				obj.getBooking().getId(), obj.getGivenName(), obj.getFamilyName(), obj.getDateOfBirth(),
				obj.getGender(), obj.getAddress());
		obj.setId(key);
		return key;
	}

	@Override
	public void update(Passenger obj) throws ClassNotFoundException, SQLException {
		super.update(
				"update passenger set booking_id = ?, given_name = ?, family_name= ?, dob = ?, gender = ?, address = ? where id = ?",
				obj.getBooking().getId(), obj.getGivenName(), obj.getFamilyName(), obj.getDateOfBirth(),
				obj.getGender(), obj.getAddress(), obj.getId());

	}

	@Override
	public void delete(Passenger obj) throws ClassNotFoundException, SQLException {
		super.update("delete from passenger where id = ?", obj.getId());
	}

	@Override
	public List<Passenger> getAll() throws ClassNotFoundException, SQLException {
		return super.getData("select * from passenger");
	}

}
