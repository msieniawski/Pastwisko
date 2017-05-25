package com.pastwisko.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name  = "comment")
public class Comment {

    @Id @GeneratedValue(strategy = AUTO)
    @Column(name = "comment_id")
    @Getter @Setter
    private int id;

    @Column(name = "text")
    @Getter @Setter
    private String text;

    @JoinColumn(name = "owner") @ManyToOne
    @Getter @Setter
    private User owner;

    @JoinColumn(name = "pasta") @ManyToOne
    @Getter @Setter
    private CopyPasta pasta;
}
