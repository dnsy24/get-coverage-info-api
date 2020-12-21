package com.example.getcoverageapi.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "durations")
public class Duration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "begin_date")
    private String begin_date;
    @Column(name = "end_date")
    private String end_date;
    @OneToOne(mappedBy = "duration", cascade = CascadeType.ALL)
    private Customer customer;

    public Duration() {
    }

}


