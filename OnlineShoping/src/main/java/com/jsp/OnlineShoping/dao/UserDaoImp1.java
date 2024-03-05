package com.jsp.OnlineShoping.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.jsp.OnlineShoping.model.CustomerInfo;
import com.jsp.OnlineShoping.model.CustomerPurchasedList;
import com.jsp.OnlineShoping.model.Products;
import com.jsp.OnlineShoping.model.CustomerPurchasedList;

public class UserDaoImp1 implements UserDao 
{
	static Scanner sc = new Scanner(System.in);
	
	//String name="";
	String select ="select * from products";
	 
	List<Products> list= new ArrayList<Products>();
	CustomerInfo customerInfo= new CustomerInfo();
	List<CustomerPurchasedList>  customerPurchasedList= new ArrayList<CustomerPurchasedList>();
	Connection connection;
	
	private static final String insert= "insert into customer_info(customer_name, customer_mobile_number, customer_email_id, customer_password, customer_address, customer_gender) values (?,?,?,?,?,?)";
	private String url="jdbc:mysql://localhost:3306/teca54_advance_java_project?user=root&password=12345";
    private static final String selectAllTheProducts="select * from products";
	private static final String insertionOfCustomerPurchaseList="insert into customer_purchased_list( product_name, product_price, purchase_quantity, purcahse_date, purcahse_time, customer_id,total_price) values(?,?,?,?,?,?,?)";
	private static final String userLogin=" select * from customer_info where customer_email_id=? and customer_password=? ";
	public void userRegistration(CustomerInfo customerInfo)  {
		
		
		try {
			    //Establishing a Connection.
			Connection connection=DriverManager.getConnection(url);
			
		  //Creating a Platform and making incomplete query as complete query.
			PreparedStatement ps= connection.prepareStatement(insert);
			  ps.setString(1, customerInfo.getCustomerName());
			  ps.setString(2, customerInfo.getCustomerMobileNumber());
			  ps.setString(3, customerInfo.getCustomerEmailId());
			  ps.setString(4, customerInfo.getCustomerPassword());
			  ps.setString(5, customerInfo.getCustomerAddress());
			  ps.setString(6, customerInfo.getCustomerGender());
			  
			  //Execute Process
			int result=  ps.executeUpdate();
			if(result!=0)
			{
				System.out.println("Registration Sucessfull");
				
			}
			
			else
			{
				System.out.println("Enter Valid Data");
			}
			  
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		
	}

	public boolean userLogIn(String emailId, String Password) {
		  
		
		 
		  try {
			  
			  try {
				  System.out.print("Loading");
				Thread.sleep(5000);
				System.out.println("...........!");
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			Connection  connection  = DriverManager.getConnection(url);
			
	             PreparedStatement  ps =connection.prepareStatement(userLogin);
	                 ps.setString(1, emailId );
	                 ps.setString(2, Password);
	                 
	                   ResultSet resultSet= ps.executeQuery();
	                   if(resultSet.next())
	                   {
	                	   customerInfo.setCustomerId(resultSet.getInt("customer_id"));
	                	   customerInfo.setCustomerName(resultSet.getString("customer_name"));
	                	   customerInfo.setCustomerEmailId(resultSet.getString("customer_email_id"));
	                	   customerInfo.setCustomerMobileNumber(resultSet.getString("customer_mobile_number"));
	            //  name=	 resultSet.getString("customer_name");
	                	   return true;
	                   }
	                   
	                   else
	                   {
	                	  return false;
	                   }
	                 
		} 
		  catch (SQLException e) {
		
			e.printStackTrace();
		}
		  
   return false;	
		
	}

	public void Shopping() {
		
	  try {
		 connection= DriverManager.getConnection(url);
		
		
		 try {
			 System.out.print("Loading");
			Thread.sleep(8000);
			
			System.out.println("........!");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		      Statement  st= connection.createStatement();
		      
		         ResultSet  resultSet =st.executeQuery(selectAllTheProducts);
		         
		         int sln=1;
		         if(resultSet.isBeforeFirst())
		         {
		        	
		        	 System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Welcome Mr."+customerInfo.getCustomerName());
		        //	  System.out.println("Welcome Mr."+name);
		        	 System.out.println(" \t Product Name \t Product Price \t Product Brand \t Product Category \t Product Review ");
		        	 while(resultSet.next())
		        	 {
		    	             Products pro= new Products();
		    	             pro.setProductId(resultSet.getInt("product_id"));
		    	             pro.setProductName(resultSet.getString("product_name"));
		    	             pro.setProductPrice(resultSet.getDouble("product_price"));
		    	             pro.setProductQuantity(resultSet.getInt("product_quantity"));
		    	             pro.setProductBrand(resultSet.getString("product_brand"));
		    	             pro.setProductReview(resultSet.getString("product_review"));
		    	             pro.setProductCategory(resultSet.getString("product_category"));
		    	             
		    	             list.add(pro);
		    	             
		    	            
		         System.out.println((sln++)+"\t "+resultSet.getString("product_name")+"\t "+resultSet.getDouble("product_price")+"\t "+resultSet.getString("product_brand")+" \t "+resultSet.getString("product_category")+"\t "+"\t"+"\t"+resultSet.getString("product_review"));
		      
		        	 }
		        	
		         }
		        
		         else
		         {
		        	 System.out.println("Invalid details ");
		        	 // return null;
		         }
		        
		       
	} 
	  
	  catch (SQLException e) {
		
		e.printStackTrace();
	}
	  
	    Collections.sort(list);
	    for(Products p:list)
	    {
	    	System.out.println(p);
	    }
	    
	    double total=0;
	    boolean purchaseStatus=true;
	    while(purchaseStatus)
	    {
	     System.out.println("Enter the S.No To Buy the Products : ");
	     int num=sc.nextInt();
	     System.out.println("Enter the Number Of Quantity: ");
	     int quantity=sc.nextInt();
	     Products  selectedProducts=  list.get(num-1);
	    
	   CustomerPurchasedList customerPurchase=new CustomerPurchasedList();
	      customerPurchase.setCustomerId(customerInfo.getCustomerId());
	     customerPurchase.setPurchaseId(customerInfo.getCustomerId());
	     customerPurchase.setProductName(selectedProducts.getProductName());
	     customerPurchase.setProductPrice(selectedProducts.getProductPrice());
	     customerPurchase.setPurcahseDate(LocalDate.now());
	     customerPurchase.setPurcahseTime(LocalTime.now());
	     customerPurchase.setPurchaseQuantity(quantity);
	     customerPurchase.setTotalPrice(quantity*selectedProducts.getProductPrice());
	     
	     String selectedPro=selectedProducts.getProductName();
	     
	     
	     String update="update products set product_quantity=product_quantity-? where product_name=?";
	     
	      Connection connection;
		try {
			connection = DriverManager.getConnection(url);
			
	     PreparedStatement 	ps=connection.prepareStatement(update);
	           ps.setInt(1, quantity);
	           ps.setString(2, selectedPro);
	           
	           int  result= ps.executeUpdate();
	           if(result!=0)
	           {
	        	   System.out.println("Updated Successfully");
	           }
	           else
	           {
	        	   System.out.println("Invalid Name or Details");
	           }
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	     
	       try {
			connection =DriverManager.getConnection(url);
			     //   Statement st        connection.createStatement();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	       
	     
	     total=total+quantity*selectedProducts.getProductPrice();
	     customerPurchasedList.add(customerPurchase);
	     System.out.println(" Do You want to buy more Products ");
	     String response=sc.next();
	     
	     if(response.equalsIgnoreCase("yes"))
	     {
	    	 purchaseStatus=true;
	     }
	     
	     else
	     {
	    	 purchaseStatus=false;
	    	 System.out.println(customerPurchasedList);
	    	 System.out.println("Total Price : "+total);
	    	 
	    	 System.out.println("Enter bill Amount: ");
	    	 double billAmount=sc.nextDouble();
	    	 if(billAmount==total)
	    	 {
	    	 
	    	 try {
	    		 connection =DriverManager.getConnection(url);
		    	 PreparedStatement ps= connection.prepareStatement(insertionOfCustomerPurchaseList);
		    	 for(CustomerPurchasedList cpl:customerPurchasedList)
		    	 {
		    		 
		    		 ps.setString(1, cpl.getProductName());
		    		 ps.setDouble(2, cpl.getTotalPrice());
		    		 ps.setInt(3, cpl.getPurchaseQuantity());
		    		 ps.setDate(4, Date.valueOf(cpl.getPurcahseDate()));
		    		 ps.setTime(5, Time.valueOf(cpl.getPurcahseTime()));
		    		 ps.setInt(6, cpl.getCustomerId());
		    		 ps.setDouble(7, cpl.getTotalPrice());
		    		 ps.addBatch();//single time adding into multiple rows.
		    	 }
		    	 
		    	 int [] result=ps.executeBatch();
		    	 if(result.length!=0)
		    	 {
		    		 System.out.println("Your Order is Placed Successfully...........!");
		    		 System.out.println("Thank You Vist Again.");
		    	 }
		    	 
		    	 else
		    	 {
		    		 System.out.println("Server 404");
		    	 }
		     }
		     
		     catch (SQLException e) {
				e.printStackTrace();
			}
		     
		    }
	    	 
	    	 else
		     {
		    	 
		     }
	     }
	     
	    
	    	          	 
	     }
	     
	     
	     
	  
		
	}

}
