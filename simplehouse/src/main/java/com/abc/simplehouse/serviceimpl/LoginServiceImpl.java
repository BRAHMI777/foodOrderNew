/**
 * 
 */

package com.abc.simplehouse.serviceimpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.simplehouse.entity.Customer;
import com.abc.simplehouse.exceptions.InvalidCustomerException;
import com.abc.simplehouse.repository.CustomerRepository;
import com.abc.simplehouse.service.LoginService;

/**
 * @author madhu
 *
 */
@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private CustomerRepository customerRepository;
	

	private static final Logger LOGGER =LoggerFactory.getLogger(LoginServiceImpl.class);
    
	/**
      * {@inheritDoc}
      */	
	@Override
	public Customer customerLogin(String customerEmail, String customerPassword) {
		
	  LOGGER.info(" login method is is started.");
       Customer customer = customerRepository.customerLogin(customerEmail, customerPassword);	
       
       if(customer == null) {
    	   throw new InvalidCustomerException("Invalid Email/password. Please try with correct credentials");
       }
		
       LOGGER.info("Login is successful.");
		return customer;
	}
	
}
		
	
	



