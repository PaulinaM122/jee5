package pl.edu.pg.eti.kask.perfum.klasy.repository.persistence;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pl.edu.pg.eti.kask.perfum.klasy.entity.Brand;
import pl.edu.pg.eti.kask.perfum.klasy.repository.api.BrandRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository for Brand entity. Repositories should be used in the business layer (e.g., in services).
 * The request scope is necessary because {@link EntityManager} objects are not thread-safe.
 * Repositories must be request-scoped to ensure a single entity manager per thread, as services are CDI application-scoped.
 */
@RequestScoped
public class BrandPersistenceRepository implements BrandRepository {

    /**
     * Connection with the database (not thread-safe).
     */
    private EntityManager em;

    @PersistenceContext
    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public Optional<Brand> find(UUID id) {
        return Optional.ofNullable(em.find(Brand.class, id));
    }

    @Override
    public List<Brand> findAll() {
        return em.createQuery("select b from Brand b", Brand.class).getResultList();
    }

    @Override
    public void create(Brand entity) {
        em.persist(entity);
    }

    @Override
    public void delete(Brand entity) {
        /* Opcjonalnie: Czyszczenie cache'u na poziomie sesji lub zarządzania stanami, jeśli jest to potrzebne */
        em.remove(em.find(Brand.class, entity.getId()));
    }

    @Override
    public void update(Brand entity) {
        em.merge(entity);
    }
}