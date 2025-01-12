package br.com.guaranisistemas.api.ordersproducts.customer.mapper;

import br.com.guaranisistemas.api.ordersproducts.common.model.mapper.BaseMapper;
import br.com.guaranisistemas.api.ordersproducts.customer.model.dto.request.CustomerUpdateRequest;
import br.com.guaranisistemas.api.ordersproducts.customer.model.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

/**
 * Mapper interface named {@link CustomerUpdateRequestToCustomerEntityMapper} for updating {@link CustomerEntity} using {@link CustomerUpdateRequest}.
 */
@Mapper
public interface CustomerUpdateRequestToCustomerEntityMapper extends BaseMapper<CustomerUpdateRequest, CustomerEntity> {

    /**
     * Maps fields from CustomerUpdateRequest to update CustomerEntity.
     *
     * @param customerEntityToBeUpdate The CustomerEntity object to be updated.
     * @param customerUpdateRequest    The CustomerUpdateRequest object containing updated fields.
     */
    @Named("mapForUpdating")
    default void mapForUpdating(CustomerEntity customerEntityToBeUpdate, CustomerUpdateRequest customerUpdateRequest) {
        customerEntityToBeUpdate.setName(customerUpdateRequest.getName());
        customerEntityToBeUpdate.setEndereco(customerUpdateRequest.getEndereco());
    }

    /**
     * Initializes and returns an instance of CustomerUpdateRequestToCustomerEntityMapper.
     *
     * @return Initialized CustomerUpdateRequestToCustomerEntityMapper instance.
     */
    static CustomerUpdateRequestToCustomerEntityMapper initialize() {
        return Mappers.getMapper(CustomerUpdateRequestToCustomerEntityMapper.class);
    }

}
