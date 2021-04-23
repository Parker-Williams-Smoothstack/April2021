/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.de.BookingUser;

/**
 * @author Parker W.
 *
 */
public class BookingUserDAO extends AbstractDAO<BookingUser> {

	public BookingUserDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<BookingUser> parseData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingUser> list = new ArrayList<>();
		while (rs.next()) {
			BookingUser obj = new BookingUser();
			BookingDAO bdao = new BookingDAO(conn);
			UserDAO udao = new UserDAO(conn);
			
			obj.setUserId(udao.getData("select * from user where id = ?", rs.getInt("user_id")).get(0));
			obj.setBooking(bdao.getData("select * from booking where id = ?", rs.getInt("booking_id")).get(0));
			
			list.add(obj);
		}
		return list;
	}

	@Override
	public Integer add(BookingUser obj) throws ClassNotFoundException, SQLException {
		return super.addPK("INSERT INTO booking_user (booking_id, user_id) VALUES (?,?)", obj.getBooking().getId(), obj.getUserId().getId());
	}

	@Override
	public void update(BookingUser obj) throws ClassNotFoundException, SQLException {
		super.update("UPDATE booking_user booking_id = ? where user_id = ?", obj.getBooking().getId(), obj.getUserId().getId());
		
	}

	@Override
	public void delete(BookingUser obj) throws ClassNotFoundException, SQLException {
		super.update("delete from booking_user where user_id = ?", obj.getUserId().getId());
		
	}

	@Override
	public List<BookingUser> getAll() throws ClassNotFoundException, SQLException {
		return super.getData("select * from booking_user");
	}

}
