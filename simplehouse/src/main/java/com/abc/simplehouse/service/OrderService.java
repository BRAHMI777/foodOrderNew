package com.abc.simplehouse.service;

import java.util.List;
import java.util.Optional;

import com.abc.simplehouse.entity.Order;
import com.abc.simplehouse.exceptions.OrderNotFoundException;

public interface OrderService {
	
	/**
	 * This method is used to add order
	 * @param order
	 * 06-Jul-2021
	 */
	public void createOrder(Order order);

	/**
	 * This method is used to get all orders.
	 * @param void
	 * @return List<Order>
	 * 06-Jul-2021
	 */
	public List<Order> fetchAllOrders();

	/**
	 * This method is used to get order by orderId.
	 * @param orderId
	 * @return Order
	 * 06-Jul-2021
	 */
	public Optional<Order> findById(int orderId) throws OrderNotFoundException;

	/**
	 * This method is used to update the order.
	 * @param orderId
	 * 06-Jul-2021
	 */
	public void updateOrderById(int orderId);
	

}
