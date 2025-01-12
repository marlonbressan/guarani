package br.com.guaranisistemas.api.ordersproducts.builder;

import br.com.guaranisistemas.api.ordersproducts.auth.model.entity.PermissionEntity;

import java.util.UUID;

public class PermissionEntityBuilder extends BaseBuilder<PermissionEntity> {

    public PermissionEntityBuilder() {
        super(PermissionEntity.class);
    }

    public PermissionEntityBuilder withValidFields() {
        return this
                .withId(UUID.randomUUID().toString())
                .withName("READ_PRIVILEGES");
    }

    public PermissionEntityBuilder withId(String id) {
        data.setId(id);
        return this;
    }

    public PermissionEntityBuilder withName(String name) {
        data.setName(name);
        return this;
    }
}
