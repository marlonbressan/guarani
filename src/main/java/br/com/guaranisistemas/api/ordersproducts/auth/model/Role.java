package br.com.guaranisistemas.api.ordersproducts.auth.model;

import br.com.guaranisistemas.api.ordersproducts.common.model.BaseDomainModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * Represents a role domain object as {@link Role} in the application.
 */
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseDomainModel {

    private String id;
    private String name;
    private List<Permission> permissions;

}
