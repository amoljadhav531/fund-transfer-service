package com.hcl.fundtransfer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.fundtransfer.entity.Account;

/**
 * AccountRepository interface represent the Account table repository
 * @author amol.jadhav
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

	/**
	 * Method returns Account table recored matched with given username
	 * @param username login user-name
	 * @return Account object
	 */
	public Account findByUsername(String username);
	
	/**
	 * Method returns user name and account number for reach user
	 * @param userName login user name
	 * @return List<Object[]> object
	 */
	@Query("SELECT username,accountNumber from Account WHERE username !=:userName")
	public List<Object[]> getUserNameAndAccountNumbers(@Param("userName") String userName);
}
