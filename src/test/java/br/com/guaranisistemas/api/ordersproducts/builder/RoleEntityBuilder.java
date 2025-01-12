package br.com.guaranisistemas.api.ordersproducts.builder;

import br.com.guaranisistemas.api.ordersproducts.auth.model.entity.PermissionEntity;
import br.com.guaranisistemas.api.ordersproducts.auth.model.entity.RoleEntity;

import java.util.List;
import java.util.UUID;

public class RoleEntityBuilder extends BaseBuilder<RoleEntity> {

    public RoleEntityBuilder() {
        super(RoleEntity.class);
    }

    public RoleEntityBuilder withValidFields() {
        return this
                .withId(UUID.randomUUID().toString())
                .withName("Admin");
    }

    public RoleEntityBuilder withId(String id) {
        data.setId(id);
        return this;
    }

    public RoleEntityBuilder withName(String name) {
        data.setName(name);
        return this;
    }

    public RoleEntityBuilder withPermissions(List<PermissionEntity> permissions) {
        data.setPermissions(permissions);
        return this;
    }
}