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

import com.hcl.fundtransfer.dto.ResponseData;
import com.hcl.fundtransfer.entity.Account;
import com.hcl.fundtransfer.entity.UserDetails;
import com.hcl.fundtransfer.repository.PayeeRepository;
import com.hcl.fundtransfer.repository.UserRepository;
import com.jayway.jsonpath.Option;

@RunWith(MockitoJUnitRunner.class)
public class TransectionServiceTest {

	List<UserDetails> list;
	UserDetails user;
	Account account;
	
	@Mock
	PayeeRepository payeeRepository;
	
	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	TransectionService transectionService;
	
	@Before
	public void setUp() throws Exception {
		user = new UserDetails();
		
		account = new Account();
		account.setAccountNumber(1029394956L);
		account.setBalance(10000.00);
		account.setIfscCode("SECR0000120");
		
		user.setAccount(account);
		user.setDob(new Date(1995-12-02).toLocalDate());
		user.setEmail("simarkaur1295@gmail.com");
		user.setFullName("Harsimar Kaur");
		user.setGender("Female");
		user.setMobileNumber(9422390512L);
		user.setPassword("password");
		user.setUserId(1L);
		user.setUsername("harsimar.kaur");
		
		list = new ArrayList<>();
		list.add(user);
		
	}

	@Test
	public void test() {
		Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
		Mockito.when(payeeRepository.findByUserId(1L)).thenReturn(list);
		ResponseData actualList = transectionService.getAllPayees(1L);
		assertEquals(list, actualList.getData());
	}

}
