package com.med.digitalbankingbackend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.med.digitalbankingbackend.enums.OperationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class AccountOperation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date operationDate;
    private double amount;
    @Enumerated(EnumType.STRING)
    private OperationType type;
    @ManyToOne
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private BankAccount bankAccount;
    private String description;
}
