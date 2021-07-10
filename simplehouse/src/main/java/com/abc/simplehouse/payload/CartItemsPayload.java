/**
 * 
 */
package com.abc.simplehouse.payload;

import javax.validation.constraints.NotNull;

/**
 * @author brahm
 * 08-Jul-2021
 */
public class CartItemsPayload {
	
	@NotNull(message="Please enter quantity")
	private int quantity;
	@NotNull(message="Please enter FoodItem Id")
	private int foodItemId;
	@NotNull(message="Please enter FoodCart Id")
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
