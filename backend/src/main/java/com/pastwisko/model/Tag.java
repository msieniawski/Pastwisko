package com.pastwisko.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "tag")
public class Tag {

    @Id @GeneratedValue(strategy = AUTO)
    @Column(name = "tag_id")
    @Getter @Setter
    private int id;

    @Column(name = "name")
    @Getter @Setter
    private String name;

    @JoinTable @OneToMany
    @Getter @Setter
    private List<CopyPasta> pastaList;
}
