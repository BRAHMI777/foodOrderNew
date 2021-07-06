/**
 * 
 */
package com.abc.simplehouse.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.simplehouse.entity.OrderItem;
import com.abc.simplehouse.service.OrderItemService;

/**
 * @author BrahmanandaReddy
 * 06-Jul-2021
 */

@RestController
@RequestMapping("/orderitems")
public class OrderItemController {

	@Autowired
	private OrderItemService orderItemService;
	
private static final Logger LOGGER =LoggerFactory.getLogger(FoodItemController.class);
	
	@PostMapping("/additem")
	public ResponseEntity<?> addItem(@RequestBody OrderItem orderItem)
	{
		LOGGER.info("Path:http://localhost:808/orderitems/additem");
		LOGGER.info("Save Item method is started");
		orderItemService.save(orderItem);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("OrderItem saved Successfully",HttpStatus.CREATED);
		LOGGER.info("Save Item method is started");
		return responseEntity;		
	}
	
//	@GetMapping("/{id}")
//	public FoodItemModel fetchById(@PathVariable("id") int foodId)
//	{
//		LOGGER.info("Path:http://localhost:8081/orderitems/{id}");
//		LOGGER.info("GetById method is started");
//		FoodItemModel foodItems= orderItemService.getById(foodId);
//		LOGGER.info("GetById method is successfully completed");
//		return foodItems;
//	}
//	
	@GetMapping("/allitems")
	public List<OrderItem> fetchAll()
	{
		LOGGER.info("Path:http://localhost:808/orderitems/allitems");
		LOGGER.info("getAllItems method is started");
		List<OrderItem> list=new ArrayList<>();
		list=orderItemService.getAllItems();
		LOGGER.info("GetAllItems method is successfully completed");
		return list;
	}
	
	
	@DeleteMapping("/deleteorderitem/{id}")
	public ResponseEntity<?> deleteItem(@PathVariable("id") int orderItemId)
	{
		LOGGER.info("Path:http://localhost:808/orderitems/deleteitem/{id}");
		LOGGER.info("deleteItem method is started");
		orderItemService.deleteOrderItem(orderItemId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Item deleted Successfully",HttpStatus.OK);
		LOGGER.info("deleted the item is successfully");
		return responseEntity;
	}
	
}
