package com.abc.simplehouse.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.simplehouse.entity.Order;
import com.abc.simplehouse.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	private static final Logger LOGGER =LoggerFactory.getLogger(FoodItemController.class);
	
	/**
	 * This method is used to add order
	 * @param order
	 * 06-Jul-2021
	 */
	@PostMapping("/addorder")
	public ResponseEntity<?> createOrder(@RequestBody Order order)
	{
		LOGGER.info("Path:/order/addorder");
		LOGGER.info("createorder method is started");
		orderService.createOrder(order);
		ResponseEntity<String> responseEntity=new ResponseEntity<>("Order created successfully.",HttpStatus.CREATED);
		LOGGER.info("createOrder method is started");
		return responseEntity;
	}
	

	/**
	 * This method is used to get all orders.
	 * @param void
	 * @return List<Order>
	 * 06-Jul-2021
	 */
	@GetMapping("/allorders")
	public List<Order> findAllOrders()
	{
		LOGGER.info("Path:/order/allorders");
		LOGGER.info("fetchAllOrders method is started");
		List<Order> orderList=orderService.fetchAllOrders();
		LOGGER.info("fetchAllOrders method is started");
		return orderList;
	}
	
	
	/**
	 * This method is used to get order by orderId.
	 * @param orderId
	 * @return Order
	 * 06-Jul-2021
	 */
	@GetMapping("/{id}")
	public Optional<Order> getById(@PathVariable("id") int orderId)
	{
		LOGGER.info("Path:/order/id");
		LOGGER.info("findById method is started");
		Optional<Order> order=orderService.findById(orderId);
		LOGGER.info("findById method is started");
		return order;
	}
	
	/**
	 * This method is used to update the order.
	 * @param orderId
	 * 06-Jul-2021
	 */
	@PutMapping("/updateorder/{id}")
	public ResponseEntity<?> updateOrder(@PathVariable("id") int orderId)
	{
		LOGGER.info("Path:/order/updateorder/id");
		LOGGER.info("updateOrderById method is started");
		orderService.updateOrderById(orderId);
		LOGGER.info("updateOrderById method is started");
		return new ResponseEntity<>("Order updated successfully.",HttpStatus.OK);
	}

}
