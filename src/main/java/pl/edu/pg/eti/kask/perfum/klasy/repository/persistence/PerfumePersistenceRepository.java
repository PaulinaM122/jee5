package pl.edu.pg.eti.kask.perfum.klasy.repository.persistence;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import pl.edu.pg.eti.kask.perfum.klasy.entity.Perfume;
import pl.edu.pg.eti.kask.perfum.klasy.entity.Brand;
import pl.edu.pg.eti.kask.perfum.klasy.repository.api.PerfumeRepository;
import pl.edu.pg.eti.kask.perfum.user.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository for Perfume entity. Repositories should be used in the business layer (e.g.: in services).
 * The request scope is a result of the fact that {@link EntityManager} objects cannot be used in multiple threads (are not thread-safe).
 * Because services are CDI application-scoped beans (technically singletons), repositories must be thread-scoped to ensure
 * a single entity manager per thread.
 */
@RequestScoped
public class PerfumePersistenceRepository implements PerfumeRepository {

    /**
     * Connection with the database (not thread-safe).
     */
    private EntityManager em;

    @PersistenceContext
    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public Optional<Perfume> find(UUID id) {
        return Optional.ofNullable(em.find(Perfume.class, id));
    }

    @Override
    public List<Perfume> findAll() {
        return em.createQuery("select p from Perfume p", Perfume.class).getResultList();
    }

    @Override
    public void create(Perfume entity) {
        em.persist(entity);
    }

    @Override
    public void delete(Perfume entity) {
        em.remove(em.find(Perfume.class, entity.getId()));
    }

    @Override
    public void update(Perfume entity) {
        em.merge(entity);
    }

    @Override
    public Optional<Perfume> findByIdAndUser(UUID id, User user) {
        try {
            return Optional.of(em.createQuery("select p from Perfume p where p.id = :id and p.user = :user", Perfume.class)
                    .setParameter("user", user)
                    .setParameter("id", id)
                    .getSingleResult());
        } catch (NoResultException ex) {
            return Optional.empty();
        }
    }

    @Override
    public List<Perfume> findAllByUser(User user) {
        return em.createQuery("select p from Perfume p where p.user = :user", Perfume.class)
                .setParameter("user", user)
                .getResultList();
    }

    @Override
    public List<Perfume> findAllByBrand(Brand brand) {
        return em.createQuery("select p from Perfume p where p.brand = :brand", Perfume.class)
                .setParameter("brand", brand)
                .getResultList();
    }
}