package br.com.guaranisistemas.api.ordersproducts.orders.service.impl;

import br.com.guaranisistemas.api.ordersproducts.orders.exception.OrdersAlreadyExistException;
import br.com.guaranisistemas.api.ordersproducts.orders.exception.OrdersNotFoundException;
import br.com.guaranisistemas.api.ordersproducts.orders.mapper.OrdersEntityToOrdersMapper;
import br.com.guaranisistemas.api.ordersproducts.orders.mapper.OrdersUpdateRequestToOrdersEntityMapper;
import br.com.guaranisistemas.api.ordersproducts.orders.model.Orders;
import br.com.guaranisistemas.api.ordersproducts.orders.model.dto.request.OrdersUpdateRequest;
import br.com.guaranisistemas.api.ordersproducts.orders.model.entity.OrdersEntity;
import br.com.guaranisistemas.api.ordersproducts.orders.repository.OrdersRepository;
import br.com.guaranisistemas.api.ordersproducts.orders.service.OrdersUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service implementation named {@link OrdersUpdateServiceImpl} for updating orderss.
 */
@Service
@RequiredArgsConstructor
public class OrdersUpdateServiceImpl implements OrdersUpdateService {

    private final OrdersRepository ordersRepository;

    private final OrdersUpdateRequestToOrdersEntityMapper ordersUpdateRequestToOrdersEntityMapper =
            OrdersUpdateRequestToOrdersEntityMapper.initialize();

    private final OrdersEntityToOrdersMapper ordersEntityToOrdersMapper =
            OrdersEntityToOrdersMapper.initialize();

    /**
     * Updates a orders identified by its unique ID using the provided update request.
     *
     * @param ordersId            The ID of the orders to update.
     * @param ordersUpdateRequest The request containing updated data for the orders.
     * @return The updated Orders object.
     * @throws OrdersNotFoundException     If no orders with the given ID exists.
     * @throws OrdersAlreadyExistException If another orders with the updated name already exists.
     */
    @Override
    public Orders updateOrdersById(String ordersId, OrdersUpdateRequest ordersUpdateRequest) {

        //checkOrdersNameUniqueness(ordersUpdateRequest.getName());

        final OrdersEntity ordersEntityToBeUpdate = ordersRepository
                .findById(ordersId)
                .orElseThrow(() -> new OrdersNotFoundException("With given ordersID = " + ordersId));

        ordersUpdateRequestToOrdersEntityMapper.mapForUpdating(ordersEntityToBeUpdate, ordersUpdateRequest);

        OrdersEntity updatedOrdersEntity = ordersRepository.save(ordersEntityToBeUpdate);

        return ordersEntityToOrdersMapper.map(updatedOrdersEntity);

    }

    /**
     * Checks if a orders with the updated name already exists in the repository.
     *
     * @param ordersName The updated name of the orders to check.
     * @throws OrdersAlreadyExistException If another orders with the updated name already exists.
     */
    /*private void checkOrdersNameUniqueness(final String ordersName) {
        if (ordersRepository.existsOrdersEntityByName(ordersName)) {
            throw new OrdersAlreadyExistException("With given orders name = " + ordersName);
        }
    }*/

}
