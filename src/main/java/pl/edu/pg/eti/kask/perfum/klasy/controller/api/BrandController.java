package pl.edu.pg.eti.kask.perfum.klasy.controller.api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import pl.edu.pg.eti.kask.perfum.klasy.dto.GetBrandResponse;
import pl.edu.pg.eti.kask.perfum.klasy.dto.GetBrandsResponse;
import pl.edu.pg.eti.kask.perfum.klasy.dto.PatchBrandRequest;
import pl.edu.pg.eti.kask.perfum.klasy.dto.PutBrandRequest;

import java.util.UUID;

/**
 * Controller for managing collections of brands.
 */
@Path("")
public interface BrandController {

    /**
     * @return all brands representation
     */
    @GET
    @Path("/brands")
    @Produces(MediaType.APPLICATION_JSON)
    GetBrandsResponse getBrands();

    /**
     * @param id brand's id
     * @return brand representation
     */
    @GET
    @Path("/brands/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    GetBrandResponse getBrand(@PathParam("id") UUID id);

    /**
     * @param id brand's id
     */
    @DELETE
    @Path("/brands/{id}")
    void deleteBrand(@PathParam("id") UUID id);

    @PATCH
    @Path("/brands/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    void updateBrand(@PathParam("id") UUID id, PatchBrandRequest request);

    @PUT
    @Path("/brands/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    void createBrand(@PathParam("id") UUID id, PutBrandRequest request);

}