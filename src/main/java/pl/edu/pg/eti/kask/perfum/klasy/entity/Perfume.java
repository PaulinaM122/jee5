package pl.edu.pg.eti.kask.perfum.klasy.entity;

import jakarta.persistence.*;
import jakarta.json.bind.annotation.JsonbDateFormat;
import lombok.*;
import lombok.experimental.SuperBuilder;
import pl.edu.pg.eti.kask.perfum.user.entity.User;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Entity representing a perfume.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString(callSuper = true)
@EqualsAndHashCode
@Entity
@Table(name = "perfumes")
public class Perfume implements Serializable {

    /**
     * Unique id (primary key).
     */
    @Id
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
     * Brand of the perfume.
     */
    @ManyToOne
    @JoinColumn(name = "brand")
    private Brand brand;

    /**
     * Owner of this character.
     */
    @ManyToOne
    @JoinColumn(name = "user_name")
    private User user;


    /**
     * Price of the perfume.
     */
    private Double price;

    /**
     * Scent type of the perfume (e.g., floral, woody, etc.).
     */
    private ScentType scentType;

    public enum ScentType {
        FLORAL, WOODY, SPICY, FRESH, ORIENTAL
    }
}
