package com.pastwisko.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "ratings")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Rating {

    @Id @GeneratedValue(strategy = AUTO)
    @Column(name = "rating_id")
    @Getter @Setter
    private int id;

    @Column(name = "value", nullable = false)
    @Getter @Setter
    private int value;

    @ManyToOne
    @JoinColumn(name = "author", nullable = false)
    @Getter @Setter
    private User author;

    @ManyToOne
    @JoinColumn(name = "pasta", nullable = false)
    @Getter @Setter
    @JsonIgnore
    private CopyPasta pasta;

    public Rating() {}

    public Rating(int value, User author, CopyPasta pasta) {
        this.value = value;
        this.author = author;
        this.pasta = pasta;
    }
}
