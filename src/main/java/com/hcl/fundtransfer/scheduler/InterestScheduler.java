package com.hcl.fundtransfer.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hcl.fundtransfer.entity.Account;
import com.hcl.fundtransfer.repository.AccountRepository;

/**
 * InterestScheduler class is used to schedule yearly interest
 * @author amol.jadhav
 */
@Component
public class InterestScheduler {

	@Autowired
	private AccountRepository accountRepository;
	
	/**
	 * Method used to schedule yearly interest
	 */
	@Scheduled(fixedRate = 60000)
	public void scheduleInerest() {
		List<Account> accounts = accountRepository.findAll();	
		accounts.stream().forEach(acc -> acc.setBalance(acc.getBalance() +(acc.getBalance() *0.10)));		
		accountRepository.saveAll(accounts);
	}
}
