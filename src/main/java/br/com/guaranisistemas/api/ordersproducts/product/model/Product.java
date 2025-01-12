package br.com.guaranisistemas.api.ordersproducts.product.model;

import br.com.guaranisistemas.api.ordersproducts.common.model.BaseDomainModel;
import br.com.guaranisistemas.api.ordersproducts.product.model.entity.ProductCategoryEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * Represents a domain model for a product as {@link Product}.
 */
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseDomainModel {

    private String id;
    private String name;
    private ProductCategoryEntity category;
    private BigDecimal amount;
    private BigDecimal unitPrice;

}
