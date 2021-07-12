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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.simplehouse.entity.Admin;
import com.abc.simplehouse.payload.AdminLoginPayload;
import com.abc.simplehouse.service.AdminService;

/**
 * @author brahm
 * 11-Jul-2021
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	AdminService adminService;
	
	/**
	 * This method is to save Admin 
	 * @param admin
	 * @return
	 */
	@PostMapping("/save")
	public ResponseEntity<?> saveAdmin(@Valid @RequestBody Admin admin) {
		adminService.saveAdmin(admin);
		LOGGER.info("adminserviceimp::saveAdmin(Admin admin) method calling");
		return new ResponseEntity<>("You registed as a admin Successfully.", HttpStatus.CREATED);	
	}
	
	/**
	 * This method is to delete Admin by Id
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteAdmin(@Valid @PathVariable("id") int id) {
		adminService.deleteAdminbyId(id);
		LOGGER.info("admin delete  method is started.");
		return new ResponseEntity<>("admin deleted succesfully", HttpStatus.FOUND);
	}
	
	/**
	 * This method is to login
	 * @param adminPayload
	 * @return
	 */
	@PostMapping("/login")
	public ResponseEntity<?> loginAdmin(@Valid @RequestBody AdminLoginPayload adminLoginPayload) {
		adminService.loginAdmin(adminLoginPayload.getAdminEmail(),adminLoginPayload.getAdminPassword());
		LOGGER.info("adminserviceimp::saveAdmin(Admin admin) method calling");
		return new ResponseEntity<>("You have successfully logge in.", HttpStatus.CREATED);	
	}
	
}