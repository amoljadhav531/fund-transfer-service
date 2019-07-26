package com.hcl.fundtransfer.dto;

import lombok.Data;

/**
 * Payee class used as request body model
 * 
 * @author amol.jadhav
 */
@Data
public class PayeeDto {

	private Long payeeId;
	private Long UserId;
}
