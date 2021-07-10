/**
 * 
 */
package com.abc.simplehouse.payload;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author BrahmanandaReddy
 * 09-Jul-2021
 */
public class CheckOutPayload {
	
	@NotNull(message="Food cart id is missing")
	private int foodCartId;
	
	@NotNull(message="Payment amount is missing")
	private double paymentAmount;
	
	@NotEmpty(message="Delivery address is missing")
	private String deliveryAddress;

	public int getFoodCartId() {
		return foodCartId;
	}

	public void setFoodCartId(int foodCartId) {
		this.foodCartId = foodCartId;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
	
	}
	
