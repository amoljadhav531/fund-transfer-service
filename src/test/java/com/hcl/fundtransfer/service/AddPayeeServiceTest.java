package com.hcl.fundtransfer.service;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.fundtransfer.dto.PayeeDto;
import com.hcl.fundtransfer.dto.ResponseData;
import com.hcl.fundtransfer.entity.Account;
import com.hcl.fundtransfer.entity.Payee;
import com.hcl.fundtransfer.entity.UserDetails;
import com.hcl.fundtransfer.repository.PayeeRepository;
import com.hcl.fundtransfer.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)

public class AddPayeeServiceTest {

	private List<UserDetails> list;
	private UserDetails user;
	private Account account;
	private UserDetails payee;
	private PayeeDto payeeDto;

	@Mock
	private PayeeRepository payeeRepository;
	private Payee payeee;
	@Mock
	private UserRepository userRepository;

	@Mock
	private OtpSenderUtility otpSenderUtility;

	@InjectMocks
	AddPayeeService addPayeeService;

	@Before
	public void setUp() throws Exception {

		payeee = new Payee();

		user = new UserDetails();

		account = new Account();
		account.setAccountNumber(1029394956L);
		account.setBalance(10000.00);
		account.setIfscCode("SECR0000120");

		user.setAccount(account);
		user.setDob(new Date(1995 - 12 - 02).toLocalDate());
		user.setEmail("simarkaur1295@gmail.com");
		user.setFullName("Harsimar Kaur");
		user.setGender("Female");
		user.setMobileNumber("9422390512");
		user.setPassword("password");
		user.setUserId(1L);
		user.setUsername("harsimar.kaur");

		payee = new UserDetails();
		payee.setAccount(account);
		payee.setDob(new Date(1995 - 12 - 02).toLocalDate());
		payee.setEmail("amolJadhav@gmail.com");
		payee.setFullName("Amol Jadhav");
		payee.setGender("Male");
		payee.setMobileNumber("9422390512");
		payee.setPassword("password");
		payee.setUserId(22L);
		payee.setUsername("amol.jadhav");

		payeee.setPayeeId(payee);

		list = new ArrayList<>();
		list.add(user);

		payeeDto = new PayeeDto();
		payeeDto.setPayeeId(22L);
		payeeDto.setUserId(1L);

	}

	@Test
	public void test() {
		Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
		Mockito.when(userRepository.findById(22L)).thenReturn(Optional.of(payee));
		ResponseData response = addPayeeService.addPayee(payeeDto);
		assertEquals("OTP has been send to your Mobile No and Email", response.getMessage());
		assertTrue(true);
	}

}
