package br.com.guaranisistemas.api.ordersproducts.orders.model.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@SuperBuilder
public class OrdersDetailsCreateRequest {

    private String orderId;
    private String productId;
    private Integer quantity;
    private BigDecimal price;

    public OrdersDetailsCreateRequest() {
    }

}
