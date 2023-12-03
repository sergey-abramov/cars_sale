package carsale.repository;

import carsale.domain.Post;
import carsale.domain.PostHistory;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostHistoryRepository {

    private final CrudStore store;

    public Optional<PostHistory> findById(int id) {
        return store.optional("from PostHistory where id = :pId",
                PostHistory.class, Map.of("pId", id));
    }
}
