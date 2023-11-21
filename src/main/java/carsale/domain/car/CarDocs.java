package carsale.domain.car;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "car_docs")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CarDocs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private String series;

    private Long number;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
}
