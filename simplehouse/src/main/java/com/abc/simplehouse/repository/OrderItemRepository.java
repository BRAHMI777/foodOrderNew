/**
 * 
 */
package com.abc.simplehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.simplehouse.entity.OrderItem;

/**
 * @author BrahmanandaReddy
 * 06-Jul-2021
 */
public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {

}
