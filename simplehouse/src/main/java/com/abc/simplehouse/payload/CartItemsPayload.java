/**
 * 
 */
package com.abc.simplehouse.payload;

/**
 * @author brahm
 * 08-Jul-2021
 */
public class CartItemsPayload {
	
	private int quantity;
	private int foodItemId;
	private int foodCartId;
	
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
	public int getFoodCartId() {
		return foodCartId;
	}
	public void setFoodCartId(int foodCartId) {
		this.foodCartId = foodCartId;
	}
	
	

}
