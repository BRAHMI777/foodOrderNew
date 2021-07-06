/**
 * 
 */
package com.abc.simplehouse.service;

import java.util.List;

import com.abc.simplehouse.entity.OrderItem;

/**
 * @author BrahmanandaReddy
 * 06-Jul-2021
 */
public interface OrderItemService {
	
	
	/**
	 * This method is used to save the order item.
	 * @param orderItem
	 * 06-Jul-2021
	 */
	public void save(OrderItem orderItem);

	/**
	 * This method is used to get all the products.
	 * @return List<OrderItem>
	 * 06-Jul-2021
	 */
	public List<OrderItem> getAllItems();

	/**
	 * This method is used to delete the order item by id.
	 * @param orderItemId
	 * 06-Jul-2021
	 */
	public void deleteOrderItem(int orderItemId);

}
