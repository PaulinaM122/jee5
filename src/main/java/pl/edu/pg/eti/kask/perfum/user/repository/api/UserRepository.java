package pl.edu.pg.eti.kask.perfum.user.repository.api;

import pl.edu.pg.eti.kask.perfum.user.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository for User entity.
 */
public interface UserRepository {

    Optional<User> find(UUID id);
    List<User> findAll();
    void create(User entity);
    void delete(User entity);
    void update(User entity);
    Optional<User> findByLogin(String login);
}
