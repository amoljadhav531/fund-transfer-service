package com.hcl.fundtransfer.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.hcl.fundtransfer.dto.UserDetailsDto;
import com.hcl.fundtransfer.entity.Account;
import com.hcl.fundtransfer.entity.UserDetails;
import com.hcl.fundtransfer.repository.AccountRepository;
import com.hcl.fundtransfer.repository.UserRepository;

/**
 * UserService class used for to serve the user registration and login operation
 * 
 * @author amol.jadhav
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AccountRepository accountRepository;

	/**
	 * Method used to register the user and create its account
	 * 
	 * @param user contain details for registration and account creation
	 * @return Account details
	 */
	public Account registerUser(UserDetailsDto user) {

		UserDetails userDetails = new UserDetails();
		Account account = new Account();
		try {
			BeanUtils.copyProperties(user, userDetails);

			account.setAccountNumber(generateAccountNumber());
			account.setBalance(1000);
			account.setIfscCode("SBI000014");
			account.setUserDetails(userDetails);
			userDetails.setAccount(account);
			account = userRepository.save(userDetails).getAccount();

		} catch (Exception ex) {

		}
		return account;
	}

	/**
	 * Method used to check if user exist in record or not
	 * 
	 * @param userName login user-name
	 * @return
	 */
	public boolean userExist(String userName) {
		return userRepository.existsById(111l);
	}

	/**
	 * Method used for checking user credentials while login
	 * 
	 * @param userName login user-name
	 * @param password login user password
	 * @return
	 */
	public boolean checkLogin(String userName, String password) {
		if (ObjectUtils.isEmpty(userRepository.findByUsernameAndPassword(userName, password)))
			return false;

		return true;
	}

	/**
	 * Utility method to get random number for account
	 * 
	 * @return Account Number
	 */
	private long generateAccountNumber() {
		return (long) (Math.random() * 100000 + 3333300000L);
	}
}
