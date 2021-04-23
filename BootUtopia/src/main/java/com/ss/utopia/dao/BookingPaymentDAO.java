/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.de.BookingPayment;

/**
 * @author Parker W.
 *
 */
public class BookingPaymentDAO extends AbstractDAO<BookingPayment> {

	public BookingPaymentDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<BookingPayment> parseData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingPayment> payments = new ArrayList<>();
		while(rs.next()) {
			BookingDAO bdao = new BookingDAO(conn);
			BookingPayment payment = new BookingPayment();
			
			payment.setBooking(bdao.getData("select * from booking where id = ?", rs.getInt("booking_id")).get(0));
			payment.setStripeId(rs.getString("stripe_id"));
			payment.setRefunded(rs.getBoolean("refunded"));
			
			payments.add(payment);
			
		}
		return payments;

	}

	@Override
	public Integer add(BookingPayment obj) throws ClassNotFoundException, SQLException {
		return super.addPK("INSERT INTO booking_payment (booking_id, stripe_id, refunded) VALUES (?,?,?)",
				obj.getBooking().getId(), obj.getStripeId(), obj.isRefunded());
	}

	@Override
	public void update(BookingPayment obj) throws ClassNotFoundException, SQLException {
		super.update("update booking_payment set stripe_id = ?, refunded = ? where booking_id = ?", obj.getStripeId(),
				obj.isRefunded(), obj.getBooking().getId());

	}

	@Override
	public void delete(BookingPayment obj) throws ClassNotFoundException, SQLException {
		super.update("delete from booking_payment where booking_id = ?", obj.getBooking().getId());	
		//booking_id isn't actually unique here so this could delete multiple entries, need to watch?
		

	}

	@Override
	public List<BookingPayment> getAll() throws ClassNotFoundException, SQLException {
		return super.getData("select * from booking_payment");
	}

}
