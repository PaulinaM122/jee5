package pl.edu.pg.eti.kask.perfum.klasy.model.converter;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import pl.edu.pg.eti.kask.perfum.klasy.entity.Brand;
import pl.edu.pg.eti.kask.perfum.klasy.model.BrandModel;
import pl.edu.pg.eti.kask.perfum.klasy.service.BrandService;
import pl.edu.pg.eti.kask.perfum.component.ModelFunctionFactory;

import java.util.Optional;
import java.util.UUID;

/**
 * Faces converter for {@link BrandModel}. The managed attribute in {@link FacesConverter} allows the converter to
 * be a CDI bean. In previous versions of JSF, converters were always created inside the JSF lifecycle and were not managed
 * by the container, meaning injection was not possible. As this bean is not annotated with a specific scope, the beans.xml descriptor
 * must be present.
 */
@FacesConverter(forClass = BrandModel.class, managed = true)
public class BrandModelConverter implements Converter<BrandModel> {

    /**
     * Service for managing brands.
     */
    private final BrandService service;

    /**
     * Factory producing functions for conversion between models and entities.
     */
    private final ModelFunctionFactory factory;

    /**
     * @param service service for managing brands
     * @param factory factory producing functions for conversion between models and entities
     */
    @Inject
    public BrandModelConverter(BrandService service, ModelFunctionFactory factory) {
        this.service = service;
        this.factory = factory;
    }

    @Override
    public BrandModel getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        Optional<Brand> brand = service.find(UUID.fromString(value));
        return brand.map(factory.brandToModel()).orElse(null);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, BrandModel value) {
        return value == null ? "" : value.getId().toString();
    }

}
