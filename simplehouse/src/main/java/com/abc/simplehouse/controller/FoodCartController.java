/**
 * 
 */
package com.abc.simplehouse.controller;

import java.util.Optional;

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

import com.abc.simplehouse.entity.FoodCart;
import com.abc.simplehouse.service.FoodCartService;

/**
 * @author ajay naveen
 *
 */

@RestController
@RequestMapping("/cart")

public class FoodCartController {
	@Autowired
	private FoodCartService foodCartService;
	private static final Logger LOGGER = LoggerFactory.getLogger(FoodCartController.class);

	@PostMapping("/addcart")
	public ResponseEntity<?> addCart(@RequestBody FoodCart cart) {
		LOGGER.info("Path:/cart/addtocart");
		LOGGER.info("Save cart method is started");
		foodCartService.save(cart);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Cart saved successfully", HttpStatus.CREATED);
		LOGGER.info("save cart method is successfully");
		return responseEntity;
	}

	@GetMapping("/{id}")
	public Optional<FoodCart> fetchById(@PathVariable("id") int foodCartId) {
		LOGGER.info("Path:/cart/{id}");
		LOGGER.info("GetById method is started");
		Optional<FoodCart> foodcart = foodCartService.getById(foodCartId);
		LOGGER.info("GetById method is successfully completed");
		return foodcart;
	}

	@DeleteMapping("/deletecart/{id}")
	public ResponseEntity<?> deleteCart(@PathVariable("id") int foodcartId) {
		LOGGER.info("Path:/cart/deletecart/{id}");
		LOGGER.info("deletecart method has started");
		foodCartService.deleteCart(foodcartId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Cart deleted Successfully", HttpStatus.OK);
		LOGGER.info("cart is deleted successfully");
		return responseEntity;

	}

}
