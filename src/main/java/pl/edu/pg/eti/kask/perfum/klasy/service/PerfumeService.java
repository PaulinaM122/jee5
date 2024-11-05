package pl.edu.pg.eti.kask.perfum.klasy.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import pl.edu.pg.eti.kask.perfum.klasy.entity.Perfume;
import pl.edu.pg.eti.kask.perfum.klasy.repository.api.PerfumeRepository;
import pl.edu.pg.eti.kask.perfum.klasy.repository.api.BrandRepository;
import pl.edu.pg.eti.kask.perfum.user.repository.api.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service layer for all business actions regarding perfume entity.
 */
@ApplicationScoped
@NoArgsConstructor(force = true)
public class PerfumeService {

    /**
     * Repository for perfume entity.
     */
    private final PerfumeRepository perfumeRepository;

    /**
     * Repository for brand entity.
     */
    private final BrandRepository brandRepository;

    /**
     * Repository for user entity.
     */
    private final UserRepository userRepository;

    /**
     * @param perfumeRepository  repository for perfume entity
     * @param brandRepository repository for brand entity
     * @param userRepository repository for user entity
     */
    @Inject
    public PerfumeService(PerfumeRepository perfumeRepository, BrandRepository brandRepository, UserRepository userRepository) {
        this.perfumeRepository = perfumeRepository;
        this.brandRepository = brandRepository;
        this.userRepository = userRepository;
    }

    /**
     * Finds single perfume.
     *
     * @param id perfume's id
     * @return container with perfume
     */
    public Optional<Perfume> find(UUID id) {
        return perfumeRepository.find(id);
    }

    /**
     * @return all available perfumes
     */
    public List<Perfume> findAll() {
        return perfumeRepository.findAll();
    }

    /**
     * @param brandId brand's id
     * @return container with perfume for brand
     */
    public Optional<List<Perfume>> findAllByBrand(UUID brandId) {
        return brandRepository.find(brandId)
                .map(perfumeRepository::findAllByBrand);
    }

    /**
     * Creates new perfume.
     *
     * @param perfume new perfume
     */
    @Transactional
    public void create(Perfume perfume) {
        if (perfumeRepository.find(perfume.getId()).isPresent()) {
            throw new IllegalArgumentException("Perfume already exists.");
        }
        if (brandRepository.find(perfume.getBrand().getId()).isEmpty()) {
            throw new IllegalArgumentException("Brand does not exists.");
        }
        perfumeRepository.create(perfume);
        /* Both sides of relationship must be handled (if accessed) because of cache. */
        brandRepository.find(perfume.getBrand().getId())
                .ifPresent(profession -> profession.getPerfumes().add(perfume));
        //userRepository.find(perfume.getUser().getId())
        //        .ifPresent(user -> user.getPerfumes().add(perfume));

    }

    /**
     * Updates existing perfume.
     *
     * @param perfume perfume to be updated
     */
    @Transactional
    public void update(Perfume perfume) {
        perfumeRepository.update(perfume);
    }

    /**
     * Deletes existing perfume.
     *
     * @param id existing perfume's id to be deleted
     */
    @Transactional
    public void delete(UUID id) {
        perfumeRepository.delete(perfumeRepository.find(id).orElseThrow());
    }

    public Optional<List<Perfume>> findAllByUser(UUID id) {
        return userRepository.find(id)
                .map(perfumeRepository::findAllByUser);
    }
}