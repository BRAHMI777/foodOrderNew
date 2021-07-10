/**
 * 
 */
package com.abc.simplehouse.service;

import com.abc.simplehouse.entity.Customer;
import com.abc.simplehouse.exceptions.CustomerAlreadyExistsException;
import com.abc.simplehouse.exceptions.CustomerNotFoundException;


/**
 * @author madhuBabu
 *
 */

public interface CustomerService {
	
	
	/**
	 * This Method is used to save customer details.
	 * @param customer
	 * @throws CustomerAlreadyExistsException
	 */
	public void saveCustomer(Customer customer) throws CustomerAlreadyExistsException;
	/**
	 * This Method is used to find customer by ID.
	 * @param id
	 * @return
	 * @throws CustomerNotFoundException
	 */
	public Customer findCustomerById(int id) throws CustomerNotFoundException;
	/**
	 * This Method is used to delete the customer by Id.
	 * @param id
	 * @throws CustomerNotFoundException
	 */
	public void deleteCustomerbyId(int id)throws CustomerNotFoundException;
	/**
	 * This Method is used to update customer details.
	 * @param customer
	 * @throws CustomerNotFoundException
	 */
	public void forgetPassword(String customerEmail,String password,String reEnterPassword) throws CustomerNotFoundException;
	
	/**
	 * This Method is used to update customer details.
	 * @param customer
	 * @throws CustomerNotFoundException
	 */
	public void resetPassword(String customerEmail,String password,String newPassword) throws CustomerNotFoundException;
	/**
	 * This Method is used to update customer details.
	 * @param customer
	 * @throws CustomerNotFoundException
	 */
	public void updateCustomer(int customerId) throws CustomerNotFoundException;
	
	/**
	 * This Method is used to grt customer details by using customerEmail.
	 * @param customer
	 * @throws CustomerNotFoundException
	 */
	public Customer findCustomerByEmail(String customerEmail) throws CustomerNotFoundException;
	
	
	

}
