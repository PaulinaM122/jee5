package pl.edu.pg.eti.kask.perfum.klasy.dto.function;

import pl.edu.pg.eti.kask.perfum.klasy.dto.PatchBrandRequest;
import pl.edu.pg.eti.kask.perfum.klasy.entity.Brand;

import java.util.function.BiFunction;

/**
 * Returns a new instance of {@link Brand} based on the provided value and updated with values from
 * {@link PatchBrandRequest}.
 */
public class UpdateBrandWithRequestFunction implements BiFunction<Brand, PatchBrandRequest, Brand> {

    @Override
    public Brand apply(Brand entity, PatchBrandRequest request) {
        return Brand.builder()
                .id(entity.getId())  // Zachowujemy istniejące ID
                .name(request.getName() != null ? request.getName() : entity.getName())
                .country(request.getCountry() != null ? request.getCountry() : entity.getCountry())
                .description(request.getDescription() != null ? request.getDescription() : entity.getDescription())
                .build();
    }
}