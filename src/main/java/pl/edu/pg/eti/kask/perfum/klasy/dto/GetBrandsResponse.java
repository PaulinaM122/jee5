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
 * GET brands response. Contains list of available brands.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetBrandsResponse {

    /**
     * Represents single brand in list.
     */
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Brand {

        /**
         * Unique id identifying the brand.
         */
        private UUID id;

        /**
         * Name of the brand.
         */
        private String name;

    }

    /**
     * List of available brands.
     */
    @Singular
    private List<Brand> brands;
}