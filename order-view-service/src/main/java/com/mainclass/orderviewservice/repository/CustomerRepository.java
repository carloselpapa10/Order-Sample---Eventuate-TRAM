package com.mainclass.orderviewservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mainclass.orderviewservice.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,String>{

}
