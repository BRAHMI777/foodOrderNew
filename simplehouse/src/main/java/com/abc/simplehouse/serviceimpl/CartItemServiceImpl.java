/**
 * 
 */
package com.abc.simplehouse.serviceimpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.simplehouse.entity.CartItems;
import com.abc.simplehouse.entity.FoodCart;
import com.abc.simplehouse.entity.FoodItem;
import com.abc.simplehouse.exceptions.CartItemNotFoundException;
import com.abc.simplehouse.exceptions.CartNotFoundException;
import com.abc.simplehouse.exceptions.ItemNotFoundException;
import com.abc.simplehouse.payload.CartItemsPayload;
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
	public void save(CartItemsPayload cartItemsPayload) {
		LOGGER.info("Save method for cart items is started");
		//Optional<CartItems> op = cartItemsRepository.findById(cartItems.getId());
		//if (op.isEmpty()) {
		
		Optional<FoodItem> OptionalFoodItem=foodItemRepository.findById(cartItemsPayload.getFoodItemId());
		FoodItem foodItem;
		if(OptionalFoodItem.isPresent())
			foodItem=OptionalFoodItem.get();
		else
			throw new ItemNotFoundException("Item not found with foodItem id "+cartItemsPayload.getFoodItemId() );
		
		
		Optional<FoodCart> optionalFoodCart=foodCartRepository.findById(cartItemsPayload.getFoodCartId());
		if(optionalFoodCart.isEmpty())
			throw new CartNotFoundException("Cart not available with this id "+cartItemsPayload.getFoodCartId());
		FoodCart foodCart=optionalFoodCart.get();
			
		CartItems cartItems=new CartItems();
		cartItems.setQuantity(cartItemsPayload.getQuantity());
		cartItems.setFoodCart(foodCart);
		cartItems.setFoodItem(foodItem);
			cartItemsRepository.save(cartItems);
			LOGGER.info("CartItems saved successfully");

		//} else {
//			CartItems cartItem = op.get();
//
//			cartItem.setQuantity(cartItem.getQuantity() + cartItems.getQuantity());
//			cartItemsRepository.save(cartItem);
//			LOGGER.info("Cart items saved successfully");
		}

	//}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<CartItems> getById(int cartItemId) throws CartItemNotFoundException {
		LOGGER.info("findById method is started");
		Optional<CartItems> cartItems = cartItemsRepository.findById(cartItemId);
		CartItems cartitems = new CartItems();
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

		Optional<CartItems> cartitem = cartItemsRepository.findById(cartItemId);
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
	public CartItems updateCartItems(CartItems cartItems) {
		LOGGER.info("updateCartItems method is started");
		cartItemsRepository.save(cartItems);
		LOGGER.info("cart items are updated");
		return cartItems;

	}
}
