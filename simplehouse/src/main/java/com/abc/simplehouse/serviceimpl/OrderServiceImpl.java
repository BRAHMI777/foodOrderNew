package com.abc.simplehouse.serviceimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.simplehouse.entity.CartItem;
import com.abc.simplehouse.entity.Customer;
import com.abc.simplehouse.entity.FoodCart;
import com.abc.simplehouse.entity.FoodItem;
import com.abc.simplehouse.entity.Order;
import com.abc.simplehouse.entity.OrderItem;
import com.abc.simplehouse.entity.Payment;
import com.abc.simplehouse.exceptions.CartItemNotFoundException;
import com.abc.simplehouse.exceptions.CartNotFoundException;
import com.abc.simplehouse.exceptions.OrderNotFoundException;
import com.abc.simplehouse.repository.CartItemRepository;
import com.abc.simplehouse.repository.FoodCartRepository;
import com.abc.simplehouse.repository.OrderItemRepository;
import com.abc.simplehouse.repository.OrderRepository;
import com.abc.simplehouse.repository.PaymentRepository;
import com.abc.simplehouse.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private FoodCartRepository foodCartRepository;

	
	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public void createOrder(int foodCartId,double paymentAmount) {

		Order order=new Order();
		
		Optional<FoodCart> optionalFoodCart=foodCartRepository.findById(foodCartId);
		if(optionalFoodCart.isEmpty())
			throw new CartNotFoundException("FoodCart not found with Id "+foodCartId);
		
		FoodCart foodCart=optionalFoodCart.get();
		
		Customer customer=foodCart.getCustomer();
		
		List<CartItem> cartItemsList=foodCart.getCartItems();
		if(cartItemsList.size()<=0)
			throw new CartItemNotFoundException("Please add atleast one food item to place order");
		double totalCost=0;
		Iterator<CartItem> i=cartItemsList.iterator();
	
		List<OrderItem> orderItemList=new ArrayList<>();
		while(i.hasNext())
		{	
			OrderItem orderItem=new OrderItem();
			CartItem cartItem=i.next();
			FoodItem foodItem=cartItem.getFoodItem();
			totalCost=totalCost+(foodItem.getItemPrice()*cartItem.getQuantity());
			orderItem.setFoodItem(foodItem);
			orderItem.setQuantity(cartItem.getQuantity());
			orderItemList.add(orderItem);
			orderItemRepository.save(orderItem);
		
		}
		
		Payment payment=new Payment();
		payment.setPaymentAmount(paymentAmount);
		if(paymentAmount>=totalCost)
		{
			payment.setPaymentStatus("success");
		}
		else
		{
			payment.setPaymentStatus("fail");
		}
		paymentRepository.save(payment);
		
		
		order.setTotalCost(totalCost);
		order.setCustomer(customer);
		order.setPayment(payment);
		orderRepository.save(order);
		
		payment.setOrder(order);
		paymentRepository.save(payment);
		Iterator<OrderItem> i1=orderItemList.iterator();
		while(i1.hasNext())
		{
			OrderItem orderItems=i1.next();
			orderItems.setOrder(order);
			orderItemRepository.save(orderItems);
		}
		
		cartItemRepository.deleteAll();
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


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getOrderStatus(int orderId) {
		Optional<Order> optionalOrder=orderRepository.findById(orderId);
		Order order=optionalOrder.get();
		Payment payment=order.getPayment();
		String s="success";
		if(s.equals(payment.getPaymentStatus()))
		{
			return "Order placed successfylly.";
		}
		else
		{
		   return "Payment is failed. Please place the order again.";
		}
	}

}
