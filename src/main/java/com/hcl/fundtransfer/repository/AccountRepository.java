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

}
