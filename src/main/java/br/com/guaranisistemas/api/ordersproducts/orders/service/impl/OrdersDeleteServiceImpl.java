package br.com.guaranisistemas.api.ordersproducts.orders.service.impl;

import br.com.guaranisistemas.api.ordersproducts.orders.exception.OrdersNotFoundException;
import br.com.guaranisistemas.api.ordersproducts.orders.model.entity.OrdersEntity;
import br.com.guaranisistemas.api.ordersproducts.orders.repository.OrdersRepository;
import br.com.guaranisistemas.api.ordersproducts.orders.service.OrdersDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service implementation named {@link OrdersDeleteServiceImpl} for deleting orderss.
 */
@Service
@RequiredArgsConstructor
public class OrdersDeleteServiceImpl implements OrdersDeleteService {

    private final OrdersRepository ordersRepository;

    /**
     * Deletes a orders identified by its unique ID.
     *
     * @param ordersId The ID of the orders to delete.
     * @throws OrdersNotFoundException If no orders with the given ID exists.
     */
    @Override
    public void deleteOrdersById(String ordersId) {

        final OrdersEntity ordersEntityToBeDelete = ordersRepository
                .findById(ordersId)
                .orElseThrow(() -> new OrdersNotFoundException("With given ordersID = " + ordersId));

        ordersRepository.delete(ordersEntityToBeDelete);

    }

}
