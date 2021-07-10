/**
 * 
 */
package com.abc.simplehouse.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * @author midhh
 *
 */
@Entity
@Table(name = "LOGIN_TBL")

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) 
public class Login {
	 @Id
	 private int loginId;
	 private String customerName;
	 private String customerPassword;
	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return loginId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.loginId = customerId;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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