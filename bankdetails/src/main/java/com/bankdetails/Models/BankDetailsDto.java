package com.bankdetails.Models;

public class BankDetailsDto {
	private Long accountNumber;
	private Double amount;

	public BankDetailsDto() {

	}

	public BankDetailsDto(Long accountNumber, Double amount) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "BankDetailsDto [accountNumber=" + accountNumber + ", amount=" + amount + "]";
	}

	
}
