package br.com.guaranisistemas.api.ordersproducts.orders.mapper;

import br.com.guaranisistemas.api.ordersproducts.common.model.CustomPage;
import br.com.guaranisistemas.api.ordersproducts.common.model.dto.response.CustomPagingResponse;
import br.com.guaranisistemas.api.ordersproducts.orders.model.Orders;
import br.com.guaranisistemas.api.ordersproducts.orders.model.dto.response.OrdersResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper interface named {@link CustomPageToCustomPagingResponseMapper} for converting {@link CustomPage<Orders>} to {@link CustomPagingResponse<OrdersResponse>}.
 */
@Mapper
public interface CustomPageToCustomPagingResponseMapper {

    OrdersToOrdersResponseMapper ordersToOrdersResponseMapper = Mappers.getMapper(OrdersToOrdersResponseMapper.class);

    /**
     * Converts a CustomPage<Orders> object to CustomPagingResponse<OrdersResponse>.
     *
     * @param ordersPage The CustomPage<Orders> object to convert.
     * @return CustomPagingResponse<OrdersResponse> object containing mapped data.
     */
    default CustomPagingResponse<OrdersResponse> toPagingResponse(CustomPage<Orders> ordersPage) {

        if (ordersPage == null) {
            return null;
        }

        return CustomPagingResponse.<OrdersResponse>builder()
                .content(toOrdersResponseList(ordersPage.getContent()))
                .totalElementCount(ordersPage.getTotalElementCount())
                .totalPageCount(ordersPage.getTotalPageCount())
                .pageNumber(ordersPage.getPageNumber())
                .pageSize(ordersPage.getPageSize())
                .build();

    }

    /**
     * Converts a list of Orders objects to a list of OrdersResponse objects.
     *
     * @param orderss The list of Orders objects to convert.
     * @return List of OrdersResponse objects containing mapped data.
     */
    default List<OrdersResponse> toOrdersResponseList(List<Orders> orderss) {

        if (orderss == null) {
            return null;
        }

        return orderss.stream()
                .map(ordersToOrdersResponseMapper::map)
                .collect(Collectors.toList());

    }

    /**
     * Initializes and returns an instance of CustomPageToCustomPagingResponseMapper.
     *
     * @return Initialized CustomPageToCustomPagingResponseMapper instance.
     */
    static CustomPageToCustomPagingResponseMapper initialize() {
        return Mappers.getMapper(CustomPageToCustomPagingResponseMapper.class);
    }

}
