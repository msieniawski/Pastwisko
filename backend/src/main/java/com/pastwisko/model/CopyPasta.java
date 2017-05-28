package com.pastwisko.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "copypastas")
public class CopyPasta {

    @Id @GeneratedValue(strategy = AUTO)
    @Column(name = "pasta_id")
    @Getter @Setter
    private int id;

    @Column(name = "title", columnDefinition = "varchar(50)", nullable = false)
    @Getter @Setter
    private String title;

    @Column(name = "text", columnDefinition = "text", nullable = false)
    @Getter @Setter
    private String text;

    @Column(name = "creation_Date", columnDefinition = "date", nullable = false)
    @Getter @Setter
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "author", nullable = false)
    @JsonManagedReference
    @Getter @Setter
    private User author;

    @OneToMany(mappedBy = "pasta", fetch = EAGER)
    @JsonManagedReference
    @Getter @Setter
    private List<Comment> comments;

    @OneToMany(mappedBy = "pasta", fetch = EAGER)
    @JsonManagedReference
    @Getter @Setter
    private List<Rating> ratings;

    @ManyToMany(mappedBy = "pastaList", fetch = EAGER)
    @JsonManagedReference
    @Getter @Setter
    private List<Tag> tags;

    public CopyPasta() {
        this.tags = new ArrayList<>();
    }

    public CopyPasta(String title, String text, Date creationDate, User author) {
        this.title = title;
        this.text = text;
        this.creationDate = creationDate;
        this.author = author;
        this.tags = new ArrayList<>();
    }
}
