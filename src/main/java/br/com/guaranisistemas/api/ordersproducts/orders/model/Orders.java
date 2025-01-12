package br.com.guaranisistemas.api.ordersproducts.orders.model;

import br.com.guaranisistemas.api.ordersproducts.common.model.BaseDomainModel;
import br.com.guaranisistemas.api.ordersproducts.customer.model.entity.CustomerEntity;
import br.com.guaranisistemas.api.ordersproducts.payment.model.entity.TypePaymentEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Represents a domain model for a product as {@link Orders}.
 */
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Orders extends BaseDomainModel {

    private String id;
    private CustomerEntity customer;
    private TypePaymentEntity payment;
    private int status;
    private double subTotal;
    private double discount;
    private double freight;
    private double total;

}