package com.hcl.fundtransfer.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TransactionDetails class represent the transaction_details table in database
 * @author amol.jadhav
 */
@Entity
@Table(name= "transaction_details")
public class TransactionDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sr_no")
	private int srNo;
	
	private String date;
	
	@Column(name="account_number")
	private long accountNumber;
	
	private String opration;
	
	@Column(name="credited_dabited_amount")
	private double creditedDabitedAmount;
	
	private double balance;
	
	private String remark;
	
	private String username;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getOpration() {
		return opration;
	}
	public void setOpration(String opration) {
		this.opration = opration;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getCreditedDabitedAmount() {
		return creditedDabitedAmount;
	}
	public void setCreditedDabitedAmount(double creditedDabitedAmount) {
		this.creditedDabitedAmount = creditedDabitedAmount;
	}
	
	
}
