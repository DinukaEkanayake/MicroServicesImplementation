package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder //this help to build object in an easy way using design pattern builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Customer")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String Fname;
    private String Lname;
    @Column(nullable = false,length = 64)
    private String Password;


    @Enumerated(EnumType.STRING)
    private Role role;

}
