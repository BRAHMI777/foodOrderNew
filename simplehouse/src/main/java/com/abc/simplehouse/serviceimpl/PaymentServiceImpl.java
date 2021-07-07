package com.abc.simplehouse.serviceimpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.simplehouse.entity.Payment;
import com.abc.simplehouse.exceptions.PaymentAlreadyExistsException;
import com.abc.simplehouse.exceptions.PaymentDetailsNotFoundException;
import com.abc.simplehouse.repository.PaymentRepository;
import com.abc.simplehouse.service.PaymentService;


/**
 * @author gowthami
 * @date 2021-07-07
 *
 */
@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
    private PaymentRepository paymentRepository;
	
	private static final Logger LOGGER =LoggerFactory.getLogger(PaymentServiceImpl.class);
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void savePayment(Payment payment)  {
		LOGGER.info("savePayment method is started");
		
		Optional<Payment> optionalPayment=paymentRepository.findById(payment.getPaymentId());
		if(optionalPayment.isPresent())
		{
			throw new PaymentAlreadyExistsException("Payment Already exists with this id "+payment.getPaymentId());
		}
		else
		{
		paymentRepository.save(payment);
		LOGGER.info("Payment details saved successfully");
		}
    }


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deletePaymentbyId(int id)  {
		    LOGGER.info("deletePaymentbyId method is started");
		    Optional<Payment> optionalPayment=paymentRepository.findById(id);
			if(optionalPayment.isEmpty())
			{
				throw new PaymentDetailsNotFoundException("Payment not found with this id "+id);
			}
			else
			{
			paymentRepository.deleteById(id);
			LOGGER.info("Payment details deleted successfully");
			}
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updatePayment(int paymentId){
		LOGGER.info("updatePayment method is started");	
		Optional<Payment> optionalPayment= paymentRepository.findById(paymentId);
		if(optionalPayment.isPresent())
		{
		Payment payment=optionalPayment.get();
		payment.setPaymentStatus("Success");
		payment.setPaymentAmount(1000);
		paymentRepository.save(payment);
		LOGGER.info("Payment details are updated");
		}
		else
		{
			LOGGER.error("PaymentDetailsNotFoundException is encountered");
			throw new PaymentDetailsNotFoundException("Payment details Not Found with id " +paymentId);
		}
			
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Payment findPaymentById(int id) throws PaymentDetailsNotFoundException {
		LOGGER.info("findPaymentBy method is started");
		Optional<Payment> optionalPayment= paymentRepository.findById(id);
		if(optionalPayment.isPresent()) {
		LOGGER.info("Payment details are found");
		return optionalPayment.get();
		}
		
		else {
			LOGGER.error("PaymentDetailsNotFoundException is encountered");
			throw new PaymentDetailsNotFoundException("Payment details Not Found with id " +id);
			
		}
		
	}

}
