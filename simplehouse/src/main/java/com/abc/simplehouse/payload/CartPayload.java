/**
 * 
 */
package com.abc.simplehouse.payload;

/**
 * @author BrahmanandaReddy
 * 09-Jul-2021
 */
public class CartPayload {
	
	private int foodCartId;
	private double paymentAmount;
	
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
	
	

}
