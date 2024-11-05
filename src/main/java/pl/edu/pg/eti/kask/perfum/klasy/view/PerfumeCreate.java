package pl.edu.pg.eti.kask.perfum.klasy.view;

import jakarta.enterprise.context.Conversation;
import jakarta.enterprise.context.ConversationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import pl.edu.pg.eti.kask.perfum.klasy.entity.Perfume;
import pl.edu.pg.eti.kask.perfum.klasy.model.PerfumeCreateModel;
import pl.edu.pg.eti.kask.perfum.klasy.model.BrandModel;
import pl.edu.pg.eti.kask.perfum.klasy.service.PerfumeService;
import pl.edu.pg.eti.kask.perfum.klasy.service.BrandService;
import pl.edu.pg.eti.kask.perfum.component.ModelFunctionFactory;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * View bean for rendering single perfume create form.
 */
@ConversationScoped
@Named
@Log
@NoArgsConstructor(force = true)
public class PerfumeCreate implements Serializable {

    private final PerfumeService perfumeService;
    private final BrandService brandService;
    private final ModelFunctionFactory factory;

    @Getter
    private PerfumeCreateModel perfume;

    @Getter
    private List<BrandModel> brands;

    private final Conversation conversation;

    @Inject
    public PerfumeCreate(
            PerfumeService perfumeService,
            BrandService brandService,
            ModelFunctionFactory factory,
            Conversation conversation
    ) {
        this.perfumeService = perfumeService;
        this.factory = factory;
        this.brandService = brandService;
        this.conversation = conversation;
    }

    public void init() {
        if (conversation.isTransient()) {
            brands = brandService.findAll().stream()
                    .map(factory.brandToModel())
                    .collect(Collectors.toList());
            perfume = PerfumeCreateModel.builder()
                    .id(UUID.randomUUID())
                    .build();
            conversation.begin();
        }
    }

    public String goToBasicAction() {
        return "/klasy/perfume_create_basic.xhtml?faces-redirect=true";
    }

    public String goToBrandAction() {
        return "/klasy/perfume_create_brand.xhtml?faces-redirect=true";
    }

    public String goToConfirmAction() {
        return "/klasy/perfume_create_confirm.xhtml?faces-redirect=true";
    }

    public String cancelAction() {
        conversation.end();
        return "/klasy/perfume_list.xhtml?faces-redirect=true";
    }

    public String saveAction() {
        perfumeService.create(factory.modelToPerfume().apply(perfume));
        conversation.end();
        return "/klasy/perfume_list.xhtml?faces-redirect=true";
    }

    public String getConversationId() {
        return conversation.getId();
    }

    public Perfume.ScentType[] getScentTypes() {
        return Perfume.ScentType.values();
    }
}