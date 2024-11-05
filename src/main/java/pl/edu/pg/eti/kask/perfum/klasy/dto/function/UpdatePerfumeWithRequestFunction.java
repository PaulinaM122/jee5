package pl.edu.pg.eti.kask.perfum.klasy.dto.function;

import pl.edu.pg.eti.kask.perfum.klasy.dto.PatchPerfumeRequest;
import pl.edu.pg.eti.kask.perfum.klasy.entity.Perfume;

import java.util.function.BiFunction;

/**
 * Returns a new instance of {@link Perfume} based on the provided value and updated with values from
 * {@link PatchPerfumeRequest}.
 */
public class UpdatePerfumeWithRequestFunction implements BiFunction<Perfume, PatchPerfumeRequest, Perfume> {

    @Override
    public Perfume apply(Perfume entity, PatchPerfumeRequest request) {
        return Perfume.builder()
                .id(entity.getId())  // Retain existing ID
                .name(request.getName() != null ? request.getName() : entity.getName())
                .description(request.getDescription() != null ? request.getDescription() : entity.getDescription())
                .releaseDate(request.getReleaseDate() != null ? request.getReleaseDate() : entity.getReleaseDate())
                .price(request.getPrice() != null ? request.getPrice() : entity.getPrice())
                .scentType(request.getScentType() != null ? Perfume.ScentType.valueOf(request.getScentType()) : entity.getScentType())
                .brand(entity.getBrand())
                .build();
    }
}