package carsale.repository;

import carsale.domain.File;
import lombok.RequiredArgsConstructor;
import org.hibernate.PersistentObjectException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FileRepository {

    private final CrudStore store;

    public File save(File file) {
        try {
            store.run(session -> session.persist(file));
            return file;
        } catch (PersistentObjectException e) {
            return null;
        }
    }

    public Optional<File> findById(File file) {
        return store.optional("form File where id = :fId", File.class, Map.of("fId", file.getId()));
    }
}
