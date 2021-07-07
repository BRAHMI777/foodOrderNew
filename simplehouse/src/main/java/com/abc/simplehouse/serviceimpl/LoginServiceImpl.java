/**
 * 
 */
package com.abc.simplehouse.serviceimpl;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.simplehouse.entity.Customer;
import com.abc.simplehouse.entity.Login;
import com.abc.simplehouse.exceptions.CustomerNotFoundException;
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
	@Override
	public String fetchCustomerById(Login login) {
		LOGGER.info("Fetching customer Id for the login is started.");
		Optional<Customer> OptionalCustomer = customerRepository.findById(login.getCustomerId());
		if(OptionalCustomer.isPresent())
		{
		
         Customer customer = new Customer();
         
         
        customer = OptionalCustomer.get();
		String str = login.getCustomerEmail();
		String str1 = login.getCustomerPassword();
		String str2 = customer.getCustomerEmail();
		String str3 = customer.getCustomerPassword();
		
		if(str.equals(str2) && str1.equals(str3)) {
			LOGGER.info("Login is successful.");	
			return "Login Success";
			
		}
		
		else {
			LOGGER.info("Login failed.");
			return "Invalid Email/password";
		}    
		}
		else
		{
			LOGGER.error("CustomerNotFoundException is encounterd.");
			throw new CustomerNotFoundException("No customer is found with this customer Id "+login.getCustomerId());
		}
	}
	}



