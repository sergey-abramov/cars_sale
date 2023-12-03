package carsale.domain;

import carsale.domain.car.Car;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    private String description;

    private int price;
    @EqualsAndHashCode.Include
    private LocalDateTime created = LocalDateTime.now();

    private boolean sell;

    @ManyToOne
    @JoinColumn(name = "post_user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_history_id")
    private PostHistory history;

    @OneToMany(mappedBy = "post")
    private List<File> files = new ArrayList<>();
}
