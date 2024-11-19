package io.codeforall.fanstatics;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "Tennis_table_per_class")
public class Tennis extends Sports {
    private Integer racket;

    public Integer getRacket() {
        return racket;
    }

    public void setRacket(Integer racket) {
        this.racket = racket;
    }
}
