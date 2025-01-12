package br.com.guaranisistemas.api.ordersproducts.product.model.entity;

import br.com.guaranisistemas.api.ordersproducts.common.model.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * Represents a persistent entity for a product as {@link ProductEntity}.
 */
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCT")
public class ProductEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_category_id")
    private ProductCategoryEntity category;

    @Column(name = "NAME")
    private String name;

    @Column(
            name = "AMOUNT",
            precision = 24,
            scale = 4
    )
    private BigDecimal amount;

    @Column(
            name = "UNIT_PRICE",
            precision = 24,
            scale = 4
    )
    private BigDecimal unitPrice;

}
