package br.com.guaranisistemas.api.ordersproducts.orders.service.impl;

import br.com.guaranisistemas.api.ordersproducts.common.model.CustomPage;
import br.com.guaranisistemas.api.ordersproducts.common.util.HelperPagination;
import br.com.guaranisistemas.api.ordersproducts.orders.exception.OrdersNotFoundException;
import br.com.guaranisistemas.api.ordersproducts.orders.mapper.ListOrdersEntityToListOrdersMapper;
import br.com.guaranisistemas.api.ordersproducts.orders.mapper.OrdersEntityToOrdersMapper;
import br.com.guaranisistemas.api.ordersproducts.orders.model.Orders;
import br.com.guaranisistemas.api.ordersproducts.orders.model.dto.request.OrdersPagingRequest;
import br.com.guaranisistemas.api.ordersproducts.orders.model.entity.OrdersEntity;
import br.com.guaranisistemas.api.ordersproducts.orders.repository.OrdersRepository;
import br.com.guaranisistemas.api.ordersproducts.orders.service.OrdersReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Service implementation named {@link OrdersReadServiceImpl} for reading orderss.
 */
@Service
@RequiredArgsConstructor
public class OrdersReadServiceImpl implements OrdersReadService {

    private final OrdersRepository ordersRepository;

    private final OrdersEntityToOrdersMapper ordersEntityToOrdersMapper = OrdersEntityToOrdersMapper.initialize();

    private final ListOrdersEntityToListOrdersMapper listOrdersEntityToListOrdersMapper =
            ListOrdersEntityToListOrdersMapper.initialize();

    /**
     * Retrieves a orders by its unique ID.
     *
     * @param ordersId The ID of the orders to retrieve.
     * @return The Orders object corresponding to the given ID.
     * @throws OrdersNotFoundException If no orders with the given ID exists.
     */
    @Override
    public Orders getOrdersById(String ordersId) {

        final OrdersEntity ordersEntityFromDB = ordersRepository
                .findById(ordersId)
                .orElseThrow(() -> new OrdersNotFoundException("With given ordersID = " + ordersId));

        return ordersEntityToOrdersMapper.map(ordersEntityFromDB);
    }

    /**
     * Retrieves a page of orderss based on the paging request criteria.
     *
     * @param ordersPagingRequest The paging request criteria.
     * @return A CustomPage containing the list of orderss that match the paging criteria.
     * @throws OrdersNotFoundException If no orderss are found based on the paging criteria.
     */
    @Override
    public CustomPage<Orders> getOrders(OrdersPagingRequest ordersPagingRequest) {

        if (ordersPagingRequest == null) {
            ordersPagingRequest = HelperPagination.createOrderDefaultPagination();
        }
        final Page<OrdersEntity> ordersEntityPage = ordersRepository.findAll(ordersPagingRequest.toPageable());

        if (ordersEntityPage.getContent().isEmpty()) {
            throw new OrdersNotFoundException("Couldn't find any Orders");
        }

        final List<Orders> ordersDomainModels = listOrdersEntityToListOrdersMapper
                .toOrdersList(ordersEntityPage.getContent());

        return CustomPage.of(ordersDomainModels, ordersEntityPage);
    }

    public List<OrdersEntity> findByFilters(int status,
                                            LocalDateTime startDate, LocalDateTime endDate, BigDecimal total) {
        return ordersRepository.findByFilters(status, startDate, endDate, total);
    }

}
