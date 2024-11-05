package pl.edu.pg.eti.kask.perfum.klasy.controller.api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import pl.edu.pg.eti.kask.perfum.klasy.dto.GetPerfumeResponse;
import pl.edu.pg.eti.kask.perfum.klasy.dto.GetPerfumesResponse;
import pl.edu.pg.eti.kask.perfum.klasy.dto.PatchPerfumeRequest;
import pl.edu.pg.eti.kask.perfum.klasy.dto.PutPerfumeRequest;

import java.util.UUID;

/**
 * Controller for managing collections of perfumes.
 */
@Path("")
public interface PerfumeController {

    /**
     * Pobiera wszystkie perfumy.
     *
     * @return reprezentacja wszystkich perfum.
     */
    @GET
    @Path("/perfumes")
    @Produces(MediaType.APPLICATION_JSON)
    GetPerfumesResponse getPerfumes();

    /**
     * Pobiera perfumy według ID marki.
     *
     * @param id ID marki perfum.
     * @return reprezentacja perfum.
     */
    @GET
    @Path("/brands/{id}/perfumes")
    @Produces(MediaType.APPLICATION_JSON)
    GetPerfumesResponse getBrandPerfumes(@PathParam("id") UUID id);

    /**
     * Pobiera perfumy użytkownika według ID użytkownika.
     *
     * @param id ID użytkownika.
     * @return reprezentacja perfum użytkownika.
     */
    @GET
    @Path("/users/{id}/perfumes")
    @Produces(MediaType.APPLICATION_JSON)
    GetPerfumesResponse getUserPerfumes(@PathParam("id") UUID id);

    /**
     * Pobiera pojedyncze perfumy na podstawie ID.
     *
     * @param id ID perfum.
     * @return reprezentacja perfum.
     */
    @GET
    @Path("/perfumes/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    GetPerfumeResponse getPerfume(@PathParam("id") UUID id);

    /**
     * Tworzy lub aktualizuje perfumy.
     *
     * @param id      ID perfum.
     * @param request nowa reprezentacja perfum.
     */
    @PUT
    @Path("/perfumes/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    void putPerfume(@PathParam("id") UUID id, PutPerfumeRequest request);

    /**
     * Aktualizuje istniejące perfumy.
     *
     * @param id      ID perfum.
     * @param request reprezentacja aktualizacji perfum.
     */
    @PATCH
    @Path("/brands/{brandId}/perfumes/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    void patchPerfume(@PathParam("id") UUID id, PatchPerfumeRequest request);

    /**
     * Usuwa perfumy na podstawie ID.
     *
     * @param id ID perfum.
     */
    @DELETE
    @Path("/brands/{brandId}/perfumes/{id}")
    void deletePerfume(@PathParam("id") UUID id);

    @PUT
    @Path("/brands/{brandId}/perfumes/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    void createPerfume(@PathParam("brandId") UUID brandId, @PathParam("id") UUID id, PutPerfumeRequest request);

}