package com.bankdetails.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.bankdetails.Models.BankDetails;
import com.bankdetails.Models.BankDetailsDto;

@Service
public interface BankService {
	public BankDetails add(BankDetails bankdetiails);

	public String update(BankDetails bankdetails);

	public List<BankDetails> viewAll();

	public BankDetails getById(Long id);

	public String deletebyId(Long id);

	public String deposit(BankDetailsDto bank);

	public String debited(BankDetailsDto bank);
}
