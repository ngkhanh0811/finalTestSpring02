package com.example.finaltestspring.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="salary")
    private BigDecimal salary;
}
