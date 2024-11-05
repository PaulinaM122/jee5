package pl.edu.pg.eti.kask.perfum.klasy.model.function;

import pl.edu.pg.eti.kask.perfum.klasy.entity.Brand;
import pl.edu.pg.eti.kask.perfum.klasy.model.BrandEditModel;

import java.io.Serializable;
import java.util.function.Function;

/**
 * Converts {@link Brand} to {@link BrandEditModel}.
 */
public class BrandToEditModelFunction implements Function<Brand, BrandEditModel>, Serializable {

    @Override
    public BrandEditModel apply(Brand entity) {
        return BrandEditModel.builder()
                .name(entity.getName())
                .country(entity.getCountry())
                .description(entity.getDescription())
                .build();
    }
}