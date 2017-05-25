package com.pastwisko.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name  = "user")
public class User {

    @Id @GeneratedValue(strategy = AUTO)
    @Column(name = "user_id")
    @Getter @Setter
    private int id;

    @Column(name = "username")
    @Getter @Setter
    private String userName;

    @Column(name = "password")
    @Getter @Setter
    private String password;
}
