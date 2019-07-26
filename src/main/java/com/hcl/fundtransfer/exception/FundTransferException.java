package com.hcl.fundtransfer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)	
public class FundTransferException extends Exception {

	private static final long serialVersionUID = -7000578025975626294L;

	public FundTransferException(Throwable t, String msg) {
		super(msg, t);
	}

	public FundTransferException(Throwable t) {
		super(t);
	}

	public FundTransferException(String msg) {
		super(msg);
	}

}
