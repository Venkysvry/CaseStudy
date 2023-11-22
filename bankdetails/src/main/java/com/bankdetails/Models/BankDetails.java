package com.bankdetails.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="bankDetails")
public class BankDetails {
	@Id
	private Long accountNumber;
	private String accountHolderName;
	private String bankName;
	private String branchName;
	private String bankCode;
	private Double balance;
	public BankDetails() {
		
	}
	public BankDetails(Long accountNumber, String accountHolderName, String bankName, String branchName,
			String bankCode, Double balance) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.bankName = bankName;
		this.branchName = branchName;
		this.bankCode = bankCode;
		this.balance = balance;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "BankDetails [accountNumber=" + accountNumber + ", accountHolderName=" + accountHolderName
				+ ", bankName=" + bankName + ", branchName=" + branchName + ", bankCode=" + bankCode + ", balance="
				+ balance + "]";
	}


}
