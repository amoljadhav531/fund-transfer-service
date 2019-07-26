package com.hcl.fundtransfer.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * FundTransfer class used as request body model
 * 
 * @author amol.jadhav
 */
@Data
public class FundTransferDto {

	@NotNull
	private long userId;

	@NotNull
	private long payeeId;

	@NotNull
	private double amount;

}
