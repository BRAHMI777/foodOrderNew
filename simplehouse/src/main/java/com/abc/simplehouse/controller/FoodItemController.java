package com.abc.simplehouse.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.simplehouse.entity.FoodItem;
import com.abc.simplehouse.exceptions.ErrorResponse;
import com.abc.simplehouse.service.FoodItemsService;



@RestController
@RequestMapping("/fooditems")
@Validated
public class FoodItemController {
	
	@Autowired
	private FoodItemsService foodItemsService;
	
	@Autowired
	ErrorResponse response;
	
	private static final Logger LOGGER =LoggerFactory.getLogger(FoodItemController.class);
	
	@PostMapping("/additem")
	public ResponseEntity<?> addItem(@Valid @RequestBody FoodItem foodItem)
	{
		LOGGER.info("Path:http://localhost:8081/fooditems/additem");
		LOGGER.info("Save Item method is started");
		foodItemsService.save(foodItem);
		LOGGER.info("Save Item method is successfully completed");
		response.setMsg("Item saved Successfully");
		response.setStatusCode(201);
		 return new ResponseEntity<>(response,HttpStatus.CREATED);
	
	}
	
	@GetMapping("/{id}")
	public FoodItem fetchById(@PathVariable("id") int foodItemId)
	{
		LOGGER.info("Path:http://localhost:8081/fooditems/{id}");
		LOGGER.info("GetById method is started");
		FoodItem foodItems= foodItemsService.getById(foodItemId);
		LOGGER.info("GetById method is successfully completed");
		return foodItems;
	}
	
	@GetMapping("/allitems")
	public List<FoodItem> fetchAll()
	{
		LOGGER.info("Path:http://localhost:8081/fooditems/allitems");
		LOGGER.info("getAllItems method is started");
		List<FoodItem> list=new ArrayList<>();
		list=foodItemsService.getAllItems();
		LOGGER.info("GetAllItems method is successfully completed");
		return list;
	}
	
	
	
	
	@GetMapping("find/{name}")
	public FoodItem findByName(@PathVariable("name") String foodItemName)
	{
		FoodItem foodItem= foodItemsService.getByName(foodItemName);
		return foodItem;
	}
	
	
	
	@DeleteMapping("deleteitem/{id}")
	public ResponseEntity<?> deleteItem(@PathVariable("id") int itemId)
	{
		LOGGER.info("http://localhost:8081/deleteitem/{id}");
		LOGGER.info("deleteItem method is started");
		foodItemsService.deleteItem(itemId);
		LOGGER.info("deleted the item is successfully");
		response.setMsg("Item deleted Successfully");
		response.setStatusCode(200);
		 return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PutMapping("updateitem/{id}")
	public ResponseEntity<?> updateItem(@PathVariable("id") int itemId)
	{
		LOGGER.info("Path:http://localhost:8081//fooditems/updateitem/{id}");
		LOGGER.info("updateItem method is started");
		foodItemsService.updateItem(itemId);		
		LOGGER.info("Item Updated successfully");
		response.setMsg("Item updated Successfully");
		response.setStatusCode(200);
		 return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
	
	
}
