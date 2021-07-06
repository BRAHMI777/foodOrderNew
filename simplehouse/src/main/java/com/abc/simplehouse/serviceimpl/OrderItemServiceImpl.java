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

import com.abc.simplehouse.entity.OrderItem;
import com.abc.simplehouse.exceptions.NoOrderItemFoundException;
import com.abc.simplehouse.repository.OrderItemRepository;
import com.abc.simplehouse.service.OrderItemService;



/**
 * @author BrahmanandaReddy
 * 06-Jul-2021
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	private static final Logger LOGGER =LoggerFactory.getLogger(OrderItemServiceImpl.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(OrderItem orderItem) {
		LOGGER.info("Save Order Item method is started");
		Optional<OrderItem> optionalOrderItem=orderItemRepository.findById(orderItem.getId());
		OrderItem orderItemOld=optionalOrderItem.get();
		if(optionalOrderItem.isEmpty())
		{
		orderItemRepository.save(orderItem);
		LOGGER.info("OrderItem saved successfully");
		}
		else
		{
			orderItem.setQuantity(orderItemOld.getQuantity()+orderItem.getQuantity());
			orderItemRepository.save(orderItem);
			LOGGER.info("OrderItem quantity increased successfully");
		}
		
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
