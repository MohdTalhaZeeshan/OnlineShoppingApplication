package com.jsp.OnlineShoping.model;

import java.util.Scanner;

public class CustomerInfo {
	static Scanner sc = new Scanner(System.in);
	
	private int customerId;
	private String customerName;
	private String customerMobileNumber;
	private String customerEmailId;
	private String customerPassword;
	private String  customerAddress;
	private String customerGender;
	
	public CustomerInfo(int customerId, String customerName, String customerMobileNumber, String customerEmailId,
			String customerPassword, String customerAddress, String customerGender) {
		
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerMobileNumber = customerMobileNumber;
		this.customerEmailId = customerEmailId;
		this.customerPassword = customerPassword;
		this.customerAddress = customerAddress;
		this.customerGender = customerGender;
	}

	public CustomerInfo() {
		
		
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		while(true)
        {
      	  
        int Alpha=0;
        int digits=0;
        int symbol=0;
      
        
     
        for(int i=0;i<customerName.length();i++)
        {
      	  char cha= customerName.charAt(i);
      	  
      	  if(Character.isAlphabetic(cha))
      	  {
      		  Alpha++;
      	  }
      	  
      	  if(Character.isDigit(cha))
      	  {
      		 digits++;
      	  }
      	  
     
      	  
      	   if(!Character.isLetterOrDigit(cha))
      	  {
      		  
      		   
      		   int num=(int)cha;
       		  if(num!=32)
       		  {
      			 symbol++;
       		  }
      		  
      	  }
        }
        
       // System.out.println(space);
       // System.out.println(symbol);
        
         if(Alpha>=4 && digits==0 && symbol==0)
         { 	  
      	   System.out.println(customerName);
      	 this.customerName = customerName;
           break;
         }
         
         else
         {
      	   System.out.println("Enter your name : ");
      	   customerName =sc.nextLine();
         }
         
        }
        
		
	}

	public String getCustomerMobileNumber() {
		return customerMobileNumber;
	}

	public void setCustomerMobileNumber(String customerMobileNumber) {
		
		while(true)
        {
        
       if(customerMobileNumber.length()==10)
       {
      	 long number=Long.parseLong(customerMobileNumber);
      	 
      	this.customerMobileNumber = customerMobileNumber;
      	 break;
       }
        
       else
       {
      	 System.out.println("Enter your mobile number : ");
      	customerMobileNumber=sc.next();
       }         
        }
		
	}

	public String getCustomerEmailId() {
		return customerEmailId;
	}

	public void setCustomerEmailId(String customerEmailId) {
		
		while(true)
        {
      	  
      	  int countDigit=0;
            int countAlpha=0;
            
            for(int i=0;i<customerEmailId.length();i++)
            {
          	char ch=  customerEmailId.charAt(i);
          	
          	if(Character.isAlphabetic(ch))
          	{
          		countAlpha++;
          	}
          	
          	else if(Character.isDigit(ch))
          	{
          		int n= (int) ch;
          		
          		if(n>=49)
          		{
          		countDigit++;
          		}
          	}
            }
            
        String mail="";
      
        for(int i=customerEmailId.length()-1;i>=0;i--)
        {
      	  char ch=customerEmailId.charAt(i);
      	 
      	  mail=ch+mail;
      	  
      	  if(ch=='@')
      	  {
      	  break;
      	  }
      	  
        }
       
        if(countAlpha>=3 && countDigit>=1 && countDigit<=3 && mail.equals("@gmail.com"))
        {
      	  
        	this.customerEmailId = customerEmailId;
      	 break;
      	 
        }
        else
        {
      	  System.out.println("Enter your emailId : ");
      	customerEmailId=sc.next();
        }
       
        
        }
      
		
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		 while(true)
         {

             int countUp=0;
             int countLow=0;
             int countDigt=0;
             int countSym=0;
       	  
       	  for(int i=0;i<customerPassword.length();i++)
             {
           	  char ch = customerPassword.charAt(i);
           	  
           	  if(Character.isUpperCase(ch))
           	  {
           		  countUp++;
           	  }
           	  
           	  else if(Character.isLowerCase(ch))
           	  {
           		  countLow++;
           	  }
           	  
           	  else if(!Character.isLetterOrDigit(ch))
           	  {
           		  countSym++;
           	  }
           	  
           	  else if(Character.isDigit(ch))
           	  {
           		  countDigt++;
           	  }
             }
       	  
         if(countDigt==1 && countLow==1 && countUp==1 && countSym==1)
         {
       	 
        	 this.customerPassword = customerPassword;
            break;
         }
         else
         {
       	  System.out.println("Enter your password : ");
       	customerPassword=sc.next();
       	  
         }
         
         }
         
		
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	@Override
	public String toString() {
		return "customerInfo [customerId=" + customerId + ", customerName=" + customerName + ", customerMobileNumber="
				+ customerMobileNumber + ", customerEmailId=" + customerEmailId + ", customerPassword="
				+ customerPassword + ", customerAddress=" + customerAddress + ", customerGender=" + customerGender
				+ "]";
	}
	
	
	
	
	
	
	
	
}
