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

/**
 * JSF view model class in order to not use entity classes. Represents single perfume to be edited.
 * Includes only fields which can be edited after perfume creation.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PerfumeEditModel {

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
     * Multipart part for uploaded image file.
     */
    private Part image;

}
