package com.pastwisko.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "pasta")
public class CopyPasta {

    @Id @GeneratedValue(strategy = AUTO)
    @Column(name = "pasta_id")
    @Getter @Setter
    private int id;

    @Column(name = "title")
    @Getter @Setter
    private String title;

    @Column(name = "text")
    @Getter @Setter
    private String text;

    @Column(name = "creation_date")
    @Getter @Setter
    private Date creationDate;

    @JoinTable @OneToMany
    @Getter @Setter
    private List<Tag> tags;

    @JoinTable @OneToMany
    @Getter @Setter
    private List<Comment> comments;

    @JoinTable @OneToMany
    @Getter @Setter
    private List<Rating> ratings;

    @JoinColumn(name = "owner") @ManyToOne
    @Getter @Setter
    private User owner;
}
