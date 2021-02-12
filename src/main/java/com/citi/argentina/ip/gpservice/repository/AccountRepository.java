package com.citi.argentina.ip.gpservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.citi.argentina.ip.gpservice.model.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

	Optional<Account> findByAcctId(String acctId);
}
