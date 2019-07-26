package com.hcl.fundtransfer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Payee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long payeeTrackId;
	
	@ManyToOne
	@JoinColumn(name = "payee_id")
	@JsonIgnore
	private UserDetails payeeId;
	
	private String status;
	
	private int otp;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private UserDetails userId;
}
