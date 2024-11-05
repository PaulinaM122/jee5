package pl.edu.pg.eti.kask.perfum.klasy.dto;

import jakarta.json.bind.annotation.JsonbDateFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

/**
 * GET perfume response. Contains all fields that can be presented (but not necessarily changed) to the user.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetPerfumeResponse {

    /**
     * Represents the brand of the perfume.
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
     * Unique id identifying the perfume.
     */
    private UUID id;

    /**
     * Name of the perfume.
     */
    private String name;

    /**
     * Description of the perfume.
     */
    private String description;

    /**
     * Release date of the perfume.
     */
    @JsonbDateFormat("EEE MMM dd HH:mm:ss zzz yyyy")
    private Date releaseDate;

    /**
     * Price of the perfume.
     */
    private Double price;

    /**
     * Type of the scent.
     */
    private String scentType;

    /**
     * Brand of the perfume.
     */
    private Brand brand;
}


