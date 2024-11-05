package pl.edu.pg.eti.kask.perfum.klasy.view;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import pl.edu.pg.eti.kask.perfum.klasy.model.PerfumesModel;
import pl.edu.pg.eti.kask.perfum.klasy.service.PerfumeService;
import pl.edu.pg.eti.kask.perfum.component.ModelFunctionFactory;

/**
 * View bean for rendering list of perfumes.
 */
@RequestScoped
@Named
public class PerfumeList {

    private final PerfumeService service;
    private PerfumesModel perfumes;
    private final ModelFunctionFactory factory;

    @Inject
    public PerfumeList(PerfumeService service, ModelFunctionFactory factory) {
        this.service = service;
        this.factory = factory;
    }

    public PerfumesModel getPerfumes() {
        if (perfumes == null) {
            perfumes = factory.perfumesToModel().apply(service.findAll());
        }
        return perfumes;
    }

    public String deleteAction(PerfumesModel.Perfume perfume) {
        service.delete(perfume.getId());
        return "perfume_list?faces-redirect=true";
    }
}
