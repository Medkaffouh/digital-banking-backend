package com.med.digitalbankingbackend.dtos;

import com.med.digitalbankingbackend.enums.AccountStatus;
import lombok.Data;
import java.util.Date;
@Data
public class SavingBankAccountDTO extends BankAccountDTO{

    private String id;
    private double balance;
    private Date createAt;
    private AccountStatus status;
    private CustomerDTO customerDTO;
    private double interestRate;
}
