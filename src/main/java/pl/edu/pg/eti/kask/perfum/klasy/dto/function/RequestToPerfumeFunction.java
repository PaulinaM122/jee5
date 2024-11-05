package pl.edu.pg.eti.kask.perfum.klasy.dto.function;

import pl.edu.pg.eti.kask.perfum.klasy.dto.PutPerfumeRequest;
import pl.edu.pg.eti.kask.perfum.klasy.entity.Perfume;
import pl.edu.pg.eti.kask.perfum.klasy.entity.Brand;

import java.util.UUID;
import java.util.function.BiFunction;

/**
 * Converts {@link PutPerfumeRequest} to {@link Perfume}. Caution, some fields are not set as they should be updated
 * by business logic.
 */
public class RequestToPerfumeFunction implements BiFunction<UUID, PutPerfumeRequest, Perfume> {

    @Override
    public Perfume apply(UUID id, PutPerfumeRequest request) {
        return Perfume.builder()
                .id(id)
                .name(request.getName())
                .description(request.getDescription())
                .releaseDate(request.getReleaseDate())
                .price(request.getPrice())
                .scentType(Perfume.ScentType.valueOf(request.getScentType()))
                .build();
    }

}

