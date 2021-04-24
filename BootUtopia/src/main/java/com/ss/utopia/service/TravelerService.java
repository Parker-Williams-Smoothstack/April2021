/**
 * 
 */
package com.ss.utopia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ss.utopia.dao.UserDAO;

/**
 * @author Parker W.
 *
 */
@Repository
public class TravelerService {
	
	@Autowired
	UserDAO udao;
	
	

}
