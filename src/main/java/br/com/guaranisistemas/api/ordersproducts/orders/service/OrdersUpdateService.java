package br.com.guaranisistemas.api.ordersproducts.orders.service;

import br.com.guaranisistemas.api.ordersproducts.orders.model.Orders;
import br.com.guaranisistemas.api.ordersproducts.orders.model.dto.request.OrdersUpdateRequest;

/**
 * Service interface named {@link OrdersUpdateService} for updating Orders.
 */
public interface OrdersUpdateService {

    /**
     * Updates a Orders identified by its unique ID using the provided update request.
     *
     * @param ordersId            The ID of the Orders to update.
     * @param ordersUpdateRequest The request containing updated data for the Orders.
     * @return The updated Orders object.
     */
    Orders updateOrdersById(final String ordersId, final OrdersUpdateRequest ordersUpdateRequest);

}
