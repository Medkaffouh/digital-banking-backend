package com.med.digitalbankingbackend.repositories;

import com.med.digitalbankingbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
