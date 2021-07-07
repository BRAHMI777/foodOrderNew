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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.simplehouse.entity.CartItems;
import com.abc.simplehouse.service.CartItemService;

/**
 * @author ajay naveen
 *
 */

@RestController
@RequestMapping("/cartitem")
public class CartItemController {

	@Autowired
	private CartItemService cartItemsService;
	private static final Logger LOGGER = LoggerFactory.getLogger(CartItemController.class);

	@PostMapping("/additem")
	public ResponseEntity<?> addItem(@RequestBody CartItems item) {
		LOGGER.info("Path:/cartitems/additemstocart");
		LOGGER.info("Save cart items method is started");
		cartItemsService.save(item);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Cart Items saved successfully",
				HttpStatus.CREATED);
		LOGGER.info("save cart items method is successfully");
		return responseEntity;
	}

	@GetMapping("/{id}")
	public Optional<CartItems> fetchById(@PathVariable("id") int cartItemId) {
		LOGGER.info("Path:/cartitems/{id}");
		LOGGER.info("GetById method is started");
		Optional<CartItems> cartitems = cartItemsService.getById(cartItemId);
		LOGGER.info("GetById method is successfully completed");
		return cartitems;
	}

	@DeleteMapping("/deleteitem/{id}")
	public ResponseEntity<?> deleteCartItems(@PathVariable("id") int cartItemId) {
		LOGGER.info("Path:/cartitems/deletecartitem/{id}");
		LOGGER.info("deletecart method has started");
		cartItemsService.deleteCartItems(cartItemId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Cart Items deleted Successfully", HttpStatus.OK);
		LOGGER.info("cart items are deleted successfully");
		return responseEntity;

	}

	@PutMapping("/updateitem/{id}")
	public ResponseEntity<?> updateCartItems(@PathVariable("id") CartItems cartItemId) {
		LOGGER.info("Path:/cartitems/updatecartitems/{id}");
		LOGGER.info("updateCartItems method is started");
		cartItemsService.updateCartItems(cartItemId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Items in Cart updated Successfully",
				HttpStatus.OK);
		LOGGER.info("Cart Items Updated successfully");
		return responseEntity;
	}
}
