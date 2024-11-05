package pl.edu.pg.eti.kask.perfum.component;

import jakarta.enterprise.context.ApplicationScoped;
import pl.edu.pg.eti.kask.perfum.klasy.dto.GetBrandResponse;
import pl.edu.pg.eti.kask.perfum.klasy.dto.GetBrandsResponse;
import pl.edu.pg.eti.kask.perfum.klasy.dto.GetPerfumeResponse;
import pl.edu.pg.eti.kask.perfum.klasy.dto.GetPerfumesResponse;
import pl.edu.pg.eti.kask.perfum.klasy.dto.PutPerfumeRequest;
import pl.edu.pg.eti.kask.perfum.klasy.dto.PutBrandRequest;
import pl.edu.pg.eti.kask.perfum.klasy.dto.function.*;
import pl.edu.pg.eti.kask.perfum.klasy.entity.Brand;
import pl.edu.pg.eti.kask.perfum.klasy.entity.Perfume;
import pl.edu.pg.eti.kask.perfum.user.dto.GetUserResponse;
import pl.edu.pg.eti.kask.perfum.user.dto.GetUsersResponse;
import pl.edu.pg.eti.kask.perfum.user.dto.PutUserRequest;
import pl.edu.pg.eti.kask.perfum.user.dto.function.RequestToUserFunction;
import pl.edu.pg.eti.kask.perfum.user.dto.function.UpdateUserPasswordWithRequestFunction;
import pl.edu.pg.eti.kask.perfum.user.dto.function.UpdateUserWithRequestFunction;
import pl.edu.pg.eti.kask.perfum.user.dto.function.UserToResponseFunction;
import pl.edu.pg.eti.kask.perfum.user.dto.function.UsersToResponseFunction;
import pl.edu.pg.eti.kask.perfum.user.entity.User;


import java.util.function.Function;

/**
 * Factory for creating {@link Function} implementation for converting between various objects used in different layers.
 * Instead of injecting multiple function objects, a single factory is injected.
 */
@ApplicationScoped
public class DtoFunctionFactory {

    /**
     * Returns a function to convert a single {@link Perfume} to {@link GetPerfumeResponse}.
     *
     * @return PerfumeToResponseFunction instance
     */
    public PerfumeToResponseFunction perfumeToResponse() {
        return new PerfumeToResponseFunction();
    }

    /**
     * Returns a function to convert a list of {@link Perfume} to {@link GetPerfumesResponse}.
     *
     * @return PerfumesToResponseFunction instance
     */
    public PerfumesToResponseFunction perfumesToResponse() {
        return new PerfumesToResponseFunction();
    }

    /**
     * Returns a function to convert a single {@link Brand} to {@link GetBrandResponse}.
     *
     * @return BrandToResponseFunction instance
     */
    public BrandToResponseFunction brandToResponse() {
        return new BrandToResponseFunction();
    }

    /**
     * Returns a function to convert a list of {@link Brand} to {@link GetBrandsResponse}.
     *
     * @return BrandsToResponseFunction instance
     */
    public BrandsToResponseFunction brandsToResponse() {
        return new BrandsToResponseFunction();
    }

    /**
     * Returns a function to convert a {@link PutPerfumeRequest} to a {@link Perfume}.
     *
     * @return RequestToPerfumeFunction instance
     */
    public RequestToPerfumeFunction requestToPerfume() {
        return new RequestToPerfumeFunction();
    }

    /**
     * Returns a function to convert a {@link PutBrandRequest} to a {@link Brand}.
     *
     * @return RequestToBrandFunction instance
     */
    public RequestToBrandFunction requestToBrand() {
        return new RequestToBrandFunction();
    }

    /**
     * Returns a function to update a {@link Perfume}.
     *
     * @return UpdatePerfumeWithRequestFunction instance
     */

    public UpdatePerfumeWithRequestFunction updatePerfume() {
        return new UpdatePerfumeWithRequestFunction();
    }

    /**
     * Returns a function to convert a {@link PutUserRequest} to a {@link User}.
     *
     * @return RequestToUserFunction instance
     */
    public RequestToUserFunction requestToUser() {
        return new RequestToUserFunction();
    }

    /**
     * Returns a function to update a {@link User}.
     *
     * @return UpdateUserFunction instance
     */
    public UpdateUserWithRequestFunction updateUser() {
        return new UpdateUserWithRequestFunction();
    }

    /**
     * Returns a function to update a {@link User}'s password.
     *
     * @return UpdateUserPasswordFunction instance
     */
    public UpdateUserPasswordWithRequestFunction updateUserPassword() {
        return new UpdateUserPasswordWithRequestFunction();
    }

    /**
     * Returns a function to convert a list of {@link User} to {@link GetUsersResponse}.
     *
     * @return UsersToResponseFunction instance
     */
    public UsersToResponseFunction usersToResponse() {
        return new UsersToResponseFunction();
    }

    /**
     * Returns a function to convert a single {@link User} to {@link GetUserResponse}.
     *
     * @return UserToResponseFunction instance
     */
    public UserToResponseFunction userToResponse() {
        return new UserToResponseFunction();
    }

    public UpdateBrandWithRequestFunction updateBrand() {
        return new UpdateBrandWithRequestFunction();
    }
}

