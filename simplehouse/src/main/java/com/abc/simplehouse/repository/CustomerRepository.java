/**
 * 
 */
package com.abc.simplehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.simplehouse.entity.Customer;

/**
 * @author midhh
 *
 */
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

	
}
