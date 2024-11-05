package pl.edu.pg.eti.kask.perfum.klasy.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

/**
 * GET perfumes response. Contains list of available perfumes.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetPerfumesResponse {

    /**
     * Represents single perfume in list.
     */
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Perfume {

        /**
         * Unique id identifying the perfume.
         */
        private UUID id;

        /**
         * Name of the perfume.
         */
        private String name;
    }

    /**
     * List of available perfumes.
     */
    @Singular
    private List<Perfume> perfumes;

}