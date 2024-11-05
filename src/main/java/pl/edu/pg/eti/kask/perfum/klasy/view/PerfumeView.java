package pl.edu.pg.eti.kask.perfum.klasy.view;

import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.Setter;
import pl.edu.pg.eti.kask.perfum.klasy.entity.Perfume;
import pl.edu.pg.eti.kask.perfum.klasy.model.PerfumeModel;
import pl.edu.pg.eti.kask.perfum.klasy.service.PerfumeService;
import pl.edu.pg.eti.kask.perfum.component.ModelFunctionFactory;

import java.io.IOException;
import java.io.Serializable;
import java.util.Optional;
import java.util.UUID;

/**
 * View bean for rendering single perfume information.
 */
@ViewScoped
@Named
public class PerfumeView implements Serializable {

    private final PerfumeService service;
    private final ModelFunctionFactory factory;

    @Setter
    @Getter
    private UUID id;

    @Getter
    private PerfumeModel perfume;

    @Inject
    public PerfumeView(PerfumeService service, ModelFunctionFactory factory) {
        this.service = service;
        this.factory = factory;
    }

    public void init() throws IOException {
        Optional<Perfume> perfume = service.find(id);
        if (perfume.isPresent()) {
            this.perfume = factory.perfumeToModel().apply(perfume.get());
        } else {
            FacesContext.getCurrentInstance().getExternalContext().responseSendError(HttpServletResponse.SC_NOT_FOUND, "Perfume not found");
        }
    }
}
