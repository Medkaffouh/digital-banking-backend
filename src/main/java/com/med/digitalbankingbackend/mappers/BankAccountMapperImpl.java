package com.med.digitalbankingbackend.mappers;

import com.med.digitalbankingbackend.dtos.CustomerDTO;
import com.med.digitalbankingbackend.entities.Customer;
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
}
