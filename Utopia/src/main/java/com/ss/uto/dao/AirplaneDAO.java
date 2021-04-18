/**
 * 
 */
package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.de.Airplane;
import com.ss.uto.de.AirplaneType;

/**
 * @author Parker W.
 *
 */
public class AirplaneDAO extends AbstractDAO<Airplane> {

	public AirplaneDAO(Connection conn) {
		super(conn);
	}

	@Override
	public Integer add(Airplane obj) throws ClassNotFoundException, SQLException {
		Integer key = super.addPK("INSERT INTO airplane (type_id) VALUES (?)", obj.getType().getType());
		obj.setId(key);
		return key;
	}

	@Override
	public void update(Airplane obj) throws ClassNotFoundException, SQLException {
		super.update("UPDATE airplane set type_id = ? where id = ?", obj.getType().getType(), obj.getId());

	}

	@Override
	public void delete(Airplane obj) throws ClassNotFoundException, SQLException {
		super.update("DELETE FROM airplane where id = ?", obj.getId());
	}

	@Override
	public List<Airplane> parseData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Airplane> planes = new ArrayList<>();
		while(rs.next()) {
			Airplane plane = new Airplane();
			plane.setId(rs.getInt("id"));
			
			AirplaneTypeDAO tdao = new AirplaneTypeDAO(this.conn);
			AirplaneType t = tdao.getData("select * from airplane_type where id = ?", rs.getInt("type_id")).get(0);
			
			plane.setType(t);			
			planes.add(plane);
		}
		return planes;
	}

	@Override
	public List<Airplane> getAll() throws ClassNotFoundException, SQLException {
		return super.getData("select * from airplane");
	}

}
