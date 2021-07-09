/**
 * 
 */
package com.abc.simplehouse.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.simplehouse.entity.Customer;
import com.abc.simplehouse.payload.LoginPayLoad;
import com.abc.simplehouse.service.LoginService;

/**
 * @author midhh
 *
 */

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	private static final Logger LOGGER =LoggerFactory.getLogger(LoginController.class);
	
	
	@PostMapping("/status")
	public ResponseEntity<?> createLogin(@RequestBody LoginPayLoad loginPayLoad) {
		 LOGGER.info("Path:/login/status");
		 LOGGER.info("login method is started");
		Customer customer = loginService.customerLogin(loginPayLoad.getCustomerEmail(),loginPayLoad.getCustomerPassword());
		
		//System.out.println(customer);
		
		if(customer != null) {
		
		return  new ResponseEntity<>(customer,HttpStatus.OK);

}
		else {
			
			 LOGGER.info("Save method is successfully completed.");
			return new ResponseEntity<>("Invalid Email/password. Please try with correct credentials.",HttpStatus.OK);
			
		}
	
}
}
