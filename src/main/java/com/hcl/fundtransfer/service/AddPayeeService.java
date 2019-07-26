package com.hcl.fundtransfer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.fundtransfer.dto.PayeeDto;
import com.hcl.fundtransfer.entity.Payee;
import com.hcl.fundtransfer.entity.UserDetails;
import com.hcl.fundtransfer.exception.ResourceNotFoundException;
import com.hcl.fundtransfer.repository.PayeeRepository;
import com.hcl.fundtransfer.repository.UserRepository;

@Service
public class AddPayeeService {

	@Autowired
	PayeeRepository payeeRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public Payee addPayee(PayeeDto payeeDto) {
		
		Optional<UserDetails> payeeDetails = userRepository.findById(payeeDto.getPayeeId());
		Optional<UserDetails> userDetails = userRepository.findById(payeeDto.getUserId());
		
		Payee payee = new Payee();
		if(payeeDetails.get()==null && userDetails.get()==null) {
			throw new ResourceNotFoundException("Payee Details and User details does not exist");
		}
		payee.setPayeeId(payeeDetails.get());
		payee.setUserId(userDetails.get());
		payee.setOtp(20232);
		payee.setStatus("PENDING");
		
		payeeRepository.save(payee);
		
		return null;
	}
	
}
