package com.pastwisko.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pastwisko.serialization.AuthorDeserializer;
import com.pastwisko.serialization.AuthorSerializer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "comments")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
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
    @JsonSerialize(using = AuthorSerializer.class)
    @JsonDeserialize(using = AuthorDeserializer.class)
    private User author;

    @ManyToOne
    @JoinColumn(name = "pasta", nullable = false)
    @Getter @Setter
    @JsonIgnore
    private CopyPasta pasta;

    public Comment() {}

    public Comment(String text, User author, CopyPasta pasta) {
        this.text = text;
        this.author = author;
        this.pasta = pasta;
    }
}
