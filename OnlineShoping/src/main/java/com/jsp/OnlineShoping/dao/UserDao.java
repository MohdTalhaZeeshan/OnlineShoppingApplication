package com.jsp.OnlineShoping.dao;

import java.util.List;

import com.jsp.OnlineShoping.model.CustomerInfo;


public interface UserDao {
        
	void userRegistration(CustomerInfo customerInfo);
  	boolean userLogIn(String emailId,String Password);
  	void Shopping();
}
