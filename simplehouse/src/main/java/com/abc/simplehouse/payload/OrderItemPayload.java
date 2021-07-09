/**
 * 
 */
package com.abc.simplehouse.payload;

/**
 * @author brahm
 * 07-Jul-2021
 */
public class OrderItemPayload {
	
		
	  private int quantity;
	  private int foodItemId;
	  private int OrderId;
	  private int customerId;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getFoodItemId() {
		return foodItemId;
	}
	public void setFoodItemId(int foodItemId) {
		this.foodItemId = foodItemId;
	}
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	  
	  

}
