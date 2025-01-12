package br.com.guaranisistemas.api.ordersproducts.orders.service;

import br.com.guaranisistemas.api.ordersproducts.orders.model.Orders;
import br.com.guaranisistemas.api.ordersproducts.orders.model.dto.request.OrdersCreateRequest;

/**
 * Service interface named {@link OrdersCreateService} for creating orderss.
 */
public interface OrdersCreateService {

    /**
     * Creates a new Orders based on the provided Orders creation request.
     *
     * @param ordersCreateRequest The request containing data to create the Orders.
     * @return The created Product object.
     */
    Orders createOrders(final OrdersCreateRequest ordersCreateRequest);

}
