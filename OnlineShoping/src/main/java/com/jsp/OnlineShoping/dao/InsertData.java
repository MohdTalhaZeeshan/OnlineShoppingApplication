package com.jsp.OnlineShoping.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class InsertData {
	
	
	
	
	public static void main(String[] args) throws IOException, SQLException {
		
		String insert= " insert into products values (101,'Iphone 15',150000,20,'IPhone','*****','Mobile'),"
				+ "(102,'Samsung Galaxy 25',350000,15,'Samsung','****','Mobile'),"
				+ "(103,'Laptop',1500000,50,'Dell','****','Electronic'),"
				+ "(104,'Boat',3999,50,'Boat','***','Electronic'),"
				+ "(105,'PHILIPS MMS26',3409,60,'Philips','****','Electronic')";
		
		FileInputStream fis= new FileInputStream("D:\\TECA54_ADVANCEJAVA\\OnlineShoping\\src\\main\\java\\com\\jsp\\OnlineShoping\\properties\\application.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		//establishing a connection
  Connection connection =   DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("mysqlusername"),prop.getProperty("password"));
  
  
                     //creating a platform
           Statement st=connection.createStatement();
           
           // execute process
            int result= st.executeUpdate(insert);
            if(result!=0)
            {
            	System.out.println(result);
            	System.out.println("Record inserted");
            }
            
            else
            {
            	System.err.println("Data not inserted");
            }
		      
	}
	
	
	

}
