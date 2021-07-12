/**
 * @author gowthami
 *
 * date: Jul 8, 2021
 */
package com.abc.simplehouse.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.simplehouse.entity.Payment;
import com.abc.simplehouse.exceptions.PaymentDetailsNotFoundException;
import com.abc.simplehouse.repository.PaymentRepository;
import com.abc.simplehouse.serviceimpl.PaymentServiceImpl;

/**
 * @author gowthami
 *
 * date: Jul 8, 2021
 */
@SpringBootTest
public class PaymentServiceTest {
	@Mock
	private PaymentRepository paymentRepository;
	
	@InjectMocks
	private PaymentServiceImpl paymentServiceImpl;
	
	
	@Test
	public void testSavePayment() {
		Payment payment=new Payment();
		payment.setPaymentId(150);
		payment.setPaymentAmount(120);
		payment.setPaymentStatus("success");
		
		paymentServiceImpl.savePayment(payment);  
	}
	
	@Test
	public void testFindPaymentById() {
		Payment payment=new Payment();
		payment.setPaymentId(150);
		payment.setPaymentAmount(120);
		payment.setPaymentStatus("success");
		
        Optional<Payment> optionalPayment = Optional.of(payment);
        
		when(paymentRepository.findById(150)).thenReturn(optionalPayment);
		
	    assertEquals("success",payment.getPaymentStatus());
	    assertEquals(120,payment.getPaymentAmount());
	}
	
	
	@Test
	public void testPaymentDetailsNotFoundException() {
		when(paymentRepository.findById(20)).thenThrow(PaymentDetailsNotFoundException.class);
        
        assertThrows(PaymentDetailsNotFoundException.class,()->paymentServiceImpl.findPaymentById(20));
	}
	
	
	@Test
	public void testUpdatePayment() {
		Payment payment=new Payment();
		payment.setPaymentId(150);
		payment.setPaymentAmount(120);
		payment.setPaymentStatus("fail");
		
		Optional<Payment> optionalPayment = Optional.of(payment);
		when(paymentRepository.findById(150)).thenReturn(optionalPayment);  
	    assertEquals(120,payment.getPaymentAmount());
	}
	
	@Test
	public void testDeletePaymentbyId(){
	Payment payment=new Payment();
	payment.setPaymentId(150);
	payment.setPaymentAmount(120);
	payment.setPaymentStatus("success");
	when(paymentRepository.findById(payment.getPaymentId())).thenReturn(Optional.of(payment));
	paymentServiceImpl.deletePaymentbyId(payment.getPaymentId());
	verify(paymentRepository).deleteById(payment.getPaymentId());
	}
	
}