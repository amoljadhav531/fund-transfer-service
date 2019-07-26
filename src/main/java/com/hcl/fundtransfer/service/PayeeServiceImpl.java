package com.hcl.fundtransfer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.fundtransfer.dto.PayeeDto;
import com.hcl.fundtransfer.dto.ResponseData;
import com.hcl.fundtransfer.entity.Payee;
import com.hcl.fundtransfer.entity.UserDetails;
import com.hcl.fundtransfer.exception.ResourceNotFoundException;
import com.hcl.fundtransfer.repository.PayeeRepository;
import com.hcl.fundtransfer.repository.UserRepository;

public class PayeeServiceImpl implements PayeeService {

	@Autowired
	private PayeeRepository payeeRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public ResponseData deletePayee(PayeeDto payeeDto) {
		Long userId = payeeDto.getUserId();
		Long payeeId = payeeDto.getPayeeId();
		Optional<Payee> payee = payeeRepository.findById(payeeId);
		if (payee.isPresent()) {
			Payee payee2 = payee.get();
			UserDetails user = payee2.getUserId();
			if (user == null) {
				throw new ResourceNotFoundException("User is not present for this payee Id");
			} else {
				 payeeRepository.deleteById(payee2.getPayeeTrackId());
			}

		} else {
			throw new ResourceNotFoundException("Please enter proper User Id");
		}
		
		return null;
	}

}
