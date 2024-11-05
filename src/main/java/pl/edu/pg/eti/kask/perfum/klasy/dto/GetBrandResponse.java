package pl.edu.pg.eti.kask.perfum.klasy.dto;

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
 * GET brand response. Contains all fields that can be presented (but not necessarily changed) to the user.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetBrandResponse {

    /**
     * Unique id identifying the brand.
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