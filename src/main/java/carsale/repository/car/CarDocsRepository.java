package carsale.repository.car;

import carsale.domain.car.CarDocs;
import carsale.repository.CrudStore;
import lombok.RequiredArgsConstructor;
import org.hibernate.PersistentObjectException;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CarDocsRepository {

    private final CrudStore store;

    public CarDocs save(CarDocs carDocs) {
        try {
            store.run(session -> session.persist(carDocs));
            return carDocs;
        } catch (PersistentObjectException e) {
            return null;
        }
    }

    public boolean update(CarDocs carDocs) {
        var carDocsBefore = findById(carDocs);
        if (carDocsBefore.isEmpty()) {
            throw new NullPointerException();
        }
        return store.booleanRun(session -> carDocsBefore.get().equals(session.merge(carDocs)));
    }

    public Optional<CarDocs> findById(CarDocs carDocs) {
        return store.optional("from CarDocs where id = :cId",
                CarDocs.class, Map.of("cId", carDocs.getId()));
    }

    public boolean delete(CarDocs carDocs) {
        return store.booleanRun("delete from CarDocs where id = :cId",
                Map.of("cId", carDocs.getId()));
    }
}
