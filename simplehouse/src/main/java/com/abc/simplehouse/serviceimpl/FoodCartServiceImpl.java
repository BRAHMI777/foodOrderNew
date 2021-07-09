/**
 * 
 */
package com.abc.simplehouse.serviceimpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.simplehouse.entity.Customer;
import com.abc.simplehouse.entity.FoodCart;
import com.abc.simplehouse.exceptions.CartAlreadyExistingException;
import com.abc.simplehouse.exceptions.CartNotFoundException;
import com.abc.simplehouse.exceptions.CustomerNotFoundException;
import com.abc.simplehouse.repository.CustomerRepository;
import com.abc.simplehouse.repository.FoodCartRepository;
import com.abc.simplehouse.service.FoodCartService;

/**
 * This class is used to implement Service methods.
 * 
 * @author ajay naveen
 *
 */
@Service
public class FoodCartServiceImpl implements FoodCartService {
	@Autowired
	private FoodCartRepository foodCartRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(FoodCartService.class);

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(int customerId) throws CartAlreadyExistingException {
		LOGGER.info("Save Cart method is started");

			FoodCart foodCart = new FoodCart();
			
			Optional<Customer> optionalCustomer=customerRepository.findById(customerId);
			if(optionalCustomer.isEmpty())
				throw new CustomerNotFoundException("Customer not found with id "+customerId);
			Customer customer=optionalCustomer.get();
		
			Optional<FoodCart> optionalCustomerFoodCart=Optional.ofNullable(customer.getCart());
			if(optionalCustomerFoodCart.isPresent())
			{
				FoodCart customerFoodCart=optionalCustomerFoodCart.get();
				throw new CartAlreadyExistingException("This customer already contains a cart "+customerFoodCart.getCartId());
			}
			
			
			foodCart.setCustomer(customer);
			foodCartRepository.save(foodCart);
			LOGGER.info("Foodcart saved successfully");
			customer.setCart(foodCart);
			customerRepository.save(customer);
			
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<FoodCart> getById(int foodCartId) throws CartNotFoundException {
		LOGGER.info("findById method is started");

		Optional<FoodCart> foodcart = foodCartRepository.findById(foodCartId);
		FoodCart foodCart = new FoodCart();
		if (foodcart.isEmpty()) {
			LOGGER.error("CartNotFoundException is encountered");

			throw new CartNotFoundException("Cart not found with Id" + foodCartId);
		} else {
			// FoodCart foodcart = new FoodCart();
			foodCart = foodcart.get();
			foodCart.setCartId(foodCart.getCartId());
			foodCart.setCartItems(foodCart.getCartItems());
			foodCart.setCustomer(foodCart.getCustomer());
			LOGGER.info("FoodCart fetched successfully");
		}
		return foodcart;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteCart(int foodCartId) throws CartNotFoundException {
		LOGGER.info("deleteCartById method is started");
		Optional<FoodCart> foodcart = foodCartRepository.findById(foodCartId);
		if (foodcart.isEmpty()) {
			LOGGER.error("CartNotFoundException is encountered");
			throw new CartNotFoundException("Cart with " + foodCartId + " is empty");
		} else {
			foodCartRepository.deleteById(foodCartId);
			LOGGER.info("Cart is succesfully deleted");
		}
	}

}
