package com.example.lab12;

import jakarta.persistence.*;

@Entity
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String phone;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
