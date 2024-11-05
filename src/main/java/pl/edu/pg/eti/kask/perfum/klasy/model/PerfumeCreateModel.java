package pl.edu.pg.eti.kask.perfum.klasy.model;

import jakarta.servlet.http.Part;
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
 * JSF view model class in order to not use entity classes. Represents new perfume to be created.
 * Includes all fields which can be used in perfume creation.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PerfumeCreateModel {

    /**
     * Perfume's id.
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
     * Multipart part for uploaded image file of the perfume.
     */
    private Part image;

    /**
     * Scent type of the perfume (e.g., floral, woody, etc.).
     */
    private String scentType;

    /**
     * Brand of the perfume.
     */
    private BrandModel brand;

}