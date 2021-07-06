package com.abc.simplehouse.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.simplehouse.entity.Order;
import com.abc.simplehouse.exceptions.OrderAlreadyExistingException;
import com.abc.simplehouse.exceptions.OrderNotFoundException;
import com.abc.simplehouse.repository.OrderRepository;
import com.abc.simplehouse.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createOrder(Order order) throws OrderAlreadyExistingException {
		Optional<Order> optionalOrder= orderRepository.findById(order.getId());
		if(optionalOrder.isEmpty())
		{
		orderRepository.save(order);
		}
		else
		{
			throw new OrderAlreadyExistingException("The Order is already existing with id "+order.getId());
		}
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Order> fetchAllOrders()  {
		List<Order> orderList=orderRepository.findAll();
		if(orderList.size()>0)
		{
		return orderList;
		}
		else
		{
			throw new OrderNotFoundException("No orders found");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<Order> findById(int orderId)  {
		Optional<Order> order=orderRepository.findById(orderId);
		if(order.isEmpty())
		{
			throw new OrderNotFoundException("No order found with id "+orderId);
		}
		return order;
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateOrderById(int orderId) {
		Optional<Order> optionalOrder=orderRepository.findById(orderId);
		Order order=new Order();
		order=optionalOrder.get();
		order.setTotalCost(2000);
		orderRepository.save(order);
		
	}

}
