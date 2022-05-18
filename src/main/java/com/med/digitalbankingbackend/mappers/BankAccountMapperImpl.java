package com.med.digitalbankingbackend.mappers;

import com.med.digitalbankingbackend.dtos.CurrentBankAccountDTO;
import com.med.digitalbankingbackend.dtos.CustomerDTO;
import com.med.digitalbankingbackend.dtos.SavingBankAccountDTO;
import com.med.digitalbankingbackend.entities.CurrentAccount;
import com.med.digitalbankingbackend.entities.Customer;
import com.med.digitalbankingbackend.entities.SavingAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
// ce code là finalement en cherchra des framework qui permet de le générer parceque ca c'est de code technique
// vous pouvez utiliser des framework comme (MapStruct)
// MapStruct vous permet de crée que les interface vous declarer just la signature de la methode
// et apré MapStruct qui va générer le code
// avec quelque annotation on peux faire ce travail
@Service
public class BankAccountMapperImpl {
    public CustomerDTO fromCustomer(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        // d'une maniere dynamique
        BeanUtils.copyProperties(customer,customerDTO);
        // d'une maniere static
        //customerDTO.setId(customer.getId());
        //customerDTO.setName(customer.getName());
        //customerDTO.setEmail(customer.getEmail());

        //en va combener entre la methode dynamique et static parc que BeanUtils transfer les données main quant il y'a des list
        //en va utiliser des getters setters (la methode static)
        return customerDTO;
    }
    public Customer fromCustomerDTO(CustomerDTO customerDTO){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
        return customer;
    }

    public SavingBankAccountDTO fromSavingBankAccount(SavingAccount savingAccount){
        SavingBankAccountDTO savingBankAccountDTO=new SavingBankAccountDTO();
        BeanUtils.copyProperties(savingAccount,savingBankAccountDTO);
        savingBankAccountDTO.setCustomerDTO(fromCustomer(savingAccount.getCustomer()));
        return savingBankAccountDTO;
    }

    public SavingAccount fromSavingBankAccountDTO(SavingBankAccountDTO savingBankAccountDTO){
        SavingAccount savingAccount = new SavingAccount();
        BeanUtils.copyProperties(savingBankAccountDTO,savingAccount);
        savingAccount.setCustomer(fromCustomerDTO(savingBankAccountDTO.getCustomerDTO()));
        return savingAccount;
    }

    public CurrentBankAccountDTO fromCurrentBankAccount(CurrentAccount currentAccount){
        CurrentBankAccountDTO currentBankAccountDTO = new CurrentBankAccountDTO();
        BeanUtils.copyProperties(currentAccount,currentBankAccountDTO);
        currentBankAccountDTO.setCustomerDTO(fromCustomer(currentAccount.getCustomer()));
        return currentBankAccountDTO;
    }

    public CurrentAccount fromCurrentBankAccountDTO(CurrentBankAccountDTO currentBankAccountDTO){
        CurrentAccount currentAccount = new CurrentAccount();
        BeanUtils.copyProperties(currentBankAccountDTO,currentAccount);
        currentAccount.setCustomer(fromCustomerDTO(currentBankAccountDTO.getCustomerDTO()));
        return currentAccount;
    }
}
