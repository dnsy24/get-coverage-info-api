package com.example.getcoverageapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "durations")
public class Duration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private long id;
    @Column(name = "begin_date")
    private String begin_date;
    @Column(name = "end_date")
    private String end_date;

    public Duration() {
    }

    public Duration(String begin_date, String end_date) {
        this.begin_date = begin_date;
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "Duration{" +
                "begin_date='" + begin_date + '\'' +
                ", end_date='" + end_date + '\'' +
                '}';
    }
}


