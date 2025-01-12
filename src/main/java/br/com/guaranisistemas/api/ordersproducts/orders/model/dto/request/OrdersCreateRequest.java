package br.com.guaranisistemas.api.ordersproducts.orders.model.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

/**
 * Represents a request object for creating a new orders as {@link OrdersCreateRequest}.
 */
@Getter
@Setter
@SuperBuilder
public class OrdersCreateRequest {

    @Size(
            min = 1,
            message = "Customer Id can't be blank."
    )
    private String customerId;

    @Size(
            min = 1,
            message = "Payment Id can't be blank."
    )
    private String paymentId;
    private BigDecimal discount;
    private BigDecimal freight;
    private List<OrdersDetailsCreateRequest> items;

    public OrdersCreateRequest() {
    }
}
