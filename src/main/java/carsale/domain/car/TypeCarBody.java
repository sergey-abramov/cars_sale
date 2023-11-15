package carsale.domain.car;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@Table(name = "type_car_body")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TypeCarBody {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private String name;
    @ManyToOne
    @JoinColumn(name = "type_car_id")
    private TypeCar typeCar;
}
