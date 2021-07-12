package com.abc.simplehouse.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.simplehouse.entity.Order;
import com.abc.simplehouse.exceptions.ErrorResponse;
import com.abc.simplehouse.payload.CheckOutPayload;
import com.abc.simplehouse.service.OrderService;

/**
 * This Class is used to call the service.
 * @author BrahmanandaReddy
 * 11-Jul-2021
 */
@RestController
@RequestMapping("/order")
@Validated
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	ErrorResponse errorResponse=new ErrorResponse();
	
	private static final Logger LOGGER =LoggerFactory.getLogger(FoodItemController.class);
	
	/**
	 * This method is used to add order
	 * @param order
	 * 06-Jul-2021
	 */
	@PostMapping("/checkout")
	public ResponseEntity<ErrorResponse> createOrder(@Valid @RequestBody CheckOutPayload cartPayload)
	{
		LOGGER.info("Path:/order/checkout");
		LOGGER.info("createorder method is started");
		orderService.createOrder(cartPayload.getFoodCartId(),cartPayload.getPaymentAmount(),cartPayload.getDeliveryAddress());
		LOGGER.info("createOrder method is started");
		errorResponse.setMsg("Order created successfully.");
		errorResponse.setStatusCode(201);
		return new ResponseEntity<>(errorResponse,HttpStatus.CREATED);
	
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
		errorResponse.setMsg("Order updated successfully.");
		errorResponse.setStatusCode(200);
		 return new ResponseEntity<>(errorResponse,HttpStatus.OK);
	}
	
	/**
	 * This method is used to get the order.
	 * @param orderId
	 * 06-Jul-2021
	 */
	@GetMapping("/orderstatus/{id}")
	public String getOrderStatus(@PathVariable("id") int orderId)
	{
		String status=orderService.getOrderStatus(orderId);
		return status;
	}
}
