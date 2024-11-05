package pl.edu.pg.eti.kask.perfum.klasy.model.function;

import pl.edu.pg.eti.kask.perfum.klasy.entity.Perfume;
import pl.edu.pg.eti.kask.perfum.klasy.model.PerfumeEditModel;

import java.io.Serializable;
import java.util.function.Function;

/**
 * Converts {@link Perfume} to {@link PerfumeEditModel}.
 */
public class PerfumeToEditModelFunction implements Function<Perfume, PerfumeEditModel>, Serializable {

    @Override
    public PerfumeEditModel apply(Perfume entity) {
        return PerfumeEditModel.builder()
                .name(entity.getName())
                .description(entity.getDescription())
                .releaseDate(entity.getReleaseDate())
                .price(entity.getPrice())
                .build();
    }
}
