package carsale.repository.car;

import carsale.domain.car.Car;
import carsale.repository.CrudStore;
import lombok.RequiredArgsConstructor;
import org.hibernate.PersistentObjectException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CarRepository {

    private final CrudStore store;

    public Car save(Car car) {
        try {
            store.run(session -> session.persist(car));
            return car;
        } catch (PersistentObjectException e) {
            return null;
        }
    }

    public Optional<Car> findById(Car car) {
        return store.optional("from Car where id = :cId", Car.class, Map.of("cId", car.getId()));
    }

    public List<Car> findAll() {
        return store.query("from Car", Car.class);
    }

    public boolean update(Car car) {
        var carBefore = findById(car);
        if (carBefore.isEmpty()) {
            throw new NullPointerException("Couldn't find the car");
        }
        return store.booleanRun(session -> carBefore.get().equals(session.merge(car)));
    }

    public boolean delete(Car car) {
        return store.booleanRun("delete from Car where id :cId", Map.of("cId", car.getId()));
    }
}
