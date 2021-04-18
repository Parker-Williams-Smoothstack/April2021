package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.de.Booking;

public class BookingDAO extends AbstractDAO<Booking> {

	public BookingDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<Booking> parseData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Booking> list = new ArrayList<>();
		while (rs.next()) {
			Booking obj = new Booking();
			obj.setActive(rs.getBoolean("is_active"));
			obj.setConfirmationCode(rs.getString("confirmation_code"));
			obj.setId(rs.getInt("id"));
			list.add(obj);
		}
		return list;
	}

	@Override
	public Integer add(Booking obj) throws ClassNotFoundException, SQLException {
		Integer key = super.addPK("INSERT INTO booking (is_active, confirmation_code) VALUES (?,?)", obj.isActive(), obj.getConfirmationCode());
		obj.setId(key);
		return key;
	}

	@Override
	public void update(Booking obj) throws ClassNotFoundException, SQLException {
		super.update("UPDATE booking set is_active = ?, confirmation_code = ? where id = ?", obj.isActive(), obj.getConfirmationCode(), obj.getId());
		
	}

	@Override
	public void delete(Booking obj) throws ClassNotFoundException, SQLException {
		super.update("delete from booking where id = ?", obj.getId());
		
	}

	@Override
	public List<Booking> getAll() throws ClassNotFoundException, SQLException {
		return super.getData("select * from booking");
	}

}
