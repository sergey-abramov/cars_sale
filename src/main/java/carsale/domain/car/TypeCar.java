package carsale.domain.car;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "type_car")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TypeCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private String name;
    @OneToMany(mappedBy = "typeCar")
    private List<TypeCarBody> typeCarBody = new ArrayList<>();
}
