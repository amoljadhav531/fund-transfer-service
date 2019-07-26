package com.hcl.fundtransfer.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.hcl.fundtransfer.dto.OtpValidationDto;
import com.hcl.fundtransfer.dto.ResponseData;
import com.hcl.fundtransfer.service.TransactionValidationService;

@RunWith(MockitoJUnitRunner.class)
public class TransactionValidationControllerTest {

	@InjectMocks
	private TransactionValidationController transactionValidationController;

	@Mock
	private TransactionValidationService transactionValidationService;

	private OtpValidationDto otpValidationDto;

	@Before
	public void setUp() {
		otpValidationDto = new OtpValidationDto();
		otpValidationDto.setOtp(1234);
		otpValidationDto.setPayeeTrackId(Long.valueOf(1));
	}

	@Test
	public void testValidate() {

		when(transactionValidationService.validate(otpValidationDto.getOtp(), otpValidationDto.getPayeeTrackId()))
				.thenReturn(new ResponseData("Success", HttpStatus.ACCEPTED, null));
		assertNotNull(transactionValidationController.validate(otpValidationDto));
	}

}
