package com.hcl.fundtransfer.service;

import com.hcl.fundtransfer.dto.ResponseData;

public interface ValidateService {
	
	public ResponseData validate(int otp, long payeeTrackingId);

}
