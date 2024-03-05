package com.jsp.OnlineShoping.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsp.OnlineShoping.model.CustomerInfo;

public class AdminDaoimpl1 implements AdminDao
{
	String url="jdbc:mysql://localhost:3306/teca54_advance_java_project?user=root&password=12345";
	static CustomerInfo customerInfo = new CustomerInfo();

	public void deleteCustomerBasedOnPhoneNumber(String mobileNumber) {
		 
		 String delete="delete from customer_info where customer_mobile_number=?";
		 
		try {
			Connection connection=DriverManager.getConnection(url);
			
			              PreparedStatement ps= connection.prepareStatement(delete);
			              ps.setString(1, mobileNumber);
			              
			        int  result=  ps.executeUpdate();
			        if(result!=0)
			        {
			        	System.out.println("Customer successfully deleted");
			        }
			        
			        else
			        {
			        	System.out.println("Invalid Number");
			        }
		} 
		
		catch (SQLException e) 
		{
						e.printStackTrace();
		}
		  
    
		
		
	}

	public void selectCustomerInformation(String name) {
		
		             String select ="select * from customer_info where customer_name=? ";
		             
		      try {
				Connection   connection=DriverManager.getConnection(url);
				
				              PreparedStatement ps= connection.prepareStatement(select);
				              ps.setString(1, name);
				              
				              ResultSet  resultSet = ps.executeQuery();
				               
				                 if(resultSet.next())
				                 {
				                	 System.out.print(" customer_id : "+resultSet.getInt("customer_id")+" ");
				                	 System.out.print(" customer_name : "+resultSet.getString("customer_name")+" ");
				                	 System.out.print("customer_mobile_number : "+resultSet.getString("customer_mobile_number")+" ");
				                	 System.out.print(" customer_email_id :  "+resultSet.getString("customer_email_id")+" ");
				                	 System.out.print( "customer_password :"+resultSet.getString("customer_password")+" ");
				                	 System.out.print(" customer_address : "+resultSet.getString("customer_address")+" ");
				                	 System.out.println(" customer_gender : "+resultSet.getString("customer_gender"));
				                 }
				                 else
				                 {
				                	 System.out.println("Invalid Name ");
				                 }
				     
			} 
		      catch (SQLException e) {
				
				e.printStackTrace();
			}
	
		
	}

	public void purchasedListOfCustomerBasedOnMobileNumber(String mobileNumber) {
		
		String select="select * from customer_purchased_list where customer_id=(select customer_id  from customer_info where customer_mobile_number=?)";
				
		
		try {
			Connection connection = DriverManager.getConnection(url);
			    PreparedStatement ps= connection.prepareStatement(select);
			    ps.setString(1, mobileNumber);
			    
			   ResultSet  resultSet=ps.executeQuery();
			   
			   if(resultSet.isBeforeFirst())
			   {
				   while(resultSet.next())
				   {  
					   
				   
					   System.out.print(" purchaseId : "+resultSet.getInt("purchaseId")+" ");
					   System.out.print("product_name: "+resultSet.getString("product_name")+" ");
					   System.out.print(" product_price: "+resultSet.getDouble("product_price")+" ");
					   System.out.print(" purchase_quantity :"+resultSet.getInt("purchase_quantity")+" ");
					   System.out.print(" purcahse_date : "+resultSet.getDate("purcahse_date")+" ");
					   System.out.print(" purcahse_time : "+resultSet.getTime("purcahse_time")+" ");
					   System.out.print(" customer_id :"+resultSet.getInt("customer_id")+" ");
					   System.out.println(" total price : "+resultSet.getDouble("total_price"));
				   }
				   }
			  
			   
			   else
			   {
				   System.out.println("Invalid Number");
			   }
		} 
		
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	

}
