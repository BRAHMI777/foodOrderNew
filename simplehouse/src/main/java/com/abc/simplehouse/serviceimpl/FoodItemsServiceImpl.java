package com.abc.simplehouse.serviceimpl;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.simplehouse.entity.FoodItem;
import com.abc.simplehouse.exceptions.ItemAlreadyExistingException;
import com.abc.simplehouse.exceptions.ItemNotFoundException;
import com.abc.simplehouse.repository.FoodItemRepository;
import com.abc.simplehouse.service.FoodItemsService;

/**
 *
 * This class used to implement all the methods.
 * @author BrahmanandaReddy
 * 06-Jul-2021
 */
@Service
public class FoodItemsServiceImpl implements FoodItemsService {

	@Autowired
	private FoodItemRepository foodItemsRepository;
	
	private static final Logger LOGGER =LoggerFactory.getLogger(FoodItemsServiceImpl.class);
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(FoodItem foodItem) throws ItemAlreadyExistingException {
		LOGGER.info("Save Item method is started");
		Optional<FoodItem> optionaFoodItem=foodItemsRepository.findById(foodItem.getItemId());
		if(optionaFoodItem.isPresent())
		{
			LOGGER.error("ItemAlreadyExistingException is encounterd");
			throw new ItemAlreadyExistingException("This item is already existing with Id "+foodItem.getItemId());
			
		}
		else
		{
		foodItemsRepository.save(foodItem);
		LOGGER.info("FoodItem saved successfully");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FoodItem getById(int foodItemId) throws ItemNotFoundException {
		LOGGER.info("getItemById method is started");
		Optional<FoodItem> foodItem= foodItemsRepository.findById(foodItemId);
		if(foodItem.isEmpty())
		{
			LOGGER.error("ItemNotFoundException is encounterd");
			throw new ItemNotFoundException("Item not found with id "+foodItemId);
		}		
		LOGGER.info("FoodItem fetched successfully");
		FoodItem foodItems=foodItem.get();
		return foodItems;
	}

	/**
	 * {@inheritDoc}
	 */
//	@Override
//	public FoodItem getByName(String foodItemName) {
//		Optional<FoodItem> foodItem= foodItemsRepository.findFoodItemByName(foodItemName);
//		if(foodItem.isEmpty())
//		{
//			throw new ItemNotFoundException("Item Not Found With Name "+foodItemName);
//		}
//		else
//		{
//			FoodItem foodItems=new FoodItem();		
//			foodItems=foodItem.get();
//			return foodItems;
//		}
//			
//		
//	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteItem(int itemId) {
		LOGGER.info("deleteItemById method is started");
		Optional<FoodItem> foodItem = foodItemsRepository.findById(itemId);
		if(foodItem.isEmpty())
		{
			LOGGER.error("ItemNotFoundException is encounterd");
			throw new ItemNotFoundException("Item not found with id "+itemId);
		}
		else
		{
			foodItemsRepository.deleteById(itemId);
			LOGGER.info("FoodItem deleted successfully");
		}
		
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void updateItem(int foodItemId) {
		LOGGER.info("updateItem method is started");
		Optional<FoodItem> foodItem=foodItemsRepository.findById(foodItemId);
		if(foodItem.isEmpty())
		{
			LOGGER.error("ItemNotFoundException is encounterd");
			throw new ItemNotFoundException("Item not found with id "+foodItemId);
		}
		else
		{
			FoodItem foodItems=new FoodItem();		
			foodItems=foodItem.get();
			foodItems.setItemName("BIRYANI");
			foodItems.setItemPrice(130);
			foodItemsRepository.save(foodItems);
			LOGGER.info("FoodItem updated successfully");
		}
		
		
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public List<FoodItem> getAllItems() {
		LOGGER.info("ugetAllItems method is started");
		List<FoodItem> list=new ArrayList<>();
		list=foodItemsRepository.findAll();
		return list;
	}

}
