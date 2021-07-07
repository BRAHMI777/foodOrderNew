/**
 * 
 */
package com.abc.simplehouse.service;

import com.abc.simplehouse.entity.Login;

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
	public String fetchCustomerById(Login login);

}
