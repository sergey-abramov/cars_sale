package carsale.service;

import carsale.domain.Post;
import carsale.dto.PostCreateDto;
import carsale.repository.PostRepository;
import carsale.service.car.TypeCarBodyService;
import carsale.service.car.TypeEngineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final TypeCarBodyService typeCarBodyService;
    private final TypeEngineService typeEngineService;

    private final PostRepository repository;

    public void save(Post post) {

    }

    public List<Post> findAll() {
        return repository.findAll();
    }

    public List<Post> findAllByCarType(String typeName) {
        return repository.findAllByType(typeName);
    }

    public List<Post> findAllByCarTypeBody(String bodyName) {
        return repository.findAllByBody(bodyName);
    }

    public List<Post> findAllByCarBrand(String brand) {
        return repository.findAllByBrand(brand);
    }

    public Post findById(int id) {
        return repository.findById(id).orElseThrow();
    }

    public PostCreateDto getPostCreateDto() {
        return new PostCreateDto(
                typeCarBodyService.finaAll(),
                typeEngineService.findAll()
                );
    }

}
