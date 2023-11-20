package carsale.repository.car;

import carsale.domain.car.TypeCar;
import carsale.repository.CrudStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author Abramov Sergey
 */
@Repository
@RequiredArgsConstructor
public class TypeCarRepository {

    private final CrudStore store;

    public Optional<TypeCar> findById(TypeCar typeCar) {
        return store.optional("from TypeCar where id = :tId",
                TypeCar.class, Map.of("tId", typeCar.getId()));
    }

    public List<TypeCar> findAll() {
        return store.query("from TypeCar", TypeCar.class);
    }
}
