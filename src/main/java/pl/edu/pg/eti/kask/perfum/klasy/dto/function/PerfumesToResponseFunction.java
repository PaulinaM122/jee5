package pl.edu.pg.eti.kask.perfum.klasy.dto.function;

import pl.edu.pg.eti.kask.perfum.klasy.dto.GetPerfumesResponse;
import pl.edu.pg.eti.kask.perfum.klasy.entity.Perfume;

import java.util.List;
import java.util.function.Function;

/**
 * Converts {@link List<Perfume>} to {@link GetPerfumesResponse}.
 */
public class PerfumesToResponseFunction implements Function<List<Perfume>, GetPerfumesResponse> {

    @Override
    public GetPerfumesResponse apply(List<Perfume> entities) {
        return GetPerfumesResponse.builder()
                .perfumes(entities.stream()
                        .map(perfume -> GetPerfumesResponse.Perfume.builder()
                                .id(perfume.getId())
                                .name(perfume.getName())
                                .build())
                        .toList())
                .build();
    }

}