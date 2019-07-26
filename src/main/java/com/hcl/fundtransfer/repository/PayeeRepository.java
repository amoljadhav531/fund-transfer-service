package com.hcl.fundtransfer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.fundtransfer.entity.Payee;
import com.hcl.fundtransfer.entity.UserDetails;

@Repository
public interface PayeeRepository extends JpaRepository<Payee, Long> {
	public List<Payee> findByUserId(UserDetails userId);

	public Optional<Payee> findByPayeeId(UserDetails payeeId);
	
	public Payee findByUserIdAndPayeeId(UserDetails userId, UserDetails payeeId);

}
