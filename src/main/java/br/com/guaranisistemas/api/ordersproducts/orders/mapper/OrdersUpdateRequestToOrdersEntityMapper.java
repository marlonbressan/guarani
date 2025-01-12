package br.com.guaranisistemas.api.ordersproducts.orders.mapper;

import br.com.guaranisistemas.api.ordersproducts.common.model.mapper.BaseMapper;
import br.com.guaranisistemas.api.ordersproducts.customer.model.entity.CustomerEntity;
import br.com.guaranisistemas.api.ordersproducts.orders.model.dto.request.OrdersUpdateRequest;
import br.com.guaranisistemas.api.ordersproducts.orders.model.entity.OrderDetailEntity;
import br.com.guaranisistemas.api.ordersproducts.orders.model.entity.OrdersEntity;
import br.com.guaranisistemas.api.ordersproducts.payment.model.entity.TypePaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

import static br.com.guaranisistemas.api.ordersproducts.orders.mapper.OrdersCreateRequestToOrdersEntityMapper.convertToEntity;

/**
 * Mapper interface named {@link OrdersUpdateRequestToOrdersEntityMapper} for updating {@link OrdersEntity} using {@link OrdersUpdateRequest}.
 */
@Mapper
public interface OrdersUpdateRequestToOrdersEntityMapper extends BaseMapper<OrdersUpdateRequest, OrdersEntity> {

    /**
     * Maps fields from OrdersUpdateRequest to update OrdersEntity.
     *
     * @param ordersEntityToBeUpdate The OrdersEntity object to be updated.
     * @param ordersUpdateRequest    The OrdersUpdateRequest object containing updated fields.
     */
    @Named("mapForUpdating")
    default void mapForUpdating(OrdersEntity ordersEntityToBeUpdate, OrdersUpdateRequest ordersUpdateRequest) {
        ordersEntityToBeUpdate.setCustomer(CustomerEntity.builder().id(ordersUpdateRequest.getCustomerId()).build());
        ordersEntityToBeUpdate.setPayment(TypePaymentEntity.builder().id(ordersUpdateRequest.getPaymentId()).build());
        ordersEntityToBeUpdate.setFreight(ordersUpdateRequest.getFreight());
        ordersEntityToBeUpdate.setDiscount(ordersUpdateRequest.getDiscount());

        List<OrderDetailEntity> ordersDet = new ArrayList<>();
        ordersUpdateRequest.getItems().forEach(item -> ordersDet.add(convertToEntity(item)));

        ordersEntityToBeUpdate.setItems(ordersDet);
        ordersEntityToBeUpdate.setStatus(ordersUpdateRequest.getStatusId());
    }

    /**
     * Initializes and returns an instance of OrdersUpdateRequestToOrdersEntityMapper.
     *
     * @return Initialized OrdersUpdateRequestToOrdersEntityMapper instance.
     */
    static OrdersUpdateRequestToOrdersEntityMapper initialize() {
        return Mappers.getMapper(OrdersUpdateRequestToOrdersEntityMapper.class);
    }

}
