package br.com.guaranisistemas.api.ordersproducts.orders.service.impl;

import br.com.guaranisistemas.api.ordersproducts.orders.enums.OrderStatus;
import br.com.guaranisistemas.api.ordersproducts.orders.exception.OrdersAlreadyExistException;
import br.com.guaranisistemas.api.ordersproducts.orders.mapper.OrdersCreateRequestToOrdersEntityMapper;
import br.com.guaranisistemas.api.ordersproducts.orders.mapper.OrdersEntityToOrdersMapper;
import br.com.guaranisistemas.api.ordersproducts.orders.model.Orders;
import br.com.guaranisistemas.api.ordersproducts.orders.model.dto.request.OrdersCreateRequest;
import br.com.guaranisistemas.api.ordersproducts.orders.model.entity.OrdersEntity;
import br.com.guaranisistemas.api.ordersproducts.orders.repository.OrdersRepository;
import br.com.guaranisistemas.api.ordersproducts.orders.service.OrdersCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service implementation named {@link OrdersCreateServiceImpl} for creating orderss.
 */
@Service
@RequiredArgsConstructor
public class OrdersCreateServiceImpl implements OrdersCreateService {

    private final OrdersRepository ordersRepository;

    private final OrdersCreateRequestToOrdersEntityMapper ordersCreateRequestToOrdersEntityMapper =
            OrdersCreateRequestToOrdersEntityMapper.initialize();

    private final OrdersEntityToOrdersMapper ordersEntityToOrdersMapper = OrdersEntityToOrdersMapper.initialize();

    /**
     * Creates a new orders based on the provided orders creation request.
     *
     * @param ordersCreateRequest The request containing data to create the orders.
     * @return The created Orders object.
     * @throws OrdersAlreadyExistException If a orders with the same name already exists.
     */
    @Override
    public Orders createOrders(OrdersCreateRequest ordersCreateRequest) {

        final OrdersEntity ordersEntityToBeSave = ordersCreateRequestToOrdersEntityMapper.mapForSaving(ordersCreateRequest);

        ordersEntityToBeSave.setStatus(OrderStatus.PENDENTE.ordinal());
        OrdersEntity savedOrdersEntity = ordersRepository.save(ordersEntityToBeSave);

        return ordersEntityToOrdersMapper.map(savedOrdersEntity);

    }
}
