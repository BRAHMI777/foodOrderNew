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

import com.abc.simplehouse.entity.Payment;
import com.abc.simplehouse.service.PaymentService;

/**
 * @author gowthami
 * @date 2021-07-07
 *
 */

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	private static final Logger LOGGER =LoggerFactory.getLogger(PaymentController.class);
	
	@PostMapping("/save")  
	public ResponseEntity<?>  createPayment(@Valid @RequestBody Payment payment){ 
	LOGGER.info("path:/payment/createPayment");
	LOGGER.info("savePayment method is started");
	paymentService.savePayment(payment);
	LOGGER.info("Payment details saved successfully");
	return new ResponseEntity<>("Payment details saved successfully",HttpStatus.ACCEPTED);
	}
	 
	@DeleteMapping("/delete/{id}")  
	public ResponseEntity<?>  deletePayment(@Valid @PathVariable("id") int id){ 
	LOGGER.info("path:/payment/deletePayment/{id}");
	LOGGER.info("deletePaymentbyId method is started");
	paymentService.deletePaymentbyId(id);
	LOGGER.info("Payment details deleted successfully");
	return new ResponseEntity<>("Payment deleted",HttpStatus.ACCEPTED);
	}
	 
	@PutMapping("/update/{id}")  
	public ResponseEntity<?> update(@PathVariable("id") int paymentId)   
	{  
	LOGGER.info("path:/payment/update");
	LOGGER.info("updatePayment method is started");	
	paymentService.updatePayment(paymentId); 
	
	LOGGER.info("Payment details are updated");
	return new ResponseEntity<>("Payment updated successfulluy",HttpStatus.ACCEPTED);
	}  
	
	
	@GetMapping("/find/{id}")
	public Payment findPaymentById(@Valid @PathVariable int id) {
	LOGGER.info("path:/payment/findPaymentById/{id}");
	LOGGER.info("findPaymentBy method is started");
	LOGGER.info("findPaymentBy method is executed successfully");
	return paymentService.findPaymentById(id);
	}
}  
