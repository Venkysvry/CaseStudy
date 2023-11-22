package com.bankdetails.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bankdetails.Models.BankDetails;

@Repository
public interface BankRepository  extends MongoRepository<BankDetails, Integer>{

BankDetails findByAccountNumber(Long id);
String deleteByAccountNumber(Long id);


}
