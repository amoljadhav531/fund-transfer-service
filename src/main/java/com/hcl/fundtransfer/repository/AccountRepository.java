package com.hcl.fundtransfer.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.fundtransfer.entity.Account;

/**
 * AccountRepository interface represent the Account table repository
 * @author amol.jadhav
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

}
