package com.hcl.fundtransfer.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.fundtransfer.dto.FundTransferDto;
import com.hcl.fundtransfer.dto.ResponseData;
import com.hcl.fundtransfer.entity.Account;
import com.hcl.fundtransfer.entity.Payee;
import com.hcl.fundtransfer.entity.TransactionHistory;
import com.hcl.fundtransfer.entity.UserDetails;
import com.hcl.fundtransfer.repository.AccountRepository;
import com.hcl.fundtransfer.repository.PayeeRepository;
import com.hcl.fundtransfer.repository.TransectionRepository;
import com.hcl.fundtransfer.repository.UserRepository;

/**
 * TransectionService class used for to serve the transaction operation
 * 
 * @author amol.jadhav
 */
@Service
public class TransectionService {

	@Autowired
	private TransectionRepository transectionRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PayeeRepository payeeRepository;

	/**
	 * Method returns List of Transaction done for user
	 * 
	 * @param username login user name
	 * @param page     paging object
	 * @return
	 */
	public List<TransactionHistory> getTransectionHistory(String userName) {
		UserDetails userDetails = userRepository.findByUsername(userName);
		return userDetails.getAccount().getTransactionHistories();
	}

	/**
	 * Method used to transfer fund from one account to another
	 * 
	 * @param fundTransfer Object having details required to transfer a fund
	 * @throws Exception
	 */
	@Transactional
	public void fundTransfer(FundTransferDto fundTransfer) throws Exception {
			Optional<UserDetails> loginUserDetails = userRepository.findById(fundTransfer.getUserId());
			Optional<UserDetails> payeeUserDetails = userRepository.findById(fundTransfer.getPayeeId());
			if (loginUserDetails.isPresent() && payeeUserDetails.isPresent()) {
				Account loginUserAccount = loginUserDetails.get().getAccount();
				Account payeeUserAccount = payeeUserDetails.get().getAccount();

				payeeUserAccount.setBalance(payeeUserAccount.getBalance() + fundTransfer.getAmount());
				accountRepository.save(payeeUserAccount);
				loginUserAccount.setBalance(loginUserAccount.getBalance() - fundTransfer.getAmount());
				accountRepository.save(loginUserAccount);

				TransactionHistory loginUserTransectionDetails = new TransactionHistory();
				TransactionHistory payeeUserTransectionDetails = new TransactionHistory();

				loginUserTransectionDetails.setAvailableBalance(loginUserAccount.getBalance());
				loginUserTransectionDetails.setAmount(fundTransfer.getAmount());
				loginUserTransectionDetails.setDate(getCurrentDateTime());
				loginUserTransectionDetails.setTransactionType("DEBITED");
				loginUserTransectionDetails.setAccount(loginUserAccount);

				payeeUserTransectionDetails.setAvailableBalance(payeeUserAccount.getBalance());
				payeeUserTransectionDetails.setAmount(fundTransfer.getAmount());
				payeeUserTransectionDetails.setDate(getCurrentDateTime());
				payeeUserTransectionDetails.setTransactionType("CREDITED");
				payeeUserTransectionDetails.setAccount(payeeUserAccount);

				transectionRepository.save(loginUserTransectionDetails);
				transectionRepository.save(payeeUserTransectionDetails);

			}

	}

	/**
	 * Utility method to get current date time
	 * 
	 * @return
	 */
	private String getCurrentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public ResponseData getAllPayees(Long userId) {
		List<Payee> payees = new ArrayList<>();
		ResponseData response = new ResponseData();
		Optional<UserDetails> user = userRepository.findById(userId);
		if (user.isPresent()) {
			payees = payeeRepository.findByUserId(user.get());
			response.setMessage("Payees for your are: ");
			response.setHttpStatus(HttpStatus.OK);
			response.setData(payees);
			return response;
		}
		
		response.setMessage("Incorrect UserId");
		response.setHttpStatus(HttpStatus.BAD_REQUEST);
		return response;
	}
}
