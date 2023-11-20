package carsale.repository.car;

import carsale.domain.car.Owner;
import carsale.repository.CrudStore;
import lombok.RequiredArgsConstructor;
import org.hibernate.PersistentObjectException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OwnerRepository {

    private final CrudStore store;

    public Owner save(Owner owner) {
        try {
            store.run(session -> session.persist(owner));
            return owner;
        } catch (PersistentObjectException e) {
            return null;
        }
    }

    public Optional<Owner> findById(Owner owner) {
        return store.optional("from Owner where id = :oId",
                Owner.class, Map.of("oId", owner.getId()));
    }

    public boolean update(Owner owner) {
        var ownerBefore = findById(owner);
        if (ownerBefore.isEmpty()) {
            throw new NullPointerException("Could not find owner");
        }
        return store.booleanRun(session -> ownerBefore.get().equals(session.merge(owner)));
    }

    public List<Owner> findAll() {
        return store.query("from Owner", Owner.class);
    }

    public boolean delete(Owner owner) {
        return store.booleanRun("delete from Owner where id = :oId", Map.of("oId", owner.getId()));
    }
}
