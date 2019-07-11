package com.hcl.fundtransfer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * FundtransferApplication Service
 * @author amol.jadhav
 */
@SpringBootApplication
@EnableScheduling
public class FundtransferApplication {

	public static void main(String[] args) {
		SpringApplication.run(FundtransferApplication.class, args);
	}

}
