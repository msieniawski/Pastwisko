package com.pastwisko.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pastwisko.serializer.CopyPastaSerializer;
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
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@JsonSerialize(using = CopyPastaSerializer.class)
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
    @Getter @Setter
    private User author;

    @OneToMany(mappedBy = "pasta", fetch = EAGER)
    @Getter @Setter
    private List<Comment> comments;

    @OneToMany(mappedBy = "pasta", fetch = EAGER)
    @Getter @Setter
    private List<Rating> ratings;

    @ManyToMany(mappedBy = "pastaList", fetch = EAGER)
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

    public void add(Comment comment) {
        this.comments.add(comment);
    }

    public void add(Rating rating) {
        this.ratings.add(rating);
    }

    public void add(Tag tag) {
        this.tags.add(tag);
    }
}
