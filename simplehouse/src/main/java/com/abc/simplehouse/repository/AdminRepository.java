/**
 * 
 */
package com.abc.simplehouse.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abc.simplehouse.entity.Admin;


/**
 * @author brahm
 * 11-Jul-2021
 */
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	/**
	 * Repository for findByAdminName
	 * @param name
	 * @return Admin
	 */  
  public Optional<Admin> findByAdminName(String name);
  
  /**
   * Repository for deleteByAdminName
   * @param name
   */
	public void deleteByAdminName(String name);
	
	@Query("SELECT c FROM Admin c WHERE admin_email = ?1 AND admin_password = ?2")
	public Admin adminLogin(String adminEmail, String adminPassword);

}
