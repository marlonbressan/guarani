package br.com.guaranisistemas.api.ordersproducts.product.model.entity;

import br.com.guaranisistemas.api.ordersproducts.common.model.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@Table(name = "PRODUCT_CATEGORY")
@SuperBuilder
public class ProductCategoryEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private long id;

    @Column(nullable = false)
    private String description;

    public ProductCategoryEntity() {
    }
}
