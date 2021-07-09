/**
 * 
 */

package com.abc.simplehouse.serviceimpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.simplehouse.entity.Customer;
import com.abc.simplehouse.repository.CustomerRepository;
import com.abc.simplehouse.service.LoginService;

/**
 * @author midhh
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
		/*
		 * @Override public String fetchCustomerById(Login login) {
		 * LOGGER.info("Fetching customer Id for the login is started.");
		 * Optional<Customer> customerNew =
		 * customerRepository.findById(login.getCustomerId());
		 * 
		 * Customer customer = new Customer();
		 * 
		 * 
		 * customer = customerNew.get(); String str = login.getCustomerEmail(); String
		 * str1 = login.getCustomerPassword(); String str2 =
		 * customer.getCustomerEmail(); String str3 = customer.getCustomerPassword();
		 * 
		 * if(str.equals(str2) && str1.equals(str3)) {
		 * LOGGER.info("Login is successful."); return "Login Success";
		 * 
		 * } else { LOGGER.info("Login failed."); return "Login Failure"; }
		 */
		
			
         
		
	
	
	@Override
	public Customer customerLogin(String customerEmail, String customerPassword) {
		
       Customer customer = customerRepository.customerLogin(customerEmail, customerPassword);	
		
		
		return customer;
	}
	
}
		
	
	



