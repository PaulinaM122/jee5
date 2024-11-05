package pl.edu.pg.eti.kask.perfum.klasy.model.function;

import pl.edu.pg.eti.kask.perfum.klasy.entity.Perfume;
import pl.edu.pg.eti.kask.perfum.klasy.model.PerfumeModel;

import java.io.Serializable;
import java.util.function.Function;

/**
 * Converts {@link Perfume} to {@link PerfumeModel}.
 */
public class PerfumeToModelFunction implements Function<Perfume, PerfumeModel>, Serializable {

    @Override
    public PerfumeModel apply(Perfume entity) {
        return PerfumeModel.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .releaseDate(entity.getReleaseDate())
                .price(entity.getPrice())
                .scentType(entity.getScentType().name())
                .brand(entity.getBrand().getName())
                .build();
    }
}
