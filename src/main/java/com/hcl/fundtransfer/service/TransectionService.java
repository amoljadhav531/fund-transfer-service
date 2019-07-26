/*
 * package com.hcl.fundtransfer.service;
 * 
 * import java.text.DateFormat; import java.text.SimpleDateFormat; import
 * java.util.ArrayList; import java.util.Date; import java.util.List;
 * 
 * import javax.transaction.Transactional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.data.domain.PageRequest; import
 * org.springframework.data.domain.Pageable; import
 * org.springframework.data.domain.Sort; import
 * org.springframework.stereotype.Service; import
 * org.springframework.util.ObjectUtils;
 * 
 * import com.hcl.fundtransfer.entity.Account; import
 * com.hcl.fundtransfer.entity.TransactionHistory; import
 * com.hcl.fundtransfer.model.FundTransferDto; import
 * com.hcl.fundtransfer.model.PayeeDto; import
 * com.hcl.fundtransfer.repository.AccountRepository; import
 * com.hcl.fundtransfer.repository.TransectionRepository;
 * 
 *//**
	 * TransectionService class used for to serve the transaction operation
	 * 
	 * @author amol.jadhav
	 */
/*
 * @Service public class TransectionService {
 * 
 * @Autowired private TransectionRepository transectionRepository;
 * 
 * @Autowired private AccountRepository accountRepository;
 * 
 *//**
	 * Method returns List of Transaction done for user
	 * 
	 * @param username login user name
	 * @param page     paging object
	 * @return
	 */
/*
 * public List<TransactionHistory> getTransectionHistory(String userName) {
 * Pageable byDate = PageRequest.of(0, 2,Sort.by("date").descending()); return
 * transectionRepository.findAllByUsername(userName,byDate); }
 * 
 *//**
	 * Method returns the List of payee available for login user
	 * 
	 * @param userName login user user-name
	 * @return
	 */
/*
 * public List<PayeeDto> getAllPayees(String userName) { List<PayeeDto> payees =
 * new ArrayList<>();
 * 
 * List<Object[]> resultSet =
 * accountRepository.getUserNameAndAccountNumbers(userName);
 * 
 * if (!ObjectUtils.isEmpty(resultSet)) { resultSet.stream().forEach(a -> {
 * String column1 = (String) a[0]; long column2 = (long) a[1]; PayeeDto payee =
 * new PayeeDto(column1, column2); payees.add(payee); }); }
 * 
 * return payees;
 * 
 * }
 * 
 *//**
	 * Method used to transfer fund from one account to another
	 * 
	 * @param fundTransfer Object having details required to transfer a fund
	 * @throws Exception
	 */
/*
 * @Transactional public void fundTransfer(FundTransferDto fundTransfer) throws
 * Exception { try { Account loginUserAccount =
 * accountRepository.findByUsername(fundTransfer.getLoginUserName()); Account
 * payeeUserAccount =
 * accountRepository.findById(fundTransfer.getPayee().getAccountNumber()).get();
 * 
 * payeeUserAccount.setBalance(payeeUserAccount.getBalance() +
 * fundTransfer.getAmount()); accountRepository.save(payeeUserAccount);
 * loginUserAccount.setBalance(loginUserAccount.getBalance() -
 * fundTransfer.getAmount()); accountRepository.save(loginUserAccount);
 * 
 * TransactionHistory loginUserTransectionDetails = new TransactionHistory();
 * TransactionHistory payeeUserTransectionDetails = new TransactionHistory();
 * 
 * loginUserTransectionDetails.setAccountNumber(loginUserAccount.
 * getAccountNumber());
 * loginUserTransectionDetails.setBalance(loginUserAccount.getBalance());
 * loginUserTransectionDetails.setCreditedDabitedAmount(fundTransfer.getAmount()
 * ); loginUserTransectionDetails.setDate(getCurrentDateTime());
 * loginUserTransectionDetails.setOpration("DEBITED");
 * loginUserTransectionDetails.setUsername(loginUserAccount.getUsername());
 * 
 * payeeUserTransectionDetails.setAccountNumber(payeeUserAccount.
 * getAccountNumber());
 * payeeUserTransectionDetails.setBalance(payeeUserAccount.getBalance());
 * payeeUserTransectionDetails.setCreditedDabitedAmount(fundTransfer.getAmount()
 * ); payeeUserTransectionDetails.setDate(getCurrentDateTime());
 * payeeUserTransectionDetails.setOpration("CREDITED");
 * payeeUserTransectionDetails.setUsername(payeeUserAccount.getUsername());
 * 
 * transectionRepository.save(loginUserTransectionDetails);
 * transectionRepository.save(payeeUserTransectionDetails);
 * 
 * } catch (Exception ex) { throw new Exception("Opertation unsccessful"); } }
 * 
 *//**
	 * Utility method to get current date time
	 * 
	 * @return
	 *//*
		 * private String getCurrentDateTime() { DateFormat dateFormat = new
		 * SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); Date date = new Date(); String
		 * formattedDate = dateFormat.format(date); return formattedDate; } }
		 */