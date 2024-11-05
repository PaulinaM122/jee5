package pl.edu.pg.eti.kask.perfum.klasy.view;

import jakarta.enterprise.context.Conversation;
import jakarta.enterprise.context.ConversationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.edu.pg.eti.kask.perfum.klasy.entity.Brand;
import pl.edu.pg.eti.kask.perfum.klasy.model.BrandModel;
import pl.edu.pg.eti.kask.perfum.klasy.service.BrandService;

import java.io.Serializable;
import java.util.UUID;

@ConversationScoped
@Named
@NoArgsConstructor(force = true)
public class BrandCreate implements Serializable {

    private final BrandService brandService;
    private final Conversation conversation;

    @Getter
    private BrandModel brand;

    @Inject
    public BrandCreate(BrandService brandService, Conversation conversation) {
        this.brandService = brandService;
        this.conversation = conversation;
    }

    public void init() {
        if (conversation.isTransient()) {
            brand = new BrandModel();
            conversation.begin();
        }
    }

    public String saveAction() {
        var brandEntity = new Brand();
        brandEntity.setId(UUID.randomUUID());
        brandEntity.setName(brand.getName());
        brandEntity.setCountry(brand.getCountry());
        brandEntity.setDescription(brand.getDescription());

        brandService.create(brandEntity);
        conversation.end();
        return "/brand/brand_list.xhtml?faces-redirect=true";
    }

    public String cancelAction() {
        conversation.end();
        return "/brand/brand_list.xhtml?faces-redirect=true";
    }
}