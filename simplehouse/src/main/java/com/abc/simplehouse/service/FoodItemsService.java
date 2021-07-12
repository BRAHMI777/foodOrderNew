package com.abc.simplehouse.service;


import java.util.List;

import com.abc.simplehouse.entity.FoodItem;


/**
 * This Service interface contains all the methods of food item.
 * @author BrahmanandaReddy
 * @date 05,july,2021
 */
public interface FoodItemsService {

	
	
	/**
	 * save-This method is used to add food item. 
	 * @param item-The food item object
	 * 
	 */
	public void save(FoodItem item);

	/**
	 * getById- This method is used to get item by id.
	 * @param foodItemId
	 * @return FoodItemModel 
	 */
	public FoodItem getById(int foodItemId);
	
	/**
	 * getByName- This method is used to get item by name.
	 * @param foodItemName
	 * @return FoodItemModel 
	 */
	public FoodItem getByName(String foodItemName);

	
	/**
	 * getByName- This method is used to delete the item by id.
	 * @param id
	 * @return void 
	 */
	public void deleteItem(int itemId);

	
	/**
	 * updateItem-This method is used to update the item details.
	 * @param itemId
	 * 
	 */
	public void updateItem(int itemId);

	/**
	 * getAllItems-This method is used to get all products.
	 * @param itemId
	 * 
	 */
	public List<FoodItem> getAllItems();

	

}
