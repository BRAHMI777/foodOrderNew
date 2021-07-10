package com.abc.simplehouse.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "ORDER_TBL")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull(message="order id should be present")
	private int orderId;

	@GeneratedValue(strategy=GenerationType.AUTO)
	private LocalDate orderDate=LocalDate.now();   //2007-12-03.
	
	private double totalCost;
	
	private String deliveryAdress;
    private int totalQuantity;

	
	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getDeliveryAdress() {
		return deliveryAdress;
	}

	public void setDeliveryAdress(String deliveryAdress) {
		this.deliveryAdress = deliveryAdress;
	}

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> orderItems;

	
	@ManyToOne
	@JoinColumn(name = "customerId")
	@JsonBackReference
	private Customer customer;

	@OneToOne
	private Payment payment;
	
	/**
	 * This method is to get totalCost.
	 * @return
	 * 09-Jul-2021
	 */
	public double getTotalCost() {
		return totalCost;
	}

	
	/**
	 * This method is used to set totalcost.
	 * @param totalCost
	 * 09-Jul-2021
	 */
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	
	/**
	 * This method is to get order Id.
	 * @return
	 * 09-Jul-2021
	 */
	public int getOrderId() {
		return orderId;
	}

	
	/**
	 * This method is used to set Id.
	 * @param orderId
	 * 09-Jul-2021
	 */
	public void setId(int orderId) {
		this.orderId = orderId;
	}

	
	/**
	 * This method is to get order Date.
	 * @return
	 * 09-Jul-2021
	 */
	public LocalDate getOrderDate() {
		return orderDate;
	}

	
	/**
	 * This method is used to set Date.
	 * @param orderDate
	 * 09-Jul-2021
	 */
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	
	/**
	 * This method is to get orderItems.
	 * @return
	 * 09-Jul-2021
	 */
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	/**
	 * This method is used to set List of orderItems.
	 * @param orderItems
	 * 09-Jul-2021
	 */
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	/**
	 * This method is to get customer.
	 * @return
	 * 09-Jul-2021
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * This method is used to set Customer.
	 * @param customer
	 * 09-Jul-2021
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	/**
	 * This method is to get payment.
	 * @return
	 * 09-Jul-2021
	 */
	public Payment getPayment() {
		return payment;
	}

	/**
	 * This method is used to set payment.
	 * @param payment
	 * 09-Jul-2021
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
}
