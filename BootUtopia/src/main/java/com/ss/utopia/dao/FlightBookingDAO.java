/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.ss.utopia.de.FlightBooking;

/**
 * @author Parker W.
 *
 */
@Repository
public class FlightBookingDAO extends AbstractDAO<FlightBooking> implements ResultSetExtractor<List<FlightBooking>> {

	@Autowired
	BookingDAO bdao;

	@Autowired
	FlightDAO fdao;

	@Override
	public List<FlightBooking> extractData(ResultSet rs) throws SQLException {
		List<FlightBooking> bookings = new ArrayList<>();
		while (rs.next()) {
			FlightBooking booking = new FlightBooking();
			booking.setBooking(bdao.getData("select * from booking where id = ?", rs.getInt("booking_id")).get(0));
			booking.setFlight(fdao.getData("select * from flight where id = ?", rs.getInt("flight_id")).get(0));
		}
		return bookings;
	}

	@Override
	public Integer create(FlightBooking obj) {
		jdbcTemplate.update("insert into flight_booking (flight_id, booking_id) values (?,?)", obj.getFlight().getId(),
				obj.getBooking().getId());

		// flightBookings have no unique id or generated key, return null
		return null;

	}

	@Override
	public void update(FlightBooking obj) {
		// There is no unique identifier for a FlightBooking, and in turn no way to edit
		// only a single entry
		// Leave empty for now to avoid writing over multiple entries

	}

	@Override
	public void delete(FlightBooking obj) {
		jdbcTemplate.update("delete from flight_booking where flight_id = ? and booking_id = ?",
				obj.getFlight().getId(), obj.getBooking().getId());

	}

	@Override
	public List<FlightBooking> getAll() {
		return jdbcTemplate.query("select * from flight_booking", this);
	}

	@Override
	public List<FlightBooking> getData(String query, Object... params) {
		return jdbcTemplate.query(query, this, params);
	}

}
