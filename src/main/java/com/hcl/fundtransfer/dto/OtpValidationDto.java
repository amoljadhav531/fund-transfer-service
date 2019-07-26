package com.hcl.fundtransfer.dto;

import lombok.Data;

@Data
public class OtpValidationDto {

	private int otp;
	private long payeeTrackId;
}
