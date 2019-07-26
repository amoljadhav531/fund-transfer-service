package com.hcl.fundtransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.fundtransfer.entity.UserDetails;

/**
 * UserRepository interface represent the User table repository
 * @author amol.jadhav
 */
@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long>{

	/**
	 * Method return User based on user-name and password
	 * @param username login user-name
	 * @param password login user password
	 * @return
	 */
	public UserDetails findByUsernameAndPassword(String username,String password);
}
