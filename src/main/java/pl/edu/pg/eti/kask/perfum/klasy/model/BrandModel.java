package pl.edu.pg.eti.kask.perfum.klasy.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * JSF view model class in order to not use entity classes. Represents single brand to be displayed or selected.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class BrandModel {

    /**
     * Brand's id.
     */
    private UUID id;

    /**
     * Name of the brand.
     */
    private String name;

    /**
     * Country where the brand is based.
     */
    private String country;

    /**
     * Description of the brand.
     */
    private String description;

}
