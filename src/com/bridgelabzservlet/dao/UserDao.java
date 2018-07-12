package com.bridgelabzservlet.dao;

import com.bridgelabzservlet.dto.UserBean;

/**
 * User Dao Interface .
 * @author Sameer Saurabh
 * @version : 1.0
 * @since : 29/06/2018
 */
public interface UserDao {
	public UserBean authenticate(String adminId, String password);
}
