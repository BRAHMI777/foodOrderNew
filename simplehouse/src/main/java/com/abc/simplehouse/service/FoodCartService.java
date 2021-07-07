/**
 * 
 */
package com.abc.simplehouse.service;

import java.util.Optional;

import com.abc.simplehouse.entity.FoodCart;

/**
 * This Service interface contains all the methods of Food Cart.
 * 
 * @author ajay naveen
 *
 */
public interface FoodCartService {
	/**
	 * save-"This method is used to save the cart"
	 * 
	 * @param cart
	 */
	public void save(FoodCart cart);

	/**
	 * getById-"This method is used to get cart by id"
	 * 
	 * @param foodCartId
	 * @return
	 */
	public Optional<FoodCart> getById(int foodCartId);

	/**
	 * deleteCart- This method is used to delete the cart by id.
	 * 
	 * @param foodCartId
	 */
	public void deleteCart(int foodCartId);

}
