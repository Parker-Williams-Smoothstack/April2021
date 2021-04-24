/**
 * 
 */
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

import com.ss.utopia.de.BookingGuest;

/**
 * @author Parker W.
 *
 */
@Repository
public class BookingGuestDAO extends AbstractDAO<BookingGuest> implements ResultSetExtractor<List<BookingGuest>>{
	
	@Autowired
	BookingDAO bdao;

	@Override
	public List<BookingGuest> extractData(ResultSet rs) throws SQLException {
		List<BookingGuest> list = new ArrayList<>();
		while (rs.next()) {
			BookingGuest obj = new BookingGuest();
			obj.setBooking(bdao.getData("select * from booking where id = ?", rs.getInt("booking_id")).get(0));
			obj.setEmail(rs.getString("contact_email"));
			obj.setPhone(rs.getString("contact_phone"));

			list.add(obj);
		}
		return list;
	}

	@Override
	public Integer create(BookingGuest obj){		
		String query = "insert into booking_guest (booking_id, contact_email, contact_phone) values (?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(query, new String[] {});
			ps.setInt(1, obj.getBooking().getId());
			ps.setString(2, obj.getEmail());
			ps.setString(3, obj.getPhone());
			return ps;
		}, keyHolder);
		return null; //does not have a unique key, is all determined by booking
	}

	@Override
	public void update(BookingGuest obj){
		jdbcTemplate.update("update booking_guest set contact_email = ?, contact_phone = ? where booking_id = ?",
				obj.getEmail(), obj.getPhone(), obj.getBooking().getId());
	}

	@Override
	public void delete(BookingGuest obj){
		jdbcTemplate.update("delete from booking_guest where booking_id = ?", obj.getBooking().getId());
	}

	@Override
	public List<BookingGuest> getAll(){
		return jdbcTemplate.query("select * from booking guest", this);
	}

	@Override
	public List<BookingGuest> getData(String query, Object... params) {
		return jdbcTemplate.query(query, this, params);
	}
	
	

}
