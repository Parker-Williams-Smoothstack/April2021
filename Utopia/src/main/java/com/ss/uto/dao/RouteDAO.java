package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.de.Airport;
import com.ss.uto.de.Route;

public class RouteDAO extends AbstractDAO<Route> {

	public RouteDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<Route> parseData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Route> list = new ArrayList<>();
		while (rs.next()) {
			Route obj = new Route();
			Airport orig = new Airport();
			Airport dest = new Airport();
			AirportDAO pdao = new AirportDAO(this.conn);
			
			obj.setId(rs.getInt("id"));
			orig.setCode(rs.getString("origin_id"));
			dest.setCode(rs.getString("destination_id"));
			orig.setCityName( pdao.getData("select * from airport where iata_id = ?", orig.getCode()).get(0).getCityName());
			dest.setCityName( pdao.getData("select * from airport where iata_id = ?", dest.getCode()).get(0).getCityName());
			obj.setOrigin(orig);
			obj.setDestination(dest);

			list.add(obj);
		}
		return list;
	}

	@Override
	public Integer add(Route obj) throws ClassNotFoundException, SQLException {
		Integer key = super.addPK("insert into route (origin_id, destination_id) VALUES (?,?)",
				obj.getOrigin().getCode(), obj.getDestination().getCode());
		obj.setId(key);
		return key;
	}

	@Override
	public void update(Route obj) throws ClassNotFoundException, SQLException {
		super.update("update route set origin_id = ?, destination_id = ? where id = ?", obj.getOrigin().getCode(),
				obj.getDestination().getCode(), obj.getId());

	}

	@Override
	public void delete(Route obj) throws ClassNotFoundException, SQLException {
		super.update("delete from route where id = ?", obj.getId());

	}

	@Override
	public List<Route> getAll() throws ClassNotFoundException, SQLException {
		return super.getData("select * from route");
	}

}
