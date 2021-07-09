/**
 * 
 */
package com.abc.simplehouse.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.simplehouse.entity.FoodCart;
import com.abc.simplehouse.exceptions.CartAlreadyExistingException;
import com.abc.simplehouse.exceptions.CartNotFoundException;
import com.abc.simplehouse.repository.FoodCartRepository;
import com.abc.simplehouse.serviceimpl.FoodCartServiceImpl;

/**
 * @author ajay naveen
 *
 */
@SpringBootTest
public class FoodCartServiceTest {
	@Mock
	private FoodCartRepository foodCartRepository;

	@InjectMocks
	private FoodCartServiceImpl foodCartServiceImpl;

//	@Test
//	public void testSave() {
//		FoodCart foodCart = new FoodCart();
//		foodCart.setCartId(8);
//		foodCart.setCartItems(null);
//		foodCartServiceImpl.save(foodCart);
//
//	}

	@Test
	public void testGetById() {
		FoodCart foodCart = new FoodCart();
		foodCart.setCartId(8);
		foodCart.setCartItems(null);
		Optional<FoodCart> optionalFoodCart = Optional.of(foodCart);
		when(foodCartRepository.findById(8)).thenReturn(optionalFoodCart);
		assertEquals(foodCart.getCartId(), foodCart.getCartId());
	}

	@Test
	public void testDeleteCart() {

		FoodCart foodCart = new FoodCart();
		foodCart.setCartId(4);
		foodCart.setCartItems(null);

		when(foodCartRepository.findById(foodCart.getCartId())).thenReturn(Optional.of(foodCart));
		foodCartServiceImpl.deleteCart(foodCart.getCartId());
	}

	@Test
	public void testCartAlreadyExistingException() {
		when(foodCartRepository.findById(7)).thenThrow(CartAlreadyExistingException.class);

		assertThrows(CartAlreadyExistingException.class, () -> foodCartServiceImpl.getById(7));
	}

	@Test
	public void testCartNotFoundException() {
		when(foodCartRepository.findById(20)).thenThrow(CartNotFoundException.class);

		assertThrows(CartNotFoundException.class, () -> foodCartServiceImpl.getById(20));
	}

}
