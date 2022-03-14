package com.abiha.springdata.hibernateinheritance.repos;

import com.abiha.springdata.hibernateinheritance.entities.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment,Integer> {
}
