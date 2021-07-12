/**
 * 
 */
package com.abc.simplehouse.service;

import com.abc.simplehouse.entity.Customer;

/**
 * @author midhh
 *
 */

public interface LoginService {
	/**
	 * This method is used to login the customer.
	 * @param login
	 * @return
	 */

     public Customer customerLogin(String customerEmail, String customerPassword);
	

	
}
