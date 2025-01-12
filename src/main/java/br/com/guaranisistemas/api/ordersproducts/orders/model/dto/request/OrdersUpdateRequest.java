package br.com.guaranisistemas.api.ordersproducts.orders.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

/**
 * Represents a request object for updating an existing Orders as {@link OrdersUpdateRequest}.
 */
@Getter
@Setter
@SuperBuilder
public class OrdersUpdateRequest {

    private String id;
    private String customerId;
    private String paymentId;
    private int statusId;
    private BigDecimal discount;
    private BigDecimal freight;
    private List<OrdersDetailsCreateRequest> items;

    public OrdersUpdateRequest() {
    }
}
