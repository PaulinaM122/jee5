package pl.edu.pg.eti.kask.perfum.user.service;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;
import lombok.NoArgsConstructor;
import pl.edu.pg.eti.kask.perfum.crypto.component.Pbkdf2PasswordHash;
import pl.edu.pg.eti.kask.perfum.user.entity.User;
import pl.edu.pg.eti.kask.perfum.user.repository.api.UserRepository;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service layer for all business actions regarding user entity.
 */
@ApplicationScoped
@NoArgsConstructor(force = true)
public class UserService {

    /**
     * Repository for user entity.
     */

    private final UserRepository repository;

    /**
     * Hash mechanism used for storing users' passwords.
     */
    private final Pbkdf2PasswordHash passwordHash;

    @Resource(name="avatarsDir")
    private String avatarsDir;

    /**
     * @param repository   repository for perfume entity
     * @param passwordHash hash mechanism used for storing users' passwords
     */
    @Inject
    public UserService(UserRepository repository, Pbkdf2PasswordHash passwordHash) {
        this.repository = repository;
        this.passwordHash = passwordHash;
    }

    /**
     * @param id user's id
     * @return container (can be empty) with user
     */
    public Optional<User> find(UUID id) {
        return repository.find(id);
    }

    /**
     * Seeks for single user using login and password. Can be used in authentication module.
     *
     * @param login user's login
     * @return container (can be empty) with user
     */
    public Optional<User> find(String login) {
        return repository.findByLogin(login);
    }

    /**
     * Saves new user. Password is hashed using configured hash algorithm.
     *
     * @param user new user to be saved
     */
    @Transactional
    public void create(User user) {
        user.setPassword(passwordHash.generate(user.getPassword().toCharArray()));
        repository.create(user);
    }

    /**
     * @param login    user's login
     * @param password user's password
     * @return true if provided login and password are correct
     */
    public boolean verify(String login, String password) {
        return find(login)
                .map(user -> passwordHash.verify(password.toCharArray(), user.getPassword()))
                .orElse(false);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public void update(User user) {
        repository.update(user);
    }

    public void delete(UUID id) {
        repository.delete(repository.find(id).orElseThrow());
    }

    public void putAvatar(UUID uuid, InputStream avatar) {
        repository.find(uuid).ifPresent(user -> {
            Path avatarPath = Paths.get(avatarsDir + File.separator + uuid.toString() + ".png");
            if (Files.exists(avatarPath)) {
                throw new BadRequestException("Avatar of user with the id " + uuid + " already exists");
            }
            try {
                Files.copy(avatar, avatarPath);
            } catch(IOException ex){
                System.err.println(ex.getMessage());
            }
        });
    }

    public void deleteAvatar(UUID uuid) {
        Path avatarPath = Paths.get(avatarsDir + File.separator + uuid.toString() + ".png");
        if(!Files.exists((avatarPath))){
            throw new NotFoundException("User with the id " + uuid + " doesn't have an avatar");
        }
        try {
            Files.delete(avatarPath);
        } catch (IOException ex){
            System.err.println(ex.getMessage());
        }
    }

    public byte[] findUserAvatar(UUID uuid) throws IOException{
        Path avatarPath = Paths.get(avatarsDir + File.separator + uuid.toString() + ".png");
        if (Files.exists(avatarPath)) {
            return Files.readAllBytes(avatarPath);
        }
        return null;
    }

    public void patchAvatar(UUID uuid, InputStream avatar) {
        repository.find(uuid).ifPresent(user -> {
            Path avatarPath = Paths.get(avatarsDir + File.separator + uuid.toString() + ".png");
            if (!Files.exists(avatarPath)) {
                throw new NotFoundException("User with the id " + uuid + " doesn't have an avatar");

            }
            try {
                Files.delete(avatarPath);
                Files.copy(avatar, avatarPath);
            } catch(IOException ex){
                System.err.println(ex.getMessage());
            }
        });
    }
}
