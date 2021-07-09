/**
 * 
 */
package com.abc.simplehouse.service;

import com.abc.simplehouse.entity.Customer;
import com.abc.simplehouse.entity.Login;
import com.abc.simplehouse.exceptions.InvalidCustomerException;

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
	//public String fetchCustomerById(Login login);
	
	

     public Customer customerLogin(String customerEmail, String customerPassword);
	
	//public boolean resetPassword(Customer customer, String newPassword);
	
}
