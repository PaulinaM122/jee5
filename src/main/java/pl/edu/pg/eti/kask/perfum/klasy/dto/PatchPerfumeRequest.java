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

/**
 * PATCH perfume request. Contains fields that can be updated by the user.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PatchPerfumeRequest {

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

}
