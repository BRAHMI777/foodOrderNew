package com.abc.simplehouse.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.simplehouse.entity.Customer;
import com.abc.simplehouse.exceptions.InvalidCustomerException;
import com.abc.simplehouse.repository.CustomerRepository;
import com.abc.simplehouse.serviceimpl.LoginServiceImpl;

@SpringBootTest
public class LoginServiceTest {

	@Mock
	private CustomerRepository customerRepository;

	@InjectMocks
	private LoginServiceImpl loginServiceImpl;

	@Test
	public void TestcustomerLogin() {

		Customer customer = new Customer();

		customer.setCustomerEmail("madhu@gmail.com");
		customer.setCustomerPassword("vgftfgghb");

		assertThrows(InvalidCustomerException.class,() -> loginServiceImpl.customerLogin(customer.getCustomerEmail(), customer.getCustomerPassword()));
	}
	
	
}