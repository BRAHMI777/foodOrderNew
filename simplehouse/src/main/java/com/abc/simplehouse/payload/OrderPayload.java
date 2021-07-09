package com.abc.simplehouse.payload;

import java.util.List;

import com.abc.simplehouse.entity.OrderItem;

public class OrderPayload {
	
	
	private int customerId;
	private int paymentId;
	private List<OrderItem> orderItems;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
