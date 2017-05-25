package com.pastwisko.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rating_value")
public enum RatingValue {

    ONE(1, "mode banuj"),
    TWO(2, "bezbek"),
    THREE(3, "prychnięte"),
    FOUR(4, "zapluty monitor"),
    FIVE(5, "SZCZERE ZŁOTO");

    RatingValue(int starNumber, String description) {
        this.starNumber = starNumber;
        this.description = description;
    }

    @Id @Column(name = "star_number")
    @Getter @Setter
    private int starNumber;

    @Column(name = "description")
    @Getter @Setter
    private String description;
}
