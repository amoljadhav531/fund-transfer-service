/*
 * package com.hcl.fundtransfer.service;
 * 
 * import java.util.Optional;
 * 
 * import org.springframework.http.HttpStatus; import
 * org.springframework.stereotype.Service;
 * 
 * import com.hcl.fundtransfer.dto.ResponseData;
 * 
 * import lombok.extern.slf4j.Slf4j;
 * 
 * @Service
 * 
 * @Slf4j public class ValidateServiceImpl implements ValidateService {
 * 
 * @Override public ResponseData validate(int otp, long payeeTrackerId) {
 * log.debug("Validating user"); ResponseData response = new ResponseData();
 * Optional<TransactionDetail> transactionDetails =
 * transactionDetailRepository.findById(transactionId);
 * if(transactionDetails.isPresent()) { TransactionDetail transactionDetail =
 * transactionDetails.get(); if(transactionDetail.getTransactionOtp()==otp) {
 * transactionDetail.setTransactionStatus("Successful");
 * transactionDetail.setTransactionOtp(0);
 * transactionDetailRepository.save(transactionDetail);
 * response.setMessage("Transaction Successful");
 * response.setHttpStatus(HttpStatus.OK); return response; }else {
 * response.setMessage("Invalid OTP");
 * response.setHttpStatus(HttpStatus.EXPECTATION_FAILED); return response; } }
 * response.setMessage("Incorrect Transaction ID");
 * response.setHttpStatus(HttpStatus.BAD_REQUEST); return response; } }
 */