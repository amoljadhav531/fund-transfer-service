
package com.hcl.fundtransfer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.fundtransfer.dto.ResponseData;
import com.hcl.fundtransfer.entity.Payee;
import com.hcl.fundtransfer.repository.PayeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransactionValidationServiceImpl implements TransactionValidationService {

	@Autowired
	private PayeeRepository payeeRepository;

	@Override
	public ResponseData validate(int otp, long payeeTrackerId) {
		log.debug("Validating user");
		ResponseData response = new ResponseData();
		Optional<Payee> payeeOptional = payeeRepository.findById(payeeTrackerId);
		if (payeeOptional.isPresent()) {
			Payee payee = payeeOptional.get();
			if (payee.getOtp() == otp) {
				if (!payee.getStatus().equalsIgnoreCase("Success")) {
					payee.setStatus("Success");
					payee.setOtp(0);
					payeeRepository.save(payee);
				} else {
					payeeRepository.delete(payee);
				}
				response.setMessage("Transaction Successful");
				response.setHttpStatus(HttpStatus.OK);
				return response;
			} else {
				response.setMessage("Invalid OTP");
				response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
				return response;
			}
		}
		response.setMessage("Incorrect Transaction ID");
		response.setHttpStatus(HttpStatus.BAD_REQUEST);
		return response;
	}
}
