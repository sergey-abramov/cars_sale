package carsale.repository.car;

import carsale.domain.car.TypeCarBody;
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
public class TypeCarBodyRep {

    private final CrudStore store;

    public Optional<TypeCarBody> findById(TypeCarBody carBody) {
        return store.optional("from TypeCarBody where id = :tId",
                TypeCarBody.class, Map.of("tId", carBody.getId()));
    }

    public List<TypeCarBody> findAll() {
        return store.query("from TypeCarBody", TypeCarBody.class);
    }
}
