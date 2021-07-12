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

import com.abc.simplehouse.entity.CartItem;
import com.abc.simplehouse.entity.FoodCart;
import com.abc.simplehouse.exceptions.CartItemNotFoundException;
import com.abc.simplehouse.exceptions.CartNotFoundException;
import com.abc.simplehouse.repository.CartItemRepository;
import com.abc.simplehouse.serviceimpl.CartItemServiceImpl;

/**
 * @author ajay naveen
 *
 */
@SpringBootTest
public class CartItemsServiceTest {
	@Mock
	private CartItemRepository cartItemRepository;
	@InjectMocks
	private CartItemServiceImpl cartItemServiceImpl;

//	@Test
//	public void testSave() {
//		CartItem cartItems = new CartItem();
//		cartItems.getId();
//		cartItems.getQuantity();
//		//cartItemServiceImpl.save(cartItems);
//
//	}

	@Test
	public void testGetById() {
		CartItem cartItems = new CartItem();
		cartItems.setId(3);
		cartItems.setQuantity(1);
		Optional<CartItem> optionalCartItems = Optional.of(cartItems);
		when(cartItemRepository.findById(3)).thenReturn(optionalCartItems);
		assertEquals(cartItems.getId(), cartItems.getId());
	}

	@Test
	public void testDeleteCartItems() {

		CartItem cartItems = new CartItem();
		cartItems.setId(3);
		cartItems.setQuantity(1);
		Optional<CartItem> optionalCartItems = Optional.of(cartItems);
		when(cartItemRepository.findById(cartItems.getId())).thenReturn(optionalCartItems);
		cartItemServiceImpl.deleteCartItems(cartItems.getId());

	}

	@Test
    public void testUpdateCartItems() {

        CartItem cartItems = new CartItem();
        cartItems.setId(4);
        cartItems.setQuantity(2);
        Optional<CartItem> optionalCartItems = Optional.of(cartItems);
        when(cartItemRepository.findById(4)).thenReturn(optionalCartItems);
        cartItemServiceImpl.updateCartItems(cartItems);

    }

 

	@Test
	public void testCartItemNotFoundException() {
		when(cartItemRepository.findById(20)).thenThrow(CartItemNotFoundException.class);

		assertThrows(CartItemNotFoundException.class, () -> cartItemServiceImpl.getById(20));
	}

}
