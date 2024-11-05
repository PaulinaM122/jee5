package pl.edu.pg.eti.kask.perfum.user.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;
import pl.edu.pg.eti.kask.perfum.component.DtoFunctionFactory;
import pl.edu.pg.eti.kask.perfum.user.dto.GetUserResponse;
import pl.edu.pg.eti.kask.perfum.user.dto.GetUsersResponse;
import pl.edu.pg.eti.kask.perfum.user.dto.PatchUserRequest;
import pl.edu.pg.eti.kask.perfum.user.dto.PutUserRequest;
import pl.edu.pg.eti.kask.perfum.user.service.UserService;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@RequestScoped
public class UserSimpleController implements UserController {

    private final UserService service;
    private final DtoFunctionFactory factory;

    @Inject
    public UserSimpleController(UserService userService, DtoFunctionFactory factory) {
        this.service = userService;
        this.factory = factory;
    }

    @Override
    public GetUsersResponse getUsers() {
        return factory.usersToResponse().apply(service.findAll());
    }

    @Override
    public GetUserResponse getUser(UUID id) {
        return service.find(id)
                .map(factory.userToResponse())
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public void putUser(UUID id, PutUserRequest request) {
        try {
            service.create(factory.requestToUser().apply(id, request));
        } catch (IllegalArgumentException ex) {
            throw new BadRequestException(ex);
        }
    }

    @Override
    public void patchUser(UUID id, PatchUserRequest request) {
        service.find(id).ifPresentOrElse(
                entity -> service.update(factory.updateUser().apply(entity, request)),
                () -> {
                    throw new NotFoundException();
                }
        );
    }

    @Override
    public void deleteUser(UUID uuid) {
        service.find(uuid).ifPresentOrElse(
                entity -> service.delete(uuid),
                () -> {
                    throw new NotFoundException();
                }
        );
    }

    @Override
    public byte[] getUserAvatar(UUID uuid) {
        byte [] userAvatar = null;
        try {
            userAvatar = service.findUserAvatar(uuid);
        } catch(IOException ex){
            System.err.println(ex.getMessage());
        }
        if(userAvatar == null){
            throw new NotFoundException("User " + uuid + " does not have an avatar");
        }
        return userAvatar;
    }

    @Override
    public void deleteAvatar(UUID uuid) {
        service.find(uuid).ifPresentOrElse(
                entity -> service.deleteAvatar(uuid),
                () -> {
                    throw new NotFoundException("No user with the id: " + uuid);
                }
        );
    }

    @Override
    public void putUserAvatar(UUID uuid, InputStream avatar) {
        service.find(uuid).ifPresentOrElse(
                entity -> service.putAvatar(uuid, avatar),
                () -> {
                    throw new NotFoundException("No user with the id: " + uuid);
                }
        );
    }
}