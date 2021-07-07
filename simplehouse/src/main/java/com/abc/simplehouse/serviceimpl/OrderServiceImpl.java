package com.abc.simplehouse.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.simplehouse.entity.Customer;
import com.abc.simplehouse.entity.Order;
import com.abc.simplehouse.entity.OrderItem;
import com.abc.simplehouse.entity.Payment;
import com.abc.simplehouse.exceptions.OrderAlreadyExistingException;
import com.abc.simplehouse.exceptions.OrderNotFoundException;
import com.abc.simplehouse.payload.OrderPayload;
import com.abc.simplehouse.repository.CustomerRepository;
import com.abc.simplehouse.repository.FoodItemRepository;
import com.abc.simplehouse.repository.OrderItemRepository;
import com.abc.simplehouse.repository.OrderRepository;
import com.abc.simplehouse.repository.PaymentRepository;
import com.abc.simplehouse.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
//	@Autowired
//	private OrderItemRepository orderItemRepository;
//	
//	@Autowired
//	private FoodItemRepository foodItemRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createOrder(OrderPayload orderPayload) throws OrderAlreadyExistingException {
//		//Optional<Order> optionalOrder= orderRepository.findById(order.getId());
//		if(optionalOrder.isEmpty())
//		{
//		orderRepository.save(order);
//		}
//		else
//		{
//			throw new OrderAlreadyExistingException("The Order is already existing with id "+order.getId());
//		}
		Order order=new Order();
		Optional<Customer> optionalCustomer=customerRepository.findById(orderPayload.getCustomerId());
		Customer customer=optionalCustomer.get();
		
		Optional<Payment> optionalPayment=paymentRepository.findById(orderPayload.getPaymentId());
		Payment payment=optionalPayment.get();
		
		List<OrderItem> list=new ArrayList<>();
	
		order.setCustomer(customer);
		order.setPayment(payment);
		order.setOrderItems(list);
		order.setId(orderPayload.getOrderId());
		order.setTotalCost(1000);
		order.setOrderDate(orderPayload.getOrderDate());
		orderRepository.save(order);
		
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
		if(optionalOrder.isEmpty())
		{
			throw new OrderNotFoundException("No order found with id "+orderId);
		}
		else
		{
		order=optionalOrder.get();
		order.setTotalCost(2000);
		orderRepository.save(order);
		}
		
	}

}
