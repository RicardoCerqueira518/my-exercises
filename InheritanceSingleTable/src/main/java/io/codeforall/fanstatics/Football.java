package io.codeforall.fanstatics;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "FootballSingleTable")
@DiscriminatorValue("football")
public class Football extends Sports {
    private Integer balls;

    public Integer getBalls() {
        return balls;
    }

    public void setBalls(Integer balls) {
        this.balls = balls;
    }
}
