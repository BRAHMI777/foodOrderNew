/**
 * 
 */
package com.abc.simplehouse.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.simplehouse.entity.Customer;
import com.abc.simplehouse.exceptions.CustomerAlreadyExistsException;
import com.abc.simplehouse.service.CustomerService;

/**
 * @author midhh
 *
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	private static final Logger LOGGER =LoggerFactory.getLogger(CustomerController.class);
	
	@PostMapping("/signup")
    public ResponseEntity<?> createcustomer(@Valid @RequestBody  Customer customer) throws CustomerAlreadyExistsException {
		LOGGER.info("Path:/customer/save");
		LOGGER.info("save method is started");
        customerService.saveCustomer(customer);
        ResponseEntity<String> responseEntity= new ResponseEntity<>("You have registered succesfully", HttpStatus.CREATED);
        LOGGER.info("Save method is successfully completed.");
        return responseEntity;
    }
	
	@GetMapping("/find/{id}")
	public Customer findCustomerById(@Valid  @PathVariable int id){
		LOGGER.info("Path:/customer/find/{id}");
		LOGGER.info("find customerById method is started");
		Customer customer = customerService.findCustomerById(id);
		LOGGER.info("findById method is successfully completed.");
		return customer;
		
}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCustomer(@Valid @PathVariable int id){
		LOGGER.info("Path:/customer/delete/{id}");
		LOGGER.info("Delete customerById method is started");
		customerService.deleteCustomerbyId(id);		
		ResponseEntity<String> responseEntity= new ResponseEntity<>("Deleted the customer with id : "+id,HttpStatus.FOUND);
		LOGGER.info("DeleteById method is successfully completed.");
		return responseEntity;
		
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateCustomer(@Valid @PathVariable("id") int customerId)  {	
		LOGGER.info("Path:/customer/update");
		LOGGER.info("Update customer details method is started");
		customerService.updateCustomer(customerId);
		
		ResponseEntity<String> responseEntity= new ResponseEntity<>(" Customer Details updated ",HttpStatus.CREATED);
		LOGGER.info("Update method is successfully completed.");
		return responseEntity;
	}
	
	@GetMapping("/findbyemail/{customerEmail}")
	public Customer findCustomerByEmail(@Valid  @PathVariable String customerEmail){
		
		Customer customer = customerService.findCustomerByEmail(customerEmail);
		LOGGER.info("findByEmail method is successfully completed.");

		return customer;
	}

}
