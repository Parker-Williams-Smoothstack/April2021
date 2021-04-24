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

import com.ss.utopia.de.BookingAgent;

@Repository
public class BookingAgentDAO extends AbstractDAO<BookingAgent> implements ResultSetExtractor<List<BookingAgent>>{
	
	@Autowired
	BookingDAO bdao;
	
	@Autowired
	UserDAO udao;


	@Override
	public List<BookingAgent> extractData(ResultSet rs) throws SQLException {
		List<BookingAgent> list = new ArrayList<>();
		while (rs.next()) {
			BookingAgent obj = new BookingAgent();
			
			obj.setAgentId(udao.getData("select * from user where id = ?", rs.getInt("agent_id")).get(0));
			obj.setBooking(bdao.getData("select * from booking where id = ?", rs.getInt("booking_id")).get(0));
			
			list.add(obj);
		}
		return list;
	}

	@Override
	public Integer create(BookingAgent obj){
		//return super.addPK("INSERT INTO booking_agent (booking_id, agent_id) VALUES (?,?)", obj.getBooking().getId(), obj.getAgentId().getId());
		String query = "INSERT INTO booking_agent (booking_id, agent_id) VALUES (?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(query, new String[] {});
			ps.setInt(1, obj.getBooking().getId());
			ps.setInt(2, obj.getAgentId().getId());
			return ps;
		}, keyHolder);
		return null; //does not have a unique key, is all determined by booking and user
	}

	@Override
	public void update(BookingAgent obj){
		jdbcTemplate.update("UPDATE booking_agent booking_id = ? where agent_id = ?", obj.getBooking().getId(), obj.getAgentId().getId());
		
	}

	@Override
	public void delete(BookingAgent obj){
		jdbcTemplate.update("delete from booking_agent where agent_id = ?", obj.getAgentId().getId());
		
	}

	@Override
	public List<BookingAgent> getAll() {
		return jdbcTemplate.query("select * from booking_agent", this);
	}

	@Override
	public List<BookingAgent> getData(String query, Object... params) {
		return jdbcTemplate.query(query, this, params);
	}


}
