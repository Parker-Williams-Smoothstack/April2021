package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.de.BookingAgent;

public class BookingAgentDAO extends AbstractDAO<BookingAgent>{

	public BookingAgentDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<BookingAgent> parseData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingAgent> list = new ArrayList<>();
		while (rs.next()) {
			BookingAgent obj = new BookingAgent();
			BookingDAO bdao = new BookingDAO(conn);
			UserDAO udao = new UserDAO(conn);
			
			obj.setAgentId(udao.getData("select * from user where id = ?", rs.getInt("agent_id")).get(0));
			obj.setBooking(bdao.getData("select * from booking where id = ?", rs.getInt("booking_id")).get(0));
			
			list.add(obj);
		}
		return list;
	}

	@Override
	public Integer add(BookingAgent obj) throws ClassNotFoundException, SQLException {
		return super.addPK("INSERT INTO booking_agent (booking_id, agent_id) VALUES (?,?)", obj.getBooking().getId(), obj.getAgentId().getId());
	}

	@Override
	public void update(BookingAgent obj) throws ClassNotFoundException, SQLException {
		super.update("UPDATE booking_agent booking_id = ? where agent_id = ?", obj.getBooking().getId(), obj.getAgentId().getId());
		
	}

	@Override
	public void delete(BookingAgent obj) throws ClassNotFoundException, SQLException {
		super.update("delete from booking_agent where agent_id = ?", obj.getAgentId().getId());
		
	}

	@Override
	public List<BookingAgent> getAll() throws ClassNotFoundException, SQLException {
		return super.getData("select * from booking_agent");
	}


}
