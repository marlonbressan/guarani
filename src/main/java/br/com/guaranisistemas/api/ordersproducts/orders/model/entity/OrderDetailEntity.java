package br.com.guaranisistemas.api.ordersproducts.orders.model.entity;

import br.com.guaranisistemas.api.ordersproducts.common.model.entity.BaseEntity;
import br.com.guaranisistemas.api.ordersproducts.product.model.entity.ProductEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@SuperBuilder
@Table(name = "ORDERS_DETAILS")
public class OrderDetailEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne()
    @JoinColumn(name = "orders_id")
    @JsonBackReference
    private OrdersEntity order;

    @Column()
    private Integer quantity;

    @Column()
    private BigDecimal price;

    @Column()
    private BigDecimal total;

    public OrderDetailEntity() {
    }

    public ProductEntity getProduct() {
        if (product == null) {
            product = new ProductEntity();
        }
        return product;
    }

    @PrePersist
    public void prePersist() {
        this.total = this.price.multiply(new BigDecimal(this.quantity));
    }

}
