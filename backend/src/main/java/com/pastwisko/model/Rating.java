package com.pastwisko.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "rating")
public class Rating {

    @Id @GeneratedValue(strategy = AUTO)
    @Column(name = "rating_id")
    @Getter @Setter
    private int id;

    @JoinColumn @ManyToOne
    @Getter @Setter
    private RatingValue ratingValue;

    @JoinColumn @ManyToOne
    @Getter @Setter
    private User owner;

    @JoinColumn @ManyToOne
    @Getter @Setter
    private CopyPasta pasta;
}
