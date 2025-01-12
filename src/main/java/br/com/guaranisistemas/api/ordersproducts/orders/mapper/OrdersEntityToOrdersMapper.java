package br.com.guaranisistemas.api.ordersproducts.orders.mapper;

import br.com.guaranisistemas.api.ordersproducts.common.model.mapper.BaseMapper;
import br.com.guaranisistemas.api.ordersproducts.orders.model.Orders;
import br.com.guaranisistemas.api.ordersproducts.orders.model.entity.OrdersEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper interface named {@link OrdersEntityToOrdersMapper} for converting {@link OrdersEntity} to {@link Orders}.
 */
@Mapper
public interface OrdersEntityToOrdersMapper extends BaseMapper<OrdersEntity, Orders> {

    /**
     * Maps OrdersEntity to Orders.
     *
     * @param source The OrdersEntity object to map.
     * @return Orders object containing mapped data.
     */
    @Override
    Orders map(OrdersEntity source);

    /**
     * Initializes and returns an instance of OrdersEntityToOrdersMapper.
     *
     * @return Initialized OrdersEntityToOrdersMapper instance.
     */
    static OrdersEntityToOrdersMapper initialize() {
        return Mappers.getMapper(OrdersEntityToOrdersMapper.class);
    }

}
