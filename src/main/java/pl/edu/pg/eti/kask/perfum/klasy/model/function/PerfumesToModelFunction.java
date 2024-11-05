package pl.edu.pg.eti.kask.perfum.klasy.model.function;

import pl.edu.pg.eti.kask.perfum.klasy.entity.Perfume;
import pl.edu.pg.eti.kask.perfum.klasy.model.PerfumesModel;

import java.util.List;
import java.util.function.Function;

/**
 * Converts {@link List<Perfume>} to {@link PerfumesModel}.
 */
public class PerfumesToModelFunction implements Function<List<Perfume>, PerfumesModel> {

    @Override
    public PerfumesModel apply(List<Perfume> entity) {
        return PerfumesModel.builder()
                .perfumes(entity.stream()
                        .map(perfume -> PerfumesModel.Perfume.builder()
                                .id(perfume.getId())
                                .name(perfume.getName())
                                .build())
                        .toList())
                .build();
    }
}
