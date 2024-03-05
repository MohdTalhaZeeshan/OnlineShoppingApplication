package com.jsp.OnlineShoping.dao;

public interface AdminDao {
	
	void deleteCustomerBasedOnPhoneNumber(String mobileNumber);
	void selectCustomerInformation(String name);
	void purchasedListOfCustomerBasedOnMobileNumber(String mobileNumber);
     
}
