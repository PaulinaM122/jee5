package pl.edu.pg.eti.kask.perfum.klasy.model.function;

import pl.edu.pg.eti.kask.perfum.klasy.entity.Brand;
import pl.edu.pg.eti.kask.perfum.klasy.model.BrandModel;

import java.io.Serializable;
import java.util.function.Function;

/**
 * Converts {@link Brand} to {@link BrandModel}.
 */
public class BrandToModelFunction implements Function<Brand, BrandModel>, Serializable {

    @Override
    public BrandModel apply(Brand entity) {
        return BrandModel.builder()
                .id(entity.getId())
                .name(entity.getName())
                .country(entity.getCountry())
                .description(entity.getDescription())
                .build();
    }
}
