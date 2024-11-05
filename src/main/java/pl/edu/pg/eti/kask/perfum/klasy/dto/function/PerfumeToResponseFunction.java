package pl.edu.pg.eti.kask.perfum.klasy.dto.function;

import pl.edu.pg.eti.kask.perfum.klasy.dto.GetPerfumeResponse;
import pl.edu.pg.eti.kask.perfum.klasy.entity.Perfume;

import java.util.function.Function;

/**
 * Converts {@link Perfume} to {@link GetPerfumeResponse}.
 */
public class PerfumeToResponseFunction implements Function<Perfume, GetPerfumeResponse> {

    @Override
    public GetPerfumeResponse apply(Perfume entity) {
        return GetPerfumeResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .releaseDate(entity.getReleaseDate())
                .price(entity.getPrice())
                .scentType(String.valueOf(entity.getScentType()))
                .brand(GetPerfumeResponse.Brand.builder()
                        .id(entity.getBrand().getId())
                        .name(entity.getBrand().getName())
                        .build())
                .build();
    }

}

