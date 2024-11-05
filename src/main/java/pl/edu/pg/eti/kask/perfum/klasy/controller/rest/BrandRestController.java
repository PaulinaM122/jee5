package pl.edu.pg.eti.kask.perfum.klasy.controller.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Path;
import pl.edu.pg.eti.kask.perfum.klasy.controller.api.BrandController;
import pl.edu.pg.eti.kask.perfum.klasy.dto.GetBrandResponse;
import pl.edu.pg.eti.kask.perfum.klasy.dto.GetBrandsResponse;
import pl.edu.pg.eti.kask.perfum.klasy.dto.PutBrandRequest;
import pl.edu.pg.eti.kask.perfum.klasy.service.BrandService;
import pl.edu.pg.eti.kask.perfum.component.DtoFunctionFactory;
import pl.edu.pg.eti.kask.perfum.klasy.dto.PatchBrandRequest;
import pl.edu.pg.eti.kask.perfum.klasy.entity.Brand;

import java.util.UUID;

/**
 * Simple framework agnostic implementation of controller.
 */
@Path("")
public class BrandRestController implements BrandController {

    /**
     * Brand service.
     */
    private final BrandService service;

    /**
     * Factory producing functions for conversion between DTO and entities.
     */
    private final DtoFunctionFactory factory;

    /**
     * @param service brand service
     * @param factory factory producing functions for conversion between DTO and entities
     */
    @Inject
    public BrandRestController(BrandService service, DtoFunctionFactory factory) {
        this.service = service;
        this.factory = factory;
    }

    @Override
    public GetBrandsResponse getBrands() {
        return factory.brandsToResponse().apply(service.findAll());
    }

    @Override
    public GetBrandResponse getBrand(UUID id) {
        return service.find(id)
                .map(factory.brandToResponse())
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public void deleteBrand(UUID id) {
        service.find(id).ifPresentOrElse(
                entity -> service.delete(id),
                () -> { throw new NotFoundException(); }
        );
    }

    @Override
    public void updateBrand(UUID id, PatchBrandRequest request) {
        Brand existingBrand = service.find(id).orElseThrow(NotFoundException::new);
        Brand updatedBrand = factory.updateBrand().apply(existingBrand, request);
        service.update(updatedBrand);
    }

    @Override
    public void createBrand(UUID id, PutBrandRequest request) {
        Brand brand = factory.requestToBrand().apply(id, request);
        service.create(brand);
    }

}

