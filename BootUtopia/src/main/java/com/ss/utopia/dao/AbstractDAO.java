/**
 * 
 */
package com.ss.utopia.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author Parker W.
 *
 */
@Repository
public abstract class AbstractDAO<T> {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public abstract List<T> getAll();

	public abstract Integer create(T obj);

	// public abstract void read(T obj); //really this is handled by the Get<T>Menu
	public abstract void update(T obj);

	public abstract void delete(T obj);
	public abstract List<T> getData(String query, Object...params);

}
