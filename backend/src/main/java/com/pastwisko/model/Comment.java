package com.pastwisko.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "comments")
public class Comment {

    @Id @GeneratedValue(strategy = AUTO)
    @Column(name = "comment_id")
    @Getter @Setter
    private int id;

    @Column(name = "text", columnDefinition = "text", nullable = false)
    @Getter @Setter
    private String text;

    @ManyToOne
    @JoinColumn(name = "author", nullable = false)
    @Getter @Setter
    private User author;

    @ManyToOne
    @JoinColumn(name = "pasta", nullable = false)
    @Getter @Setter
    private CopyPasta pasta;

    public Comment() {}

    public Comment(String text, User author, CopyPasta pasta) {
        this.text = text;
        this.author = author;
        this.pasta = pasta;
    }
}
