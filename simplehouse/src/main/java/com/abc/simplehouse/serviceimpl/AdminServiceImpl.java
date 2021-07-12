/**
 * 
 */
package com.abc.simplehouse.serviceimpl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.simplehouse.entity.Admin;
import com.abc.simplehouse.exceptions.AdminAlreadyExistingException;
import com.abc.simplehouse.exceptions.AdminNotFoundException;
import com.abc.simplehouse.exceptions.CredentialsNotValidException;
import com.abc.simplehouse.repository.AdminRepository;
import com.abc.simplehouse.service.AdminService;

/**
 * @author brahm
 * 11-Jul-2021
 */
@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
    private AdminRepository adminRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	/**
	 * implements saveAdmin from adminservice interface
	 * {@inheritDoc}
	 */
	@Override
	public void saveAdmin(Admin admin) throws AdminAlreadyExistingException {
		
		LOGGER.info("Save admin method is started.");
		
		Optional<Admin> adminEntity =adminRepository.findByAdminName(admin.getAdminName());
		if(adminEntity.isPresent()) {
			throw new AdminAlreadyExistingException("Admin is already exist with this Name"+admin.getAdminName());
		}
		else {
		
			adminRepository.save(admin);
			LOGGER.info("Admin details saved in repository");
		
		}
		LOGGER.info("Admin save method completed successfully.");
		
	}
	/**
	 *  implements deleteAdmin from adminservice interface
	 * {@inheritDoc}
	 */
	
	@Override
	public void deleteAdminbyId(int id) throws AdminNotFoundException {		
		LOGGER.info("Delete admin method started.");		
		Optional<Admin> adminEntity =adminRepository.findById(id);
		if(adminEntity.isPresent()) {
			adminRepository.deleteById(id);		
		}
		else {	
			LOGGER.error("Admin not found with this Id ",id);	
		throw new AdminNotFoundException ("can not find Admin with this Id "+id);
		}		
		LOGGER.info("Delete admin method ran successfully.");
	}
	
	
	@Override
	public Admin loginAdmin(String adminEmail, String adminPassword) {
		
		Optional<Admin> optionalAdmin=Optional.ofNullable(adminRepository.adminLogin(adminEmail, adminPassword));
		if(optionalAdmin.isEmpty())
			throw new CredentialsNotValidException("Credentials are not valid.");
		else
			return optionalAdmin.get();
	
		
	} 
}
