/**
 * 
 */
package com.abc.simplehouse.payload;

/**
 * @author brahm
 * 10-Jul-2021
 */
public class ForgetPassword {
	
	String customerEmail;
	String password;
	String reEnterPassword;
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getReEnterPassword() {
		return reEnterPassword;
	}
	public void setReEnterPassword(String reEnterPassword) {
		this.reEnterPassword = reEnterPassword;
	}
	

}
