package br.com.guaranisistemas.api.ordersproducts.orders.mapper;

import br.com.guaranisistemas.api.ordersproducts.common.model.mapper.BaseMapper;
import br.com.guaranisistemas.api.ordersproducts.orders.model.Orders;
import br.com.guaranisistemas.api.ordersproducts.orders.model.entity.OrdersEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper interface named {@link OrdersToOrdersEntityMapper} for converting {@link Orders} to {@link OrdersEntity}.
 */
@Mapper
public interface OrdersToOrdersEntityMapper extends BaseMapper<Orders, OrdersEntity> {

    /**
     * Maps Orders to OrdersEntity.
     *
     * @param source The Orders object to map.
     * @return OrdersEntity object containing mapped data.
     */
    @Override
    OrdersEntity map(Orders source);

    /**
     * Initializes and returns an instance of OrdersToOrdersEntityMapper.
     *
     * @return Initialized OrdersToOrdersEntityMapper instance.
     */
    static OrdersToOrdersEntityMapper initialize() {
        return Mappers.getMapper(OrdersToOrdersEntityMapper.class);
    }

}
