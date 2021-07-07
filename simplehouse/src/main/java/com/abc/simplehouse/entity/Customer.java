package com.abc.simplehouse.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer_tbl")
public class Customer {
	
	@Id
	private int customerId;
	private String customerName;
	private String address;
	private String customerEmail;
	private String phoneNumber;
	private String customerPassword;
	
	@OneToOne
	private FoodCart cart;
	
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
    private List<Order> order=new ArrayList<>();
	
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
	private List<OrderItem> orderItem=new ArrayList<>();
	
	public FoodCart getCart() {
		return cart;
	}
	public void setCart(FoodCart cart) {
		this.cart = cart;
	}
	public List<Order> getOrder() {
		return order;
	}
	public void setOrder(List<Order> order) {
		this.order = order;
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
	public void setCustomerName(String customerFirstName) {
		this.customerName = customerFirstName;
	}
	public String getAdress() {
		return address;
	}
	public void setAdress(String adress) {
		this.address = adress;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
}
