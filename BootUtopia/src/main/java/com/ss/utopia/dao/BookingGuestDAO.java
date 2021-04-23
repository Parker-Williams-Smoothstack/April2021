/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.de.BookingGuest;

/**
 * @author Parker W.
 *
 */
public class BookingGuestDAO extends AbstractDAO<BookingGuest> {

	public BookingGuestDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<BookingGuest> parseData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingGuest> list = new ArrayList<>();
		while (rs.next()) {
			BookingGuest obj = new BookingGuest();
			BookingDAO bdao = new BookingDAO(conn);
			obj.setBooking(bdao.getData("select * from booking where id = ?", rs.getInt("booking_id")).get(0));
			obj.setEmail(rs.getString("contact_email"));
			obj.setPhone(rs.getString("contact_phone"));

			list.add(obj);
		}
		return list;
	}

	@Override
	public Integer add(BookingGuest obj) throws ClassNotFoundException, SQLException {
		return super.addPK("insert into booking_guest (booking_id, contact_email, contact_phone) values (?,?,?)",
				obj.getBooking().getId(), obj.getEmail(), obj.getPhone());
	}

	@Override
	public void update(BookingGuest obj) throws ClassNotFoundException, SQLException {
		super.update("update booking_guest set contact_email = ?, contact_phone = ? where booking_id = ?",
				obj.getEmail(), obj.getPhone(), obj.getBooking().getId());
	}

	@Override
	public void delete(BookingGuest obj) throws ClassNotFoundException, SQLException {
		super.update("delete from booking_guest where booking_id = ?", obj.getBooking().getId());
	}

	@Override
	public List<BookingGuest> getAll() throws ClassNotFoundException, SQLException {
		return super.getData("select * from booking guest");
	}

}
