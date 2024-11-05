package pl.edu.pg.eti.kask.perfum.klasy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for creating a new brand.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PutBrandRequest {
    private String name;
    private String description;
    private String country;
}
