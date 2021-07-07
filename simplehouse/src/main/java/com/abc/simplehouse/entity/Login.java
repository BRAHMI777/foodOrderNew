/**
 * 
 */
package com.abc.simplehouse.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author midhh
 *
 */
@Entity
@Table(name = "LOGIN_TBL")
public class Login {
	 @Id
	 private int customerId;
	 private String customerEmail;
	 private String customerPassword;
	 /**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the customerEmail
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}
	/**
	 * @param customerEmail the customerEmail to set
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	/**
	 * @return the customerPassword
	 */
	public String getCustomerPassword() {
		return customerPassword;
	}
	/**
	 * @param customerPassword the customerPassword to set
	 */
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	

}
