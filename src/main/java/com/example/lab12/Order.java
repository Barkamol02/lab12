package com.example.lab12;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Customer customer;
    private Date orderDate;
    private Double total;
    private String status;

}