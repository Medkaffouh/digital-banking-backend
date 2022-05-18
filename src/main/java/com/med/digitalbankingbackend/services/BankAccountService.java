package com.med.digitalbankingbackend.services;

import com.med.digitalbankingbackend.dtos.CustomerDTO;
import com.med.digitalbankingbackend.entities.BankAccount;
import com.med.digitalbankingbackend.entities.CurrentAccount;
import com.med.digitalbankingbackend.entities.Customer;
import com.med.digitalbankingbackend.entities.SavingAccount;
import com.med.digitalbankingbackend.exceptions.BalanceNotSufficientException;
import com.med.digitalbankingbackend.exceptions.BankAccountNotFoundException;
import com.med.digitalbankingbackend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CurrentAccount saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
    SavingAccount saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;
    List<CustomerDTO> listCustomer();
    BankAccount getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;
    void transfer(String accountIdSource, String accountIdDestination, double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;

    List<BankAccount> bankAccountList();

    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);
}
