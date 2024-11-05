package pl.edu.pg.eti.kask.perfum.klasy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for updating a brand.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatchBrandRequest {

    private String name;
    private String country;
    private String description;

}