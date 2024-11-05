package pl.edu.pg.eti.kask.perfum.klasy.model;

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
 * JSF view model class in order to not use entity classes. Represents single perfume to be displayed.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PerfumeModel {

    /**
     * Unique identifier of the perfume.
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
    private Date releaseDate;

    /**
     * Price of the perfume.
     */
    private Double price;

    /**
     * Scent type of the perfume (e.g., floral, woody, etc.).
     */
    private String scentType;

    /**
     * Name of the brand.
     */
    private String brand;

}
