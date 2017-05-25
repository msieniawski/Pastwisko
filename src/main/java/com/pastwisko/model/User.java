package com.pastwisko.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;

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

    @Column(name = "mail")
    @Getter @Setter
    private String mail;

    @JoinTable @OneToMany
    @Getter @Setter
    private List<CopyPasta> pastaList;

    public User(String userName, String password, String mail) {
        this.userName = userName;
        this.password = password;
        this.mail = mail;
    }
}
