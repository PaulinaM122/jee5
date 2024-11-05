package pl.edu.pg.eti.kask.perfum.user.controller;

import jakarta.servlet.http.Part;
import pl.edu.pg.eti.kask.perfum.user.dto.GetUserResponse;
import pl.edu.pg.eti.kask.perfum.user.dto.GetUsersResponse;
import pl.edu.pg.eti.kask.perfum.user.dto.PatchUserRequest;
import pl.edu.pg.eti.kask.perfum.user.dto.PutUserRequest;

import java.io.InputStream;
import java.util.UUID;

public interface UserController {

    GetUsersResponse getUsers();

    GetUserResponse getUser(UUID uuid);

    void putUser(UUID uuid, PutUserRequest request);

    void patchUser(UUID uuid, PatchUserRequest userRequest);

    void deleteUser(UUID uuid);

    byte[] getUserAvatar(UUID uuid);

    void putUserAvatar(UUID uuid, InputStream avatar);

    void deleteAvatar(UUID uuid);

}

