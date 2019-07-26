package com.hcl.fundtransfer.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import com.hcl.fundtransfer.entity.Payee;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OtpSenderUtility {

	
	@Autowired
	private JavaMailSender sender;
	
	private static final String ACCOUNT_SID = "ACf73ecdd409fbbd7f4662253cd08f9e0b";
	private static final String AUTH_ID = "d099b8077232a16999136f93f243e697";

	static {
		Twilio.init(ACCOUNT_SID, AUTH_ID);
	}
	
	
	public void sendNotification(Payee payee) {
		
		String msg = "Your OTP for beneficiary is :  " + payee.getOtp();
		try {

			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);

			helper.setTo(payee.getUserId().getEmail());
			helper.setText(msg);
			helper.setSubject("Bank OTP Notification");
			sender.send(message);

		} catch (Exception e) {
			log.error("Error: "+ e);
		}
		
		Message.creator(new PhoneNumber("+91" + payee.getUserId().getMobileNumber()), new PhoneNumber("+12028757297"), msg).create();
	}
}
