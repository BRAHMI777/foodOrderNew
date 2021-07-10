/**
 * 
 */
package com.abc.simplehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.simplehouse.entity.CartItem;

/**
 * @author ajay naveen
 *
 */
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

}
