/**
 * 
 */
package com.abc.simplehouse.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.simplehouse.entity.Login;
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
    public String getCustomerById(@RequestBody Login login) {
		
		LOGGER.info("Path:/login/status");
		LOGGER.info("login method is started");
         String s = loginService.fetchCustomerById(login);
 		LOGGER.info("login method is done successfully");
        return s;
    }

}
