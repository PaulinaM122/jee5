package pl.edu.pg.eti.kask.perfum.klasy.model.function;

import pl.edu.pg.eti.kask.perfum.klasy.entity.Brand;
import pl.edu.pg.eti.kask.perfum.klasy.model.BrandEditModel;

import java.io.Serializable;
import java.util.function.BiFunction;

/**
 * Updates a {@link Brand} entity with data from {@link BrandEditModel}.
 */
public class UpdateBrandWithModelFunction implements BiFunction<Brand, BrandEditModel, Brand>, Serializable {

    @Override
    public Brand apply(Brand brand, BrandEditModel model) {
        brand.setName(model.getName());
        brand.setCountry(model.getCountry());
        brand.setDescription(model.getDescription());
        return brand;
    }
}