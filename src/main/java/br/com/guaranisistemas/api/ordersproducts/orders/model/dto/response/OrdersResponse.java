package br.com.guaranisistemas.api.ordersproducts.orders.model.dto.response;

import br.com.guaranisistemas.api.ordersproducts.orders.model.entity.OrderDetailEntity;
import lombok.*;

import java.util.List;

/**
 * Represents a response object Orders product details as {@link OrdersResponse}.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrdersResponse {

    private String id;
    private String customerId;
    private String paymentId;
    private int statusId;
    private double subTotal;
    private double discount;
    private double freight;
    private double total;
    private List<OrderDetailEntity> items;

}
