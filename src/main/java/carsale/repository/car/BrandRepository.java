package carsale.repository.car;

import carsale.domain.car.Brand;
import carsale.repository.CrudStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BrandRepository {

    private final CrudStore store;

    public Optional<Brand> findById(Brand brand) {
        return store.optional("from Brand where id - :tId",
                Brand.class, Map.of("tId", brand.getId()));
    }

    public List<Brand> findAll() {
        return store.query("from Brand", Brand.class);
    }
}
