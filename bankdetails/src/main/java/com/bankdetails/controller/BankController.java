package com.bankdetails.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankdetails.Models.BankDetails;
import com.bankdetails.Models.BankDetailsDto;
import com.bankdetails.service.BankService;

@RestController
@RequestMapping("/bank")
public class BankController {
	@Autowired
	BankService bankservice;

	@PostMapping("/add")
	public ResponseEntity<BankDetails> addbank(@RequestBody BankDetails bankdetails) {
		BankDetails b = bankservice.add(bankdetails);
		return new ResponseEntity<>(b, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateBankDetails(@RequestBody BankDetails b) {
		String s = bankservice.update(b);
		return new ResponseEntity<String>(s, HttpStatus.ACCEPTED);
	}

	@GetMapping("/viewAllBankDetails")
	public ResponseEntity<List<BankDetails>> getAllBankDetials() {
		List<BankDetails> list = bankservice.viewAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/viewByAccountNumber/{id}")
	public ResponseEntity<BankDetails> detailsByAccountnumber(@PathVariable Long id) {
		BankDetails b = bankservice.getById(id);
		return new ResponseEntity<>(b, HttpStatus.OK);
	}

	@DeleteMapping("/deleteAccount/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
		String s = bankservice.deletebyId(id);
		return new ResponseEntity<String>(s, HttpStatus.OK);
	}
	@PutMapping("/deposit")
	public ResponseEntity<String> credit(@RequestBody BankDetailsDto bank){
 String s=bankservice.deposit(bank);
 return new ResponseEntity<>(s,HttpStatus.ACCEPTED);
	}
	@PutMapping("/withdraw")
	public ResponseEntity<String> debit(@RequestBody BankDetailsDto bank){
 String s=bankservice.debited(bank);
 return new ResponseEntity<>(s,HttpStatus.ACCEPTED);
	}
}
