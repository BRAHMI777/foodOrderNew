/**
 * 
 */
package com.abc.simplehouse.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.simplehouse.entity.Customer;
import com.abc.simplehouse.entity.FoodItem;
import com.abc.simplehouse.entity.Order;
import com.abc.simplehouse.entity.OrderItem;
import com.abc.simplehouse.exceptions.CustomerNotFoundException;
import com.abc.simplehouse.exceptions.ItemNotFoundException;
import com.abc.simplehouse.exceptions.NoOrderItemFoundException;
import com.abc.simplehouse.exceptions.OrderNotFoundException;
import com.abc.simplehouse.payload.OrderItemPayload;
import com.abc.simplehouse.repository.CustomerRepository;
import com.abc.simplehouse.repository.FoodItemRepository;
import com.abc.simplehouse.repository.OrderItemRepository;
import com.abc.simplehouse.repository.OrderRepository;
import com.abc.simplehouse.service.OrderItemService;



/**
 * @author BrahmanandaReddy
 * 06-Jul-2021
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private FoodItemRepository foodItemRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	private static final Logger LOGGER =LoggerFactory.getLogger(OrderItemServiceImpl.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(OrderItemPayload orderItemPayload) {
		LOGGER.info("Save Order Item method is started");

		OrderItem orderItem=new OrderItem();	
		
		Optional<Order> optionalOrder=orderRepository.findById(orderItemPayload.getOrderId());
		Order order;
		if(optionalOrder.isEmpty())
			throw new OrderNotFoundException("No order found with order Id "+orderItemPayload.getOrderId());
		else
			order=optionalOrder.get();
			
		
		Optional<FoodItem> optionalFoodItem=foodItemRepository.findById(orderItemPayload.getFoodItemId());
		FoodItem foodItem;
		if(optionalFoodItem.isEmpty())
			throw new ItemNotFoundException("No Food item found with Id "+orderItemPayload.getFoodItemId());
		else
			foodItem=optionalFoodItem.get();
		
		Optional<Customer> optionalCustomer=customerRepository.findById(orderItemPayload.getCustomerId());
		Customer customer;
		if(optionalCustomer.isEmpty())
			throw new CustomerNotFoundException("No customer found with Id "+orderItemPayload.getCustomerId());
		else
			customer=optionalCustomer.get();
		
		orderItem.setOrder(order);
//		orderItem.setFoodItem(foodItem);
//		orderItem.setCustomer(customer);
		orderItem.setQuantity(orderItemPayload.getQuantity());
		
		
		orderItemRepository.save(orderItem);
		LOGGER.info("OrderItem saved successfully");
		}


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<OrderItem> getAllItems() {
		LOGGER.info("getAllItems method is started");
		List<OrderItem> list=new ArrayList<>();
		list=orderItemRepository.findAll();
		if(list.size()>0)
		{
		LOGGER.info("OrderItems fetched successfully");	
		return list;
		}
		else
		{
			LOGGER.error("NoOrderItemFoundException is encounterd");
			throw new NoOrderItemFoundException("No order items found");
		}
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteOrderItem(int orderItemId) {
		LOGGER.info("deleteOrderItem method is started");
		Optional<OrderItem> orderItem=orderItemRepository.findById(orderItemId);
		if(orderItem.isEmpty())
		{
			LOGGER.error("NoOrderItemFoundException is encounterd");
			throw new NoOrderItemFoundException("No order items found with id "+orderItemId);
		}
		else
		{
			orderItemRepository.deleteById(orderItemId);
			LOGGER.info("deleteById executed successfully");	
		}
		
		
	}
}
