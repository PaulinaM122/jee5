package pl.edu.pg.eti.kask.perfum.klasy.dto.function;

import pl.edu.pg.eti.kask.perfum.klasy.dto.GetBrandResponse;
import pl.edu.pg.eti.kask .perfum.klasy.entity.Brand;

import java.util.function.Function;

/**
 * Converts {@link Brand} to {@link GetBrandResponse}.
 */
public class BrandToResponseFunction implements Function<Brand, GetBrandResponse> {

    @Override
    public GetBrandResponse apply(Brand entity) {
        return GetBrandResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

}