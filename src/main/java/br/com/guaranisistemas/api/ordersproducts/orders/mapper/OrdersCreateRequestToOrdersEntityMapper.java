package br.com.guaranisistemas.api.ordersproducts.orders.mapper;

import br.com.guaranisistemas.api.ordersproducts.common.model.mapper.BaseMapper;
import br.com.guaranisistemas.api.ordersproducts.customer.model.entity.CustomerEntity;
import br.com.guaranisistemas.api.ordersproducts.orders.model.dto.request.OrdersCreateRequest;
import br.com.guaranisistemas.api.ordersproducts.orders.model.dto.request.OrdersDetailsCreateRequest;
import br.com.guaranisistemas.api.ordersproducts.orders.model.entity.OrderDetailEntity;
import br.com.guaranisistemas.api.ordersproducts.orders.model.entity.OrdersEntity;
import br.com.guaranisistemas.api.ordersproducts.payment.model.entity.TypePaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

/**
 * Mapper interface named {@link OrdersCreateRequestToOrdersEntityMapper} for converting {@link OrdersCreateRequest} to {@link OrdersEntity}.
 */
@Mapper
public interface OrdersCreateRequestToOrdersEntityMapper extends BaseMapper<OrdersCreateRequest, OrdersEntity> {

    /**
     * Maps OrdersCreateRequest to OrdersEntity for saving purposes.
     *
     * @param ordersCreateRequest The OrdersCreateRequest object to map.
     * @return OrdersEntity object containing mapped data.
     */
    @Named("mapForSaving")
    default OrdersEntity mapForSaving(OrdersCreateRequest ordersCreateRequest) {

        List<OrderDetailEntity> ordersDet = new ArrayList<>();
        ordersCreateRequest.getItems().forEach(item -> ordersDet.add(convertToEntity(item)));

        return OrdersEntity.builder()
                .customer(CustomerEntity.builder().id(ordersCreateRequest.getCustomerId()).build())
                .payment(TypePaymentEntity.builder().id(ordersCreateRequest.getPaymentId()).build())
                .items(ordersDet)
                .discount(ordersCreateRequest.getDiscount())
                .freight(ordersCreateRequest.getFreight())
                .build();
    }

    static OrderDetailEntity convertToEntity(OrdersDetailsCreateRequest item){
        OrderDetailEntity result = new OrderDetailEntity();
        if (item != null) {
            result.setId(item.getOrderId());
            result.getProduct().setId(item.getProductId());
            result.setPrice(item.getPrice());
            result.setQuantity(item.getQuantity());
        }
        return result;
    }

    /**
     * Initializes and returns an instance of OrdersCreateRequestToOrdersEntityMapper.
     *
     * @return Initialized OrdersCreateRequestToOrdersEntityMapper instance.
     */
    static OrdersCreateRequestToOrdersEntityMapper initialize() {
        return Mappers.getMapper(OrdersCreateRequestToOrdersEntityMapper.class);
    }
}
