/**
 * 
 */
package com.abc.simplehouse.payload;

/**
 * @author brahm
 * 10-Jul-2021
 */
public class ResetPassword {
	
	String customerEmail;
	String password;
	String newPassword;
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
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	

}
