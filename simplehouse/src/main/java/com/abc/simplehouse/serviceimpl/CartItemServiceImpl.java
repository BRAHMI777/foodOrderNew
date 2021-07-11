/**
 * 
 */
package com.abc.simplehouse.serviceimpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.simplehouse.entity.CartItem;
import com.abc.simplehouse.entity.FoodCart;
import com.abc.simplehouse.entity.FoodItem;
import com.abc.simplehouse.exceptions.CartItemNotFoundException;
import com.abc.simplehouse.exceptions.CartNotFoundException;
import com.abc.simplehouse.exceptions.ItemNotFoundException;
import com.abc.simplehouse.repository.CartItemRepository;
import com.abc.simplehouse.repository.FoodCartRepository;
import com.abc.simplehouse.repository.FoodItemRepository;
import com.abc.simplehouse.service.CartItemService;

/**
 * @author ajay naveen
 *
 */
@Service

public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemRepository cartItemsRepository;
	
	@Autowired
	private FoodItemRepository foodItemRepository;
	
	@Autowired
	private FoodCartRepository foodCartRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(CartItemService.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(int foodCartId,int foodItemId,int quantity) {
		LOGGER.info("Save method for cart items is started");
		
		Optional<FoodItem> OptionalFoodItem=foodItemRepository.findById(foodItemId);
		FoodItem foodItem;
		if(OptionalFoodItem.isPresent())
			foodItem=OptionalFoodItem.get();
		else
			throw new ItemNotFoundException("Item not found with foodItem id "+foodItemId);
		
		
		Optional<FoodCart> optionalFoodCart=foodCartRepository.findById(foodCartId);
		if(optionalFoodCart.isEmpty())
			throw new CartNotFoundException("Cart not available with this id "+foodCartId);
		FoodCart foodCart=optionalFoodCart.get();
			
		CartItem cartItems=new CartItem();
		cartItems.setQuantity(quantity);
		cartItems.setFoodCart(foodCart);
		cartItems.setFoodItem(foodItem);
			cartItemsRepository.save(cartItems);
			LOGGER.info("CartItems saved successfully");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<CartItem> getById(int cartItemId) throws CartItemNotFoundException {
		LOGGER.info("findById method is started");
		Optional<CartItem> cartItems = cartItemsRepository.findById(cartItemId);
		CartItem cartitems = new CartItem();
		if (cartItems.isEmpty()) {
			LOGGER.error("CartItemsNotFoundEXception is encountered");
			throw new CartItemNotFoundException("Cart Items not found with Id" + cartItemId);
		} else {
			cartitems.setId(cartitems.getId());
			cartitems.setQuantity(cartitems.getQuantity());
			LOGGER.info("Cart Items fetched successfully");
		}
		return cartItems;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override

	public void deleteCartItems(int cartItemId) throws CartItemNotFoundException {
		LOGGER.info("deleteCartItemsById method is started");

		Optional<CartItem> cartitem = cartItemsRepository.findById(cartItemId);
		if (cartitem.isEmpty()) {
			LOGGER.error("CartItemsNotFoundException is encountered");

			throw new CartItemNotFoundException("Cart Items with " + cartItemId + " is empty");
		} else {
			cartItemsRepository.deleteById(cartItemId);
			LOGGER.info("Cart Items are succesfully deleted");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CartItem updateCartItems(CartItem cartItems) {
		LOGGER.info("updateCartItems method is started");
		cartItemsRepository.save(cartItems);
		LOGGER.info("cart items are updated");
		return cartItems;

	}

	@Override
	public void deleteAllCartItems() {
		LOGGER.info("updateCartItems method is started");
		cartItemsRepository.deleteAllInBatch();
		LOGGER.info("cart items are deleted");
		
	}
}
