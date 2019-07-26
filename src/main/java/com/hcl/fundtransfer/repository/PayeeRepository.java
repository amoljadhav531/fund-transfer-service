package com.hcl.fundtransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.fundtransfer.entity.Payee;

@Repository
public interface PayeeRepository extends JpaRepository<Payee, Long> {

}
