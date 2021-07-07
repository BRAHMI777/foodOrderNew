/**
 * 
 */
package com.abc.simplehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.simplehouse.entity.CartItems;

/**
 * @author ajay naveen
 *
 */
public interface CartItemRepository extends JpaRepository<CartItems, Integer> {

}
