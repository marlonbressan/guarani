package br.com.guaranisistemas.api.ordersproducts.orders.service.impl;

import br.com.guaranisistemas.api.ordersproducts.orders.model.entity.OrdersEntity;
import br.com.guaranisistemas.api.ordersproducts.orders.repository.OrdersRepository;
import br.com.guaranisistemas.api.ordersproducts.orders.service.OrdersReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation named {@link OrdersReportServiceImpl} for reading customers.
 */
@Service
@RequiredArgsConstructor
public class OrdersReportServiceImpl implements OrdersReportService {

    private final OrdersRepository ordersRepository;

    @Override
    public List<OrdersEntity> findByStatus(int status) {
        return (status == -1) ? ordersRepository.findAll() : ordersRepository.findByStatus(status);
    }
}
