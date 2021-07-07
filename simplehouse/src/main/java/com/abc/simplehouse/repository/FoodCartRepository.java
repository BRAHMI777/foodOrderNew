/**
 * 
 */
package com.abc.simplehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.simplehouse.entity.FoodCart;

/**
 * @author ajay naveen
 *
 */
public interface FoodCartRepository extends JpaRepository<FoodCart, Integer> {

}
