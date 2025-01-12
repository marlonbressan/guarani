package br.com.guaranisistemas.api.ordersproducts.orders.service;

import br.com.guaranisistemas.api.ordersproducts.orders.model.entity.OrdersEntity;

import java.util.List;

/**
 * Service interface named {@link OrdersReportService} for reading Orders.
 */
public interface OrdersReportService {

    List<OrdersEntity> findByStatus(final int status);

}
