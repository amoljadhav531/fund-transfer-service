package com.hcl.fundtransfer.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.fundtransfer.entity.Payee;
import com.hcl.fundtransfer.repository.PayeeRepository;

@RunWith(MockitoJUnitRunner.class)
public class TransactionValidationServiceImplTest {
	
	@InjectMocks
	private TransactionValidationServiceImpl transactionValidationServiceImpl;
	
	@Mock
	private PayeeRepository payeeRepository;
	
	private Payee payee;
	

	@Before
	public void setUp() {
		payee = new Payee();
		payee.setOtp(1234);
		payee.setStatus("Pending");
	}
	
	@Test
	public void testValidate() {
		when(payeeRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(payee));
		assertNotNull(transactionValidationServiceImpl.validate(1234, Long.valueOf(1)));
	}
	
	@Test
	public void testValidateWhenDeleteRequest() {
		payee.setStatus("Success");
		when(payeeRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(payee));
		assertNotNull(transactionValidationServiceImpl.validate(1234, Long.valueOf(1)));
	}
	
	@Test
	public void testValidateWhenInvalidOtp() {
		payee.setStatus("Success");
		when(payeeRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(payee));
		assertNotNull(transactionValidationServiceImpl.validate(123, Long.valueOf(1)));
	}
	
	@Test
	public void testValidateWhenInvalidTransactionId() {
		payee.setStatus("Success");
		when(payeeRepository.findById(Long.valueOf(1))).thenReturn(Optional.empty());
		assertNotNull(transactionValidationServiceImpl.validate(123, Long.valueOf(1)));
	}

}
