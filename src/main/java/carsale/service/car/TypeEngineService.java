package carsale.service.car;

import carsale.domain.car.TypeEngine;
import carsale.repository.car.TypeEngineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope(value = "prototype")
@RequiredArgsConstructor
public class TypeEngineService {

    private final TypeEngineRepository repository;

    public List<TypeEngine> findAll() {
        return repository.findAll();
    }
}
