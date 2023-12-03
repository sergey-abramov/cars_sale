package carsale.dto;

import carsale.domain.car.TypeCarBody;
import carsale.domain.car.TypeEngine;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PostCreateDto {

    private List<TypeCarBody> bodies;

    private List<TypeEngine> engines;
}
