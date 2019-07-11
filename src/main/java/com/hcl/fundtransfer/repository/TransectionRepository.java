package com.hcl.fundtransfer.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.fundtransfer.entity.TransactionDetails;

/**
 * TransectionRepository interface represent the transaction_details table repository
 * @author amol.jadhav
 */
@Repository
public interface TransectionRepository extends JpaRepository<TransactionDetails, Integer> {

	/**
	 * Method returns List of Transaction done for user
	 * @param username login user name
	 * @param page paging object
	 * @return
	 */
	public List<TransactionDetails> findAllByUsername(String username,Pageable page);
}
