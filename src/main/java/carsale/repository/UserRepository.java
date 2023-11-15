package carsale.repository;

import carsale.domain.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.PersistentObjectException;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final CrudStore store;

    public User save(User user) {
        try {
            store.run(session -> session.persist(user));
            return user;
        } catch (PersistentObjectException e) {
            return null;
        }
    }

    public Optional<User> findByLogin(String login) {
        return store.optional("from User where login = :uLogin",
                User.class,
                Map.of(
                        "uLogin", login));
    }
}
