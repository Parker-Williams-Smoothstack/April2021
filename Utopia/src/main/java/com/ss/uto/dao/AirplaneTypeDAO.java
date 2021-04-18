/**
 * 
 */
package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.de.AirplaneType;

/**
 * @author Parker W.
 *
 */
public class AirplaneTypeDAO extends AbstractDAO<AirplaneType> {

	public AirplaneTypeDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<AirplaneType> parseData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<AirplaneType> types = new ArrayList<>();
		while (rs.next()) {
			AirplaneType type = new AirplaneType();
			type.setType(rs.getInt("id"));
			type.setCapacity(rs.getInt("max_capacity"));
			types.add(type);
		}
		return types;
	}

	@Override
	public Integer add(AirplaneType obj) throws ClassNotFoundException, SQLException {
		Integer key = super.addPK("INSERT INTO airplane_type (max_capacity) VALUES (?)",
				obj.getCapacity());
		
		obj.setType(key);
		return key;
	}

	@Override
	public void update(AirplaneType obj) throws ClassNotFoundException, SQLException {
		super.update("UPDATE airplane_type set max_capacity = ? where id = ?", obj.getCapacity(), obj.getType());

	}

	@Override
	public void delete(AirplaneType obj) throws ClassNotFoundException, SQLException {
		super.update("DELETE FROM airplane_type where id = ?", obj.getType());

	}

	@Override
	public List<AirplaneType> getAll() throws ClassNotFoundException, SQLException {
		return super.getData("SELECT * FROM airplane_type");
	}

}
