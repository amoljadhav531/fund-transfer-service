package com.hcl.fundtransfer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.hcl.fundtransfer.dto.PayeeDto;
import com.hcl.fundtransfer.dto.ResponseData;
import com.hcl.fundtransfer.entity.Payee;
import com.hcl.fundtransfer.entity.UserDetails;
import com.hcl.fundtransfer.repository.PayeeRepository;
import com.hcl.fundtransfer.repository.UserRepository;

@Service
public class PayeeServiceImpl implements PayeeService {

	@Autowired
	private PayeeRepository payeeRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OtpSenderUtility otpSenderUtility;

	@Override
	public ResponseData deletePayee(PayeeDto payeeDto) {
		ResponseData responseData = new ResponseData();
		Optional<UserDetails> userdetails = userRepository.findById(payeeDto.getUserId());
		if (userdetails.isPresent()) {
			List<Payee> payees = payeeRepository.findByUserId(userdetails.get());
			boolean flag = false;
			if (!ObjectUtils.isEmpty(payees)) {
				for (Payee payee : payees) {
					if (payee.getPayeeId().getUserId() == payeeDto.getPayeeId()) {
						flag = true;

					}
				}

				if (flag) {
					Optional<UserDetails> payeeDetails = userRepository.findById(payeeDto.getPayeeId());
					Payee paye = payeeRepository.findByUserIdAndPayeeId(userdetails.get(), payeeDetails.get());
					paye.setOtp(generateOtp());
					payeeRepository.save(paye);
					//otpSenderUtility.sendNotification(paye);
					responseData.setMessage("OTP has been send to your Mobile No and Email");
					responseData.setHttpStatus(HttpStatus.OK);
					return responseData;
				} else {

					responseData.setMessage("Payee with Id " + payeeDto.getPayeeId() + " not found for this userId");
					responseData.setHttpStatus(HttpStatus.BAD_REQUEST);
					return responseData;
				}

			} else {
				responseData.setHttpStatus(HttpStatus.BAD_REQUEST);
				responseData.setMessage("No Payee found for this user");
				return responseData;
			}

		} else {
			responseData.setHttpStatus(HttpStatus.BAD_REQUEST);
			responseData.setMessage("Incorrect UserId");
			return responseData;
		}

	}

	private int generateOtp() {
		return (int) (Math.random() * 1000 + 33000L);
	}

}
