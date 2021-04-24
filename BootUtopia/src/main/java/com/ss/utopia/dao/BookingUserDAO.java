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

import com.ss.utopia.de.BookingUser;

@Repository
public class BookingUserDAO extends AbstractDAO<BookingUser> implements ResultSetExtractor<List<BookingUser>>{
	
	@Autowired
	BookingDAO bdao;
	
	@Autowired
	UserDAO udao;


	@Override
	public List<BookingUser> extractData(ResultSet rs) throws SQLException {
		List<BookingUser> list = new ArrayList<>();
		while (rs.next()) {
			BookingUser obj = new BookingUser();
			
			obj.setUserId(udao.getData("select * from user where id = ?", rs.getInt("user_id")).get(0));
			obj.setBooking(bdao.getData("select * from booking where id = ?", rs.getInt("booking_id")).get(0));
			
			list.add(obj);
		}
		return list;
	}

	@Override
	public Integer create(BookingUser obj){
		//return super.addPK("INSERT INTO booking_agent (booking_id, agent_id) VALUES (?,?)", obj.getBooking().getId(), obj.getAgentId().getId());
		String query = "INSERT INTO booking_user (booking_id, user_id) VALUES (?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(query, new String[] {});
			ps.setInt(1, obj.getBooking().getId());
			ps.setInt(2, obj.getUserId().getId());
			return ps;
		}, keyHolder);
		return null; //does not have a unique key, is all determined by booking and user
	}

	@Override
	public void update(BookingUser obj){
		jdbcTemplate.update("UPDATE booking_user booking_id = ? where user_id = ?", obj.getBooking().getId(), obj.getUserId().getId());
		
	}

	@Override
	public void delete(BookingUser obj){
		jdbcTemplate.update("delete from booking_user where user_id = ?", obj.getUserId().getId());
		
	}

	@Override
	public List<BookingUser> getAll() {
		return jdbcTemplate.query("select * from booking_user", this);
	}

	@Override
	public List<BookingUser> getData(String query, Object... params) {
		return jdbcTemplate.query(query, this, params);
	}


}
