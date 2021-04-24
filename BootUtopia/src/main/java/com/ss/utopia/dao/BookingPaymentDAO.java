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

import com.ss.utopia.de.BookingPayment;
/**
 * @author Parker W.
 *
 */
@Repository
public class BookingPaymentDAO extends AbstractDAO<BookingPayment> implements ResultSetExtractor<List<BookingPayment>>{
	
	@Autowired
	BookingDAO bdao;


	@Override
	public List<BookingPayment> extractData(ResultSet rs) throws SQLException {
		List<BookingPayment> payments = new ArrayList<>();
		while(rs.next()) {
			BookingPayment payment = new BookingPayment();
			
			payment.setBooking(bdao.getData("select * from booking where id = ?", rs.getInt("booking_id")).get(0));
			payment.setStripeId(rs.getString("stripe_id"));
			payment.setRefunded(rs.getBoolean("refunded"));
			
			payments.add(payment);
			
		}
		return payments;

	}

	@Override
	public Integer create(BookingPayment obj) {

		String query = "INSERT INTO booking_payment (booking_id, stripe_id, refunded) VALUES (?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(query, new String[] {});
			ps.setInt(1, obj.getBooking().getId());
			ps.setString(2, obj.getStripeId());
			ps.setBoolean(3, obj.isRefunded());
			return ps;
		}, keyHolder);
		return null; //does not have a unique/generated key
	}

	@Override
	public void update(BookingPayment obj){
		jdbcTemplate.update("update booking_payment set stripe_id = ?, refunded = ? where booking_id = ?", obj.getStripeId(),
				obj.isRefunded(), obj.getBooking().getId());

	}

	@Override
	public void delete(BookingPayment obj){
		jdbcTemplate.update("delete from booking_payment where booking_id = ?", obj.getBooking().getId());	
		//booking_id isn't actually unique here so this could delete multiple entries, need to watch?
		

	}

	@Override
	public List<BookingPayment> getAll(){
		return jdbcTemplate.query("select * from booking_payment", this);
	}
	
	@Override
	public List<BookingPayment> getData(String query, Object... params) {
		return jdbcTemplate.query(query, this, params);
	}

}
