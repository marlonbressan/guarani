package br.com.guaranisistemas.api.ordersproducts.payment.model.entity;

import br.com.guaranisistemas.api.ordersproducts.common.model.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@Table(name = "TYPE_PAYMENT")
@SuperBuilder
public class TypePaymentEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", unique = true)
    private String id;

    @Column(nullable = false)
    private String description;

    protected TypePaymentEntity() {
    }
}
