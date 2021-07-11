package com.abc.simplehouse.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@SuppressWarnings("deprecation")
@Entity
@Table(name="customer_tbl")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerId;
	
	
	@NotEmpty(message="Please provide your name")
	@Size(min=2,max=20,message="Name should contain 2 to 20 characters")
	private String customerName;
	@NotEmpty(message="plese provide Address")
	private String address;
	
	@NotEmpty(message="please provide Email")
	@Email(message="Please enter valid Email")
	private String customerEmail;
	
	
	@NotEmpty(message="please provide Phonenumber")
	@Size(min=10,max=10,message="Phone Number should contain 10 digits")
	private String phoneNumber;
	
	@Size(min=4,max=8,message="Password should contain 4 to 8 characters")
	@NotEmpty(message="please provide Password")
	private String customerPassword;
	
	@OneToOne(cascade = CascadeType.ALL)
	private FoodCart cart;
	
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
    private List<Order> order=new ArrayList<>();

	
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
