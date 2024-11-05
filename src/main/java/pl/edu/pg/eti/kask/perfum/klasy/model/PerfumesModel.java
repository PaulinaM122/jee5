package pl.edu.pg.eti.kask.perfum.klasy.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * JSF view model class in order to not use entity classes. Represents list of perfumes to be displayed.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PerfumesModel implements Serializable {

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
         * Unique id identifying perfume.
         */
        private UUID id;

        /**
         * Name of the perfume.
         */
        private String name;

    }

    /**
     * List of perfumes.
     */
    @Singular
    private List<Perfume> perfumes;

}
