package pl.edu.pg.eti.kask.perfum.klasy.dto;

import jakarta.json.bind.annotation.JsonbDateFormat;
import lombok.*;

import java.util.Date;
import java.util.UUID;

/**
 * PUT perfume request. Contains all fields that can be set up by the user when creating a new perfume.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutPerfumeRequest {

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
     * Identifier of the perfume's brand.
     */
    private UUID brand;

}