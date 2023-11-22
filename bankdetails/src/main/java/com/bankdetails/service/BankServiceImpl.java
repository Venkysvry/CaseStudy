package com.bankdetails.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankdetails.Models.BankDetails;
import com.bankdetails.Models.BankDetailsDto;
import com.bankdetails.repositories.BankRepository;

@Service
public class BankServiceImpl implements BankService {
	@Autowired
	BankRepository brep;

	@Override
	public BankDetails add(BankDetails bankdetials) {
		brep.save(bankdetials);
		return bankdetials;
	}

	@Override
	public String update(BankDetails bankdetails) {
		brep.save(bankdetails);
		return "updated Successfully";
	}

	@Override
	public List<BankDetails> viewAll() {
		List<BankDetails> list = brep.findAll();
		return list;
	}

	@Override
	public String debited(BankDetailsDto bank) {
		BankDetails b=brep.findByAccountNumber(bank.getAccountNumber());
		Double a=b.getBalance();
		Double a1=bank.getAmount();
		Double a2=a-a1;
		b.setBalance(a2);
		brep.save(b);
		
		return "debited amount of Rs"+a1 ;
	}

	
	@Override
	public String deletebyId(Long id) {
		brep.deleteByAccountNumber(id);
		return "deleted account successfully";
	}

	@Override
	public String deposit(BankDetailsDto bank) {
	BankDetails b=brep.findByAccountNumber(bank.getAccountNumber());
	Double a=b.getBalance();
	Double a1=bank.getAmount();
	Double a2=a+a1;
	b.setBalance(a2);
	brep.save(b);
		return "deposited succesfully"+a1;
	}

	@Override
	public BankDetails getById(Long id) {
		BankDetails b= brep.findByAccountNumber(id);
		return b;
	}

}
