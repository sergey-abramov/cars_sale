package carsale.repository.car;

import carsale.domain.car.TypeEngine;
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
public class TypeEngineRepository {

    private final CrudStore store;

    public Optional<TypeEngine> findById(TypeEngine typeEngine) {
        return store.optional("from TypeEngine where id = :tId",
                TypeEngine.class, Map.of("tId", typeEngine.getId()));
    }

    public List<TypeEngine> findAll() {
        return store.query("from TypeEngine", TypeEngine.class);
    }
}
