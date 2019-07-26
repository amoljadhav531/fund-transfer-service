
package com.hcl.fundtransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.fundtransfer.dto.OtpValidationDto;
import com.hcl.fundtransfer.dto.ResponseData;
import com.hcl.fundtransfer.service.ValidateService;

import lombok.extern.slf4j.Slf4j;

@Slf4j

@RestController

@RequestMapping("/payee")

@CrossOrigin
public class OtpValidationController {

	@Autowired
	private ValidateService validateServiceImpl;

	@PostMapping("/confirm")
	public ResponseEntity<Object> validate(OtpValidationDto otpValidationDto) {
		log.debug("entering into validate method============>>>>>>>>>>>");
		ResponseData response = validateServiceImpl.validate(otpValidationDto.getOtp(),
				otpValidationDto.getPayeeTrackId());
		log.debug("existing  from validate============>>>>>>>>>>>");
		return new ResponseEntity<>(response, response.getHttpStatus());
	}
}
