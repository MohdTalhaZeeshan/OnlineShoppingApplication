package com.jsp.OnlineShoping.model;

public class Products implements Comparable<Products>
{
	
	private int productId;
	private String productName;
	private double productPrice; 
	private int productQuantity;
	private String productBrand; 
	private String productReview;
	private String productCategory;
	

	public Products(int productId, String productName, double productPrice, int productQuantity, String productBrand,
			String productReview, String productCategory) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.productBrand = productBrand;
		this.productReview = productReview;
		this.productCategory = productCategory;
	}
	public Products() {
		
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public String getProductReview() {
		return productReview;
	}
	public void setProductReview(String productReview) {
		this.productReview = productReview;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	
	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productQuantity=" + productQuantity + ", productBrand=" + productBrand + ", productReview="
				+ productReview + ", productCategory=" + productCategory + "]";
	}
	public int compareTo(Products o) {
		
		if(this.productPrice>o.productPrice)
		{
			return 1;
		}
		
		else
		{
			return -1;
		}
	}

	 

}
