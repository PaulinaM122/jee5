package pl.edu.pg.eti.kask.perfum.klasy.dto.function;

import pl.edu.pg.eti.kask.perfum.klasy.dto.PutBrandRequest;
import pl.edu.pg.eti.kask.perfum.klasy.entity.Brand;

import java.util.UUID;
import java.util.function.BiFunction;

/**
 * Converts {@link PutBrandRequest} to {@link Brand}. Sets the basic fields for creating a new brand.
 */
public class RequestToBrandFunction implements BiFunction<UUID, PutBrandRequest, Brand> {

    @Override
    public Brand apply(UUID id, PutBrandRequest request) {
        return Brand.builder()
                .id(id)
                .name(request.getName())
                .description(request.getDescription())
                .country(request.getCountry())
                .build();
    }

}