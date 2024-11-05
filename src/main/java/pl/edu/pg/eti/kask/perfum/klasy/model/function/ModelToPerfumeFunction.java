package pl.edu.pg.eti.kask.perfum.klasy.model.function;

import lombok.SneakyThrows;
import pl.edu.pg.eti.kask.perfum.klasy.entity.Perfume;
import pl.edu.pg.eti.kask.perfum.klasy.entity.Brand;
import pl.edu.pg.eti.kask.perfum.klasy.model.PerfumeCreateModel;

import java.io.Serializable;
import java.util.function.Function;

/**
 * Converts {@link PerfumeCreateModel} to {@link Perfume}.
 */
public class ModelToPerfumeFunction implements Function<PerfumeCreateModel, Perfume>, Serializable {

    @Override
    @SneakyThrows
    public Perfume apply(PerfumeCreateModel model) {
        return Perfume.builder()
                .id(model.getId())
                .name(model.getName())
                .description(model.getDescription())
                .releaseDate(model.getReleaseDate())
                .price(model.getPrice())
                .scentType(Perfume.ScentType.valueOf(model.getScentType()))
                .brand(Brand.builder()
                        .id(model.getBrand().getId())
                        .build())
                .build();
    }
}
