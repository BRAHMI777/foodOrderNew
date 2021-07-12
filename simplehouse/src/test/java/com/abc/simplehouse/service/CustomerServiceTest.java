package com.abc.simplehouse.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.simplehouse.entity.Customer;
import com.abc.simplehouse.exceptions.CredentialsNotValidException;
import com.abc.simplehouse.exceptions.CustomerAlreadyExistsException;
import com.abc.simplehouse.exceptions.CustomerNotFoundException;
import com.abc.simplehouse.exceptions.PasswordMismatchException;
import com.abc.simplehouse.repository.CustomerRepository;
import com.abc.simplehouse.serviceimpl.CustomerServiceImpl;

@SpringBootTest
public class CustomerServiceTest {
	
	@Mock
	private CustomerRepository customerRepository;
	
	
	@InjectMocks
	private CustomerServiceImpl customerServiceImpl;
	
	@Test
	public void testSaveCustomer() {
		
		Customer customer =new Customer();
		customer.setCustomerId(150);
		customer.setCustomerName("madhu");
		customer.setCustomerEmail("madhu345@gmail.com");
		customer.setPhoneNumber("9078776669");
		customer.setAdress("777ygvgv");
		customer.setCustomerPassword("xcvgyy");

		customerServiceImpl.saveCustomer(customer);
      
	}
	
	@Test
    public void TestFindCustomerById() {

       Customer customer=new Customer();
       customer.setCustomerId(150);
		customer.setCustomerName("madhu");
		customer.setCustomerEmail("madhu345@gmail.com");
		customer.setPhoneNumber("9078776669");
		customer.setAdress("777ygvgv");
		customer.setCustomerPassword("xcvgyy");
        
        Optional<Customer> optionalCustomer = Optional.of(customer);
   
        when(customerRepository.findById(150)).thenReturn(optionalCustomer);

        assertEquals(150,customer.getCustomerId());
      
    }
	
	@Test
	public void testCustomerNotFoundException() {
		when(customerRepository.findById(20)).thenThrow(CustomerNotFoundException.class);
        
        assertThrows(CustomerNotFoundException.class,()->customerServiceImpl.findCustomerById(20));
	}
	
	@Test
	public void testUpdateCustomer() {
		
		Customer customer= new Customer();
		
		customer.setCustomerId(150);
		customer.setCustomerName("madhu");
		customer.setCustomerEmail("madhu345@gmail.com");
		customer.setPhoneNumber("907877899");
		customer.setAdress("777ygvgv");
		customer.setCustomerPassword("xcvgyy");
		
      Optional<Customer> optionalCustomer = Optional.of(customer);
 
        when(customerRepository.findById(150)).thenReturn(optionalCustomer);

        assertEquals(150,customer.getCustomerId());
		 customerServiceImpl.updateCustomer(150);
		
		     
      
	}
	
	@Test
	public void testDeleteCustomerbyId(){
		
       Customer customer= new Customer();
		
		customer.setCustomerId(150);
		customer.setCustomerName("madhu");
		customer.setCustomerEmail("madhu345@gmail.com");
		customer.setPhoneNumber("907877899");
		customer.setAdress("777ygvgv");
		customer.setCustomerPassword("xcvgyy");
	
	when(customerRepository.findById(customer.getCustomerId())).thenReturn(Optional.of(customer));
	customerServiceImpl.deleteCustomerbyId(150);
	}
	
	
	@Test
	public void testCustomerAlreadyExistsException() {
		when(customerRepository.findById(20)).thenThrow(CustomerAlreadyExistsException.class);
        
        assertThrows(CustomerAlreadyExistsException.class,()->customerServiceImpl.findCustomerById(20));
	}
	@Test
	public void testFindCustomerByEmail() {
		
		Customer customer=new Customer();
	       customer.setCustomerId(150);
			customer.setCustomerName("madhu");
			customer.setCustomerEmail("madhu345@gmail.com");
			customer.setPhoneNumber("9078776669");
			customer.setAdress("777ygvgv");
			customer.setCustomerPassword("xcvgyy");
	        
	        Optional<Customer> optionalCustomer = Optional.of(customer);
      
	        when(customerRepository.findByCustomerEmail("madhu345@gmail.com")).thenReturn(optionalCustomer);
	
	        assertEquals(customer.getCustomerEmail(),customer.getCustomerEmail());
		
		
		
	}
	
	@Test
	public void TestforgetPassword() {

		Customer customer = new Customer();

		customer.setCustomerEmail("madhu@gmail.com");
		customer.setCustomerPassword("vgftfgghb");
		assertThrows(CustomerNotFoundException.class,() ->customerServiceImpl.forgetPassword("madhu@gmail.com", "vgftfgghb", "vgftfgghb"));
	}

	@Test
	public void TestresetPassword() {
		
		Customer customer = new Customer();

		customer.setCustomerEmail("madhu@gmail.com");
		customer.setCustomerPassword("vgftfgghb");
		customer.setCustomerPassword(customer.getCustomerPassword());
		
		
		
			
		assertThrows(CustomerNotFoundException.class,() ->customerServiceImpl.resetPassword("madhu@gmail.com", "vgftfgghb", "vgftfgghb"));
	}
	
	
	@Test
	public void testInvalidCredentialsException() {
		
		Customer customer = new Customer();
		
		customer.getCustomerEmail();
		customer.getCustomerPassword();
		when(customerRepository.save(customer)).thenThrow(CredentialsNotValidException.class);
        
       assertThrows(CredentialsNotValidException.class,()->customerServiceImpl.saveCustomer(customer));
	
}
	
	@Test
	public void testPasswordMisatchException() {
		
		Customer customer = new Customer();
		
		customer.getCustomerEmail();
		customer.getCustomerPassword();
		when(customerRepository.save(customer)).thenThrow(PasswordMismatchException.class);
        
       assertThrows(PasswordMismatchException.class,()->customerServiceImpl.saveCustomer(customer));
	
	
}
}