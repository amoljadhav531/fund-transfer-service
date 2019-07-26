package com.hcl.fundtransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.fundtransfer.entity.TransactionHistory;

/**
 * TransectionRepository interface represent the transaction_details table repository
 * @author amol.jadhav
 */
@Repository
public interface TransectionRepository extends JpaRepository<TransactionHistory, Integer> {

}
