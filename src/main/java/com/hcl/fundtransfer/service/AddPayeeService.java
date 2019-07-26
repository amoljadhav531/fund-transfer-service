package com.hcl.fundtransfer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.fundtransfer.dto.PayeeDto;
import com.hcl.fundtransfer.dto.ResponseData;
import com.hcl.fundtransfer.entity.Payee;
import com.hcl.fundtransfer.entity.UserDetails;
import com.hcl.fundtransfer.repository.PayeeRepository;
import com.hcl.fundtransfer.repository.UserRepository;

@Service
public class AddPayeeService {

	@Autowired
	private PayeeRepository payeeRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OtpSenderUtility otpSenderUtility;

	public ResponseData addPayee(PayeeDto payeeDto) {

		ResponseData response = new ResponseData();
		Optional<UserDetails> payeeDetails = userRepository.findById(payeeDto.getPayeeId());
		Optional<UserDetails> userDetails = userRepository.findById(payeeDto.getUserId());

		if (userDetails.isPresent() && payeeDetails.isPresent()) {
			Payee payee = new Payee();
			payee.setUserId(userDetails.get());
			payee.setPayeeId(payeeDetails.get());
			payee.setOtp(generateOtp());
			payee.setStatus("PENDING");
			payee = payeeRepository.save(payee);

			otpSenderUtility.sendNotification(payee);
			
			response.setMessage("OTP has been send to your Mobile No and Email");
			response.setHttpStatus(HttpStatus.OK);
			return response;
		}

		response.setMessage("Incorrect UserId or PayeeId");
		response.setHttpStatus(HttpStatus.BAD_REQUEST);
		return response;

	}

	private int generateOtp() {
		return (int) (Math.random() * 1000 + 33000L);
	}

}
