package com.example.getcoverageapi.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "durations_id")
    private Duration duration;
    @Column(name = "additional_coverage")
    private String additional_coverage;

    public Customer() {
    }

    public Customer(String name, String lastname, String provider, int amount, String additional_coverage, Duration duration) {
        this.name = name;
        this.lastname = lastname;
        this.provider = provider;
        this.amount = amount;
        this.additional_coverage = additional_coverage;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", provider='" + provider + '\'' +
                ", amount=" + amount +
                ", duration=" + duration +
                ", additional_coverage='" + additional_coverage + '\'' +
                '}';
    }
}
