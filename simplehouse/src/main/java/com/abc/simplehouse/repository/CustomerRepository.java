/**
 * 
 */
package com.abc.simplehouse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abc.simplehouse.entity.Customer;

/**
 * @author midhh
 *
 */
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

	@Query("SELECT c FROM Customer c WHERE customerEmail = ?1 AND customerPassword = ?2")
	public Customer customerLogin(String customerEmail, String customerPassword);
	
	@Query("SELECT c FROM Customer c WHERE customerEmail = ?1")
	public Customer emailCheck(String customerEmail);
	

	public Optional<Customer> findByCustomerEmail(String customerEmail);
}
