package carsale.repository;

import carsale.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final CrudStore store;

    public User save(User user) {
        store.run(session -> session.persist(user));
        return user;
    }

    public Optional<User> findByLogin(String login) {
        return store.optional("from User where username = :uLogin",
                User.class, Map.of("uLogin", login));
    }
}
