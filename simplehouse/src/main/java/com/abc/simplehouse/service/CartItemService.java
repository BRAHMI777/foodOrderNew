/**
 * 
 */
package com.abc.simplehouse.service;

import java.util.Optional;

import com.abc.simplehouse.entity.CartItems;
import com.abc.simplehouse.exceptions.CartItemNotFoundException;
import com.abc.simplehouse.payload.CartItemsPayload;

/**
 * This Service interface contains all the methods of Cart Items.
 * 
 * @author ajay naveen
 *
 */
public interface CartItemService {
	/**
	 * save - This method is used to save the cart items.
	 * 
	 * @param item
	 */
	public void save(CartItemsPayload cartItemsPayload);

	/**
	 * getById - This method is used to get cart items by id.
	 * 
	 * @param cartItemId
	 * @return
	 */
	public Optional<CartItems> getById(int cartItemId);

	/**
	 * deleteCartItems - This method is used to delete cart items.
	 * 
	 * @param cartitem
	 */

	void deleteCartItems(int cartItemId) throws CartItemNotFoundException;

	/**
	 * updateCartItems - This method is used to update cart items.
	 * 
	 * @param cartItemId
	 */
	public CartItems updateCartItems(CartItems cartItems);
}
