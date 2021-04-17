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
		return super.addPK("INSERT INTO airplane (id, type_id) VALUES (?,?)", obj.getId(), obj.getType().getType());
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
			plane.getType().setType(rs.getInt("type_id"));
			planes.add(plane);
		}
		return planes;
	}

}
