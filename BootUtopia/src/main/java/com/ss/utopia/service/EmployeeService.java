package com.ss.utopia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeService {

	@Autowired
	JdbcTemplate template;

	
}
