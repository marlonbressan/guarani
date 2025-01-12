package br.com.guaranisistemas.api.ordersproducts.orders.service;

/**
 * Service interface named {@link OrdersDeleteService} for deleting Orders.
 */
public interface OrdersDeleteService {

    /**
     * Deletes a Orders identified by its unique ID.
     *
     * @param ordersId The ID of the Orders to delete.
     */
    void deleteOrdersById(final String ordersId);

}
