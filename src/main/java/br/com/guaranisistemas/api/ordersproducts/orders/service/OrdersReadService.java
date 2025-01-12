package br.com.guaranisistemas.api.ordersproducts.orders.service;

import br.com.guaranisistemas.api.ordersproducts.common.model.CustomPage;
import br.com.guaranisistemas.api.ordersproducts.orders.model.Orders;
import br.com.guaranisistemas.api.ordersproducts.orders.model.dto.request.OrdersPagingRequest;
import br.com.guaranisistemas.api.ordersproducts.orders.model.entity.OrdersEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Service interface named {@link OrdersReadService} for reading Orders.
 */
public interface OrdersReadService {

    /**
     * Retrieves a Orders by its unique ID.
     *
     * @param ordersId The ID of the Orders to retrieve.
     * @return The Orders object corresponding to the given ID.
     */
    Orders getOrdersById(final String ordersId);

    /**
     * Retrieves a page of Orders based on the paging request criteria.
     *
     * @param ordersPagingRequest The paging request criteria.
     * @return A CustomPage containing the list of Orders that match the paging criteria.
     */
    CustomPage<Orders> getOrders(final OrdersPagingRequest ordersPagingRequest);

    List<OrdersEntity> findByFilters(int status,
                                     LocalDateTime startDate, LocalDateTime endDate, BigDecimal total);
}
