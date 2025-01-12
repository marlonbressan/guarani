package br.com.guaranisistemas.api.ordersproducts.auth.model;

import br.com.guaranisistemas.api.ordersproducts.common.model.BaseDomainModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Represents a permission domain object as {@link Permission} in the application.
 */
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Permission extends BaseDomainModel {
    private String id;
    private String name;
}
