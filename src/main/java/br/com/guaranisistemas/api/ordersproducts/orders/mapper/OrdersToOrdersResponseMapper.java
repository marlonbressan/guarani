package br.com.guaranisistemas.api.ordersproducts.orders.mapper;

import br.com.guaranisistemas.api.ordersproducts.common.model.mapper.BaseMapper;
import br.com.guaranisistemas.api.ordersproducts.orders.model.Orders;
import br.com.guaranisistemas.api.ordersproducts.orders.model.dto.response.OrdersResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper interface named {@link OrdersToOrdersResponseMapper} for converting {@link Orders} to {@link OrdersResponse}.
 */
@Mapper
public interface OrdersToOrdersResponseMapper extends BaseMapper<Orders, OrdersResponse> {

    /**
     * Maps Orders to OrdersResponse.
     *
     * @param source The Orders object to map.
     * @return OrdersResponse object containing mapped data.
     */
    @Override
    OrdersResponse map(Orders source);

    /**
     * Initializes and returns an instance of OrdersToOrdersResponseMapper.
     *
     * @return Initialized OrdersToOrdersResponseMapper instance.
     */
    static OrdersToOrdersResponseMapper initialize() {
        return Mappers.getMapper(OrdersToOrdersResponseMapper.class);
    }

}
