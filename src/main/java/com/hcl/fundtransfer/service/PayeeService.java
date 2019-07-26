package com.hcl.fundtransfer.service;


import com.hcl.fundtransfer.dto.PayeeDto;
import com.hcl.fundtransfer.dto.ResponseData;

public interface PayeeService {

	ResponseData deletePayee(PayeeDto payeeDto);

	

}
