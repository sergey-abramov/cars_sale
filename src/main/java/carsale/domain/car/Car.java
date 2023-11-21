package carsale.domain.car;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private String name;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
    @ManyToOne
    @JoinColumn(name = "type_car_id")
    private TypeCar typeCar;
    @ManyToOne
    @JoinColumn(name = "type_car_body_id")
    private TypeCarBody body;
    @ManyToOne
    @JoinColumn(name = "type_engine_id")
    private TypeEngine typeEngine;
    @OneToOne(mappedBy = "car")
    private CarDocs carDocs;
}
