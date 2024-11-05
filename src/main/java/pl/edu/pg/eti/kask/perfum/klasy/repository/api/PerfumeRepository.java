package pl.edu.pg.eti.kask.perfum.klasy.repository.api;

import pl.edu.pg.eti.kask.perfum.klasy.entity.Perfume;
import pl.edu.pg.eti.kask.perfum.klasy.entity.Brand;
import pl.edu.pg.eti.kask.perfum.repository.api.Repository;
import pl.edu.pg.eti.kask.perfum.user.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository for perfume entity.
 */
public interface PerfumeRepository extends Repository<Perfume, UUID> {

    /**
     * Seeks for single user's character.
     *
     * @param id   character's id
     * @param user character's owner
     * @return container (can be empty) with character
     */
    Optional<Perfume> findByIdAndUser(UUID id, User user);

    /**
     * Seeks for all user's characters.
     *
     * @param user characters' owner
     * @return list (can be empty) of user's characters
     */
    List<Perfume> findAllByUser(User user);

    /**
     * Finds perfumes by brand.
     *
     * @param brand Brand of the perfume
     * @return list of perfumes for the given brand
     */
    List<Perfume> findAllByBrand(Brand brand);
}

