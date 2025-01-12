package br.com.guaranisistemas.api.ordersproducts.customer.model;

import br.com.guaranisistemas.api.ordersproducts.common.model.BaseDomainModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Represents a domain model for a product as {@link Customer}.
 */
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Customer extends BaseDomainModel {

    private String id;
    private String name;
    private String endereco;

}
