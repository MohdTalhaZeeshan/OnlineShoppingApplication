package com.jsp.OnlineShoping;

import java.util.List;
import java.util.Scanner;

import com.jsp.OnlineShoping.dao.AdminDao;
import com.jsp.OnlineShoping.dao.AdminDaoimpl1;
import com.jsp.OnlineShoping.dao.UserDao;
import com.jsp.OnlineShoping.dao.UserDaoImp1;
import com.jsp.OnlineShoping.model.CustomerInfo;
import com.jsp.OnlineShoping.model.Products;

/**
 * Hello world!
 *
 */
 public class App 
{
	static Scanner sc = new Scanner(System.in);
    public static void main( String[] args )
    {
    	AdminDao ad=  new AdminDaoimpl1();
          UserDao dao= new UserDaoImp1();// upcasting 
          
          
          while(true)
          {
        	  System.out.println("Enter: ");
        	  System.out.println("1.For User Registration");
        	  System.out.println("2.For Admin LogIn");
        	  System.out.println("3.For User LogIn");
        	  System.out.println("4.Enter deleteCustomerBasedOnPhoneNumber");
  			  System.out.println("5.Enter selectCustomerInformation");
  			  System.out.println("6.Enter purchasedListOfCustomerBasedOnMobileNumber");
        	  System.out.println("Enter your choice : ");
        	  int choice = sc.nextInt();
        	  
        	  switch(choice)
        	  {
        	  case 1:
        	  {
        		  CustomerInfo customerInfo= new CustomerInfo();
        		  
        		 // System.out.println("Enter name : ");
        		    String name=sc.nextLine();
        		   customerInfo.setCustomerName(name);
        		   
        		   System.out.println("Enter mobile number : ");
        		   String mobileNumber=sc.next();
        		   customerInfo.setCustomerMobileNumber(mobileNumber);
        		   
        		   System.out.println("Enter emailId: ");
        		   String emailId=sc.next();
        		   customerInfo.setCustomerEmailId(emailId);
        		   
        		   System.out.println("Enter password : ");
        		   String password=sc.next();
        		   customerInfo.setCustomerPassword(password);
        		   
        		   System.out.println("Enter Address: ");
        		   String address=sc.next();
        		   customerInfo.setCustomerAddress(address);
        		   
        		   System.out.println("Enter gender: ");
        		   String gender=sc.next();
        		   customerInfo.setCustomerGender(gender);
        		  
        		  
        		  dao.userRegistration(customerInfo);
        		  break;
        	  }
        	  
        	  
        	  case 2:
        	  {
        		  System.out.println("Admin LogIn");
        		  
        		  break;  
        	  }
        	  
        	  case 3:
        	  {
        		  boolean loginStatus=true;
        		  
        		  while(loginStatus)
        		  {
        		  System.out.println("Enter email id : ");
        		  String email=sc.next();
        		  
        		  System.out.println("Enter password: ");
        		  String pass=sc.next();
        		  
        		  
        		  
        	boolean result=	  dao.userLogIn(email, pass);
        	
        	if(result)	
        	{
        		  
        		loginStatus=false;
        		System.out.println("Enter "
        				+"\n 1. To Buy the Products"
        				+"\n 2.For MY Purchase List");
        		
        		System.out.println("Enter your option: ");
        		int userOption=sc.nextInt();
        		switch(userOption)
        		{
        		case 1:
        		{
        	    dao.Shopping();
        	     
        			break;
        		}
        		
        		case 2:
        		{
        			break;
        		}
        		
        		default: break;
        			 
        		}
        		                 ;
        	}
        	
        	else
        	{
        		System.out.println("Enter Invalid details");
        		loginStatus=true;
        	}
        		  break;
        	  }
        	  }
        	  
        	  case 4:
        	  {
        		  System.out.println("Enter the mobile number : ");
  				String mobileNumber=sc.next();
  				ad.deleteCustomerBasedOnPhoneNumber(mobileNumber);
  				break;

             	  }
        	  
        	  case 5:
        	  {
        		  System.out.println("Enter the name: ");
  				String name=sc.next();
  				ad.selectCustomerInformation(name);
  				break;
        	  }
        	  
        	  case 6:
        	  {
        		  System.out.println("Enter the mobile number : ");
  				String mobileNumber=sc.next();
  				ad.purchasedListOfCustomerBasedOnMobileNumber(mobileNumber);
  				break;
        	  }
        	  
        	  default:
        		  break;
        	  }
        	  
          }
          
          
          
    }
}
