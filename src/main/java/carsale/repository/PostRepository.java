package carsale.repository;

import carsale.domain.Post;
import lombok.RequiredArgsConstructor;
import org.hibernate.PersistentObjectException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostRepository {

    private final CrudStore store;

    public Post save(Post post) {
        try {
            store.run(session -> session.persist(post));
            return post;
        } catch (PersistentObjectException e) {
            return null;
        }
    }

    public Optional<Post> findById(Post post) {
        return store.optional("from Post where id = :pId",
                Post.class, Map.of("pId", post.getId()));
    }

    public List<Post> findAll() {
        return store.query("from Post", Post.class);
    }

    public boolean update(Post post) {
        var postBefore = findById(post);
        if (postBefore.isEmpty()) {
            throw new NullPointerException("Couldn't find the advert for sale");
        }
        return store.booleanRun(session -> postBefore.get().equals(session.merge(post)));
    }

    public boolean delete(Post post) {
        return store.booleanRun("delete from Post where id = :pId", Map.of("pId", post.getId()));
    }
}
