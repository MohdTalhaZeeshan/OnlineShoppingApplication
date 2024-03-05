package com.jsp.OnlineShoping.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

public class CustomerPurchasedList {
	
    private int purchaseId;
   
	private String productName;
    private double productPrice;
    private int purchaseQuantity; 
    private LocalDate purcahseDate;
    private  LocalTime purcahseTime;
    private int customerId;
    private double totalPrice;
    
    
	public CustomerPurchasedList() {
		
	}


	public CustomerPurchasedList(int purchaseId, String productName, double productPrice, int purchaseQuantity,
			LocalDate purcahseDate, LocalTime purcahseTime, int customerId, double totalPrice) {
		super();
		this.purchaseId = purchaseId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.purchaseQuantity = purchaseQuantity;
		this.purcahseDate = purcahseDate;
		this.purcahseTime = purcahseTime;
		this.customerId = customerId;
		this.totalPrice = totalPrice;
	}


	public int getPurchaseId() {
		return purchaseId;
	}


	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


	public int getPurchaseQuantity() {
		return purchaseQuantity;
	}


	public void setPurchaseQuantity(int purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}


	public LocalDate getPurcahseDate() {
		return purcahseDate;
	}


	public void setPurcahseDate(LocalDate purcahseDate) {
		this.purcahseDate = purcahseDate;
	}


	public LocalTime getPurcahseTime() {
		return purcahseTime;
	}


	public void setPurcahseTime(LocalTime purcahseTime) {
		this.purcahseTime = purcahseTime;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	@Override
	public String toString() {
		return "customerPurchasedList [purchaseId=" + purchaseId + ", productName=" + productName + ", productPrice="
				+ productPrice + ", purchaseQuantity=" + purchaseQuantity + ", purcahseDate=" + purcahseDate
				+ ", purcahseTime=" + purcahseTime + ", customerId=" + customerId + ", totalPrice=" + totalPrice + "]";
	}


	
	 
	

}
