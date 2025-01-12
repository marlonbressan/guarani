package br.com.guaranisistemas.api.ordersproducts.customer.mapper;

import br.com.guaranisistemas.api.ordersproducts.common.model.mapper.BaseMapper;
import br.com.guaranisistemas.api.ordersproducts.customer.model.dto.request.CustomerCreateRequest;
import br.com.guaranisistemas.api.ordersproducts.customer.model.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

/**
 * Mapper interface named {@link CustomerCreateRequestToCustomerEntityMapper} for converting {@link CustomerCreateRequest} to {@link CustomerEntity}.
 */
@Mapper
public interface CustomerCreateRequestToCustomerEntityMapper extends BaseMapper<CustomerCreateRequest, CustomerEntity> {

    /**
     * Maps CustomerCreateRequest to CustomerEntity for saving purposes.
     *
     * @param customerCreateRequest The CustomerCreateRequest object to map.
     * @return CustomerEntity object containing mapped data.
     */
    @Named("mapForSaving")
    default CustomerEntity mapForSaving(CustomerCreateRequest customerCreateRequest) {
        return CustomerEntity.builder()
                .name(customerCreateRequest.getName())
                .endereco(customerCreateRequest.getEndereco())
                .build();
    }

    /**
     * Initializes and returns an instance of CustomerCreateRequestToCustomerEntityMapper.
     *
     * @return Initialized CustomerCreateRequestToCustomerEntityMapper instance.
     */
    static CustomerCreateRequestToCustomerEntityMapper initialize() {
        return Mappers.getMapper(CustomerCreateRequestToCustomerEntityMapper.class);
    }

}
