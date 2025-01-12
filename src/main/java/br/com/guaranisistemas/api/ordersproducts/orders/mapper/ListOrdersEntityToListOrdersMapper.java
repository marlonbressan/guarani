package br.com.guaranisistemas.api.ordersproducts.orders.mapper;

import br.com.guaranisistemas.api.ordersproducts.orders.model.Orders;
import br.com.guaranisistemas.api.ordersproducts.orders.model.entity.OrdersEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper interface named {@link ListOrdersEntityToListOrdersMapper} for converting {@link List<OrdersEntity>} to {@link List<Orders>}.
 */
@Mapper
public interface ListOrdersEntityToListOrdersMapper {

    OrdersEntityToOrdersMapper ordersEntityToOrdersMapper = Mappers.getMapper(OrdersEntityToOrdersMapper.class);

    /**
     * Converts a list of OrdersEntity objects to a list of Orders objects.
     *
     * @param ordersEntities The list of OrdersEntity objects to convert.
     * @return List of Orders objects containing mapped data.
     */
    default List<Orders> toOrdersList(List<OrdersEntity> ordersEntities) {

        if (ordersEntities == null) {
            return null;
        }

        return ordersEntities.stream()
                .map(ordersEntityToOrdersMapper::map)
                .collect(Collectors.toList());

    }

    /**
     * Initializes and returns an instance of ListOrdersEntityToListOrdersMapper.
     *
     * @return Initialized ListOrdersEntityToListOrdersMapper instance.
     */
    static ListOrdersEntityToListOrdersMapper initialize() {
        return Mappers.getMapper(ListOrdersEntityToListOrdersMapper.class);
    }

}
