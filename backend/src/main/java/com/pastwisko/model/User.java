package com.pastwisko.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name  = "users")
public class User {

    @Id @GeneratedValue(strategy = AUTO)
    @Column(name = "user_id")
    @Getter @Setter
    private int id;

    @Column(name = "username", columnDefinition = "varchar(50)", nullable = false)
    @Getter @Setter
    private String userName;

    // TU OCZYWIŚCIE POWINNY BYĆ STOROWANE HASZE XD
    @Column(name = "password", columnDefinition = "varchar(256)", nullable = false)
    @JsonIgnore
    @Getter @Setter
    private String password;

    @Column(name = "mail", columnDefinition = "varchar(100)", nullable = false)
    @Getter @Setter
    private String mail;

    @OneToMany(mappedBy = "author", fetch = EAGER)
    @JsonBackReference
    @Getter @Setter
    private List<CopyPasta> pastaList;

    @OneToMany(mappedBy = "author", fetch = EAGER)
    @JsonBackReference
    @Getter @Setter
    private List<Comment> comments;

    @OneToMany(mappedBy = "author", fetch = EAGER)
    @JsonBackReference
    @Getter @Setter
    private List<Rating> ratings;

    public User() {}

    public User(String userName, String password, String mail) {
        this.userName = userName;
        this.password = password;
        this.mail = mail;
    }
}
