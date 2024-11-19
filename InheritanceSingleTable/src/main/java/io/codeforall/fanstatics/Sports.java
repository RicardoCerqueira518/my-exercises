package io.codeforall.fanstatics;

import javax.persistence.*;

@Entity(name="SportsSingleTable")
@Table(name = "sports_single_table")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "sports_type",
        discriminatorType = DiscriminatorType.STRING
)
public abstract class Sports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer CaloriesBurned;
}

