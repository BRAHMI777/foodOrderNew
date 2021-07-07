/**
 * @author gowthami
 * @date 2021-07-07
 *
 */

package com.abc.simplehouse.service;

import com.abc.simplehouse.entity.Payment;

public interface PaymentService {

	/**
	 * This method is used to save payment details
	 * @param payment
	 * @return void
	 */
	public void savePayment(Payment payment);
	

	/**
	 * This method is used to delete payment details using paymentId
	 * @param id
	 * @return void
	 */
	public void deletePaymentbyId(int id);
	
	

	/**
	 * This method is used to update payment details
	 * @param payment
	 * @return Payment
	 */
     public void updatePayment(int paymentId);
	

	/**
	 * This method is used to find payment details by paymentId
	 * @param id
	 * @return Payment
	 */
	public Payment findPaymentById(int id);

}
