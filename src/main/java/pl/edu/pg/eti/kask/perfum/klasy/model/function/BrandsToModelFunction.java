package pl.edu.pg.eti.kask.perfum.klasy.model.function;

import pl.edu.pg.eti.kask.perfum.klasy.entity.Brand;
import pl.edu.pg.eti.kask.perfum.klasy.model.BrandModel;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Converts a list of {@link Brand} to a list of {@link BrandModel}.
 */
public class BrandsToModelFunction implements Function<List<Brand>, List<BrandModel>>, Serializable {

    private final BrandToModelFunction brandToModelFunction = new BrandToModelFunction();

    @Override
    public List<BrandModel> apply(List<Brand> brands) {
        return brands.stream()
                .map(brandToModelFunction)
                .collect(Collectors.toList());
    }
}