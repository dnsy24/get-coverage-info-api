package com.example.getcoverageapi.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "provider")
    private String provider;
    @Column(name = "amount")
    private int amount;
    @Column(name = "additional_coverage")
    private String additional_coverage;

    @OneToOne
    @JoinColumn(name = "id")
    private Duration duration;

    public Customer() {
    }

}
