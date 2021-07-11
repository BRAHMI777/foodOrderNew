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
import com.abc.simplehouse.entity.FoodCart;
import com.abc.simplehouse.exceptions.CredentialsNotValidException;
import com.abc.simplehouse.exceptions.CustomerAlreadyExistsException;
import com.abc.simplehouse.exceptions.CustomerNotFoundException;
import com.abc.simplehouse.exceptions.PasswordMismatchException;
import com.abc.simplehouse.repository.CustomerRepository;
import com.abc.simplehouse.service.CustomerService;


/**
 * @author midhh
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepository customerRepository;
	
	private static final Logger LOGGER =LoggerFactory.getLogger(CustomerServiceImpl.class);
	
   
	
    /**
     * {@inheritDoc}
     */
	@Override
	public void saveCustomer(Customer customer) throws CustomerAlreadyExistsException {
		LOGGER.info("Save Method is started");
		Optional<Customer> optionalCustomer = customerRepository.findById(customer.getCustomerId());
		
		if(optionalCustomer.isPresent())
		{	
			LOGGER.error("CustomerAlreadyExistsException is encountered");
			throw new CustomerAlreadyExistsException("Customer already existing with id: "+ customer.getCustomerId());
		}
		
		Optional<Customer> optionalCustomer1 = customerRepository.findByCustomerEmail(customer.getCustomerEmail());
		if(optionalCustomer1.isPresent())
		{
			throw new CustomerAlreadyExistsException("Customer already existing with this Email: "+ customer.getCustomerEmail());
		}
		else 
		{
		FoodCart foodCart=new FoodCart();
		foodCart.setCustomer(customer);	
		customer.setCart(foodCart);
		customerRepository.save(customer);
		LOGGER.info("Customer Registered successfully");
		
		}
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Customer findCustomerById(int id) throws CustomerNotFoundException 
	{
		
		LOGGER.info("Find customer by Id Method is started");
		
		Optional<Customer> optionalCustomer = customerRepository.findById(id);
		if(optionalCustomer.isPresent())
		{
			LOGGER.info("Found the customer with Id successfully");
			return optionalCustomer.get();	
		}
		
	    else 
	    {
		LOGGER.error("CustomerNotFoundException is encountered.");
		throw new CustomerNotFoundException("cannot find customer with this id:"+id);	
	    }	
			
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public void deleteCustomerbyId(int id) throws CustomerNotFoundException {
		
		LOGGER.info("Delete customer by Id Method is started");
		Optional<Customer> customer = customerRepository.findById(id);
		if(customer.isPresent()) {
			
			customerRepository.deleteById(id);
			LOGGER.info("Deletes the customer with Id successfully.");
		}
		else {
			LOGGER.error("CustomerNotFoundException is encountered.");
			throw new CustomerNotFoundException("Cannot find customer with this Id "+id);
		}		
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Customer findCustomerByEmail(String customerEmail) throws CustomerNotFoundException{
	
		Optional<Customer> customer = customerRepository.findByCustomerEmail(customerEmail);
		if(customer.isPresent()) {
			
			customerRepository.findByCustomerEmail(customerEmail);
			
		}
		else {
			
			throw new CustomerNotFoundException("Cannot find customer with this email: "+customerEmail);
		}
		return customer.get();
		
		
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateCustomer(int customerId) throws CustomerNotFoundException {
         LOGGER.info("Update Customer details method is started");
         
		Optional<Customer> optionalCustomer= customerRepository.findById(customerId);

		if(optionalCustomer.isEmpty()) {
			
			 LOGGER.error("CustomerNotFoundException is encountered");
			throw new CustomerNotFoundException("Cannot Find Customer with this id: "+customerId);
			}
		else {
			Customer customer=optionalCustomer.get();
	        			
			customer.setCustomerEmail("brahmi@gmail.com");
			customer.setCustomerName("BRAHMA REDDY");
			
			customerRepository.save(customer);
			LOGGER.info("Updated the Customer details successfully");
			
		}
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void forgetPassword(String customerEmail, String password, String reEnterPassword)
			throws CustomerNotFoundException {
		
		Optional<Customer> optionalCustomer = customerRepository.findByCustomerEmail(customerEmail);
		if(optionalCustomer.isEmpty()) 			
			throw new CustomerNotFoundException("Cannot find customer with this email: "+customerEmail);
		Customer customer=optionalCustomer.get();
		
		if(password.equals(reEnterPassword))
		{
			customer.setCustomerPassword(reEnterPassword);
			customerRepository.save(customer);
		}
		else
		{
			throw new PasswordMismatchException("Password and re-Enter password mismatches. Please enter same password.");
		}
	
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void resetPassword(String customerEmail, String password, String newPassword)
			throws CustomerNotFoundException {
		
		Optional<Customer> optionalCustomer = customerRepository.findByCustomerEmail(customerEmail);
		if(optionalCustomer.isEmpty()) 			
			throw new CustomerNotFoundException("Cannot find customer with this email: "+customerEmail);
		Customer customer=optionalCustomer.get();
		if(customer.getCustomerPassword().equals(password))
		{
			customer.setCustomerPassword(newPassword);
			customerRepository.save(customer);
			
		}
		else
		{
			throw new CredentialsNotValidException("Customer email and password mismatches. Please try with correct credentials.");
		}
		
	}
}


