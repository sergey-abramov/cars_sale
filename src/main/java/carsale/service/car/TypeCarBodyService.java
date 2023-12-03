package carsale.service.car;

import carsale.domain.car.TypeCarBody;
import carsale.repository.car.TypeCarBodyRep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeCarBodyService {

    private final TypeCarBodyRep repository;

    public List<TypeCarBody> finaAll() {
        return repository.findAll();
    }

    public TypeCarBody findById(TypeCarBody body) {
        return repository.findById(body).orElseThrow();
    }
}
