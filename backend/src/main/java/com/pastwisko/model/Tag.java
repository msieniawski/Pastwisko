package com.pastwisko.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "tags")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Tag {

    @Id @GeneratedValue(strategy = AUTO)
    @Column(name = "tag_id")
    @Getter @Setter
    private int id;

    @Column(name = "name")
    @Getter @Setter
    private String name;

    @ManyToMany(fetch = EAGER)
    @JoinTable
    @Getter @Setter
    @JsonIgnore
    private List<CopyPasta> pastaList;

    public Tag() {
        this.pastaList = new ArrayList<>();
    }

    public Tag(String name) {
        this.name = name;
        this.pastaList = new ArrayList<>();
    }

    public Tag(String name, List<CopyPasta> pastaList) {
        this.name = name;
        this.pastaList = pastaList;
        this.pastaList = new ArrayList<>();
    }
}
