package com.med.digitalbankingbackend.web;

import com.med.digitalbankingbackend.entities.Customer;
import com.med.digitalbankingbackend.services.BankAccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class CustomerRestController {
    private BankAccountService bankAccountService;
    @GetMapping("/customers")
    public List<Customer> customers(){
        return bankAccountService.listCustomer();
    }
}
