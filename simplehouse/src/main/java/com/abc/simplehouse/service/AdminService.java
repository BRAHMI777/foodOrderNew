/**
 * 
 */
package com.abc.simplehouse.service;

import com.abc.simplehouse.entity.Admin;
import com.abc.simplehouse.exceptions.AdminAlreadyExistingException;
import com.abc.simplehouse.exceptions.AdminNotFoundException;

/**
 * @author brahm
 * 11-Jul-2021
 */

public interface AdminService {
	
	    /**
	     * 
	     * @param admin
	     * @throws AdminAlreadyExistingException
	     */
	    public void saveAdmin(Admin admin) throws AdminAlreadyExistingException;
		/**
		 * 
		 * @param id
		 * @throws AdminNotFoundException
		 */
		public void deleteAdminbyId(int id) throws AdminNotFoundException;
		
		
		public Admin loginAdmin(String adminEmail, String adminPassword);
	
}
	
	
