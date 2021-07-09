/**
 * 
 */
package com.abc.simplehouse.payload;

/**
 * @author midhh
 *
 */
public class LoginPayLoad {
	
	 private String customerEmail;
	 private String customerPassword;
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