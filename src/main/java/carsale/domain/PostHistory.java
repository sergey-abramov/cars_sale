package carsale.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post_history")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PostHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @OneToMany(mappedBy = "history")
    private List<Post> posts = new ArrayList<>();

}
