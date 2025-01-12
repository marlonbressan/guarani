package br.com.guaranisistemas.api.ordersproducts.orders.model.entity;

import br.com.guaranisistemas.api.ordersproducts.common.model.entity.BaseEntity;
import br.com.guaranisistemas.api.ordersproducts.customer.model.entity.CustomerEntity;
import br.com.guaranisistemas.api.ordersproducts.payment.model.entity.TypePaymentEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@SuperBuilder
@Table(name = "ORDERS")
public class OrdersEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_payment_id")
    private TypePaymentEntity payment;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<OrderDetailEntity> items;

    /* OrderStatus (enum)
    CONCLUIDO("CONCLUÍDO"),
    PENDENTE("PENDENTE"),
    CANCELADO("CANCELADO");
     */
    @Column(nullable = false)
    private int status;

    @Column(nullable = true)
    private BigDecimal subTotal;

    @Column(nullable = true)
    private BigDecimal discount;

    @Column(nullable = true)
    private BigDecimal freight;

    @Column(nullable = true)
    private BigDecimal total;

    public OrdersEntity() {
    }

    /**
     * Sets the createdBy and createdAt fields before persisting the entity.
     * If no authenticated user is found, sets createdBy to "anonymousUser".
     */
    @PrePersist
    public void prePersist() {
        onSumTotalItems();
    }

    /*
    Function created to recalculate values arround in bussiness roles
     */
    private void onSumTotalItems() {
        this.subTotal = BigDecimal.ZERO;
        if (this.items != null && !this.items.isEmpty()) {
            this.items.forEach(item ->
                    this.subTotal.add(item.getPrice().multiply(item.getPrice())));
        }
        this.total = this.subTotal.min(this.getDiscount()).add(this.getFreight());
    }

}
