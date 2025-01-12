package br.com.guaranisistemas.api.ordersproducts.customer.mapper;

import br.com.guaranisistemas.api.ordersproducts.common.model.mapper.BaseMapper;
import br.com.guaranisistemas.api.ordersproducts.customer.model.Customer;
import br.com.guaranisistemas.api.ordersproducts.customer.model.dto.response.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper interface named {@link CustomerToCustomerResponseMapper} for converting {@link Customer} to {@link CustomerResponse}.
 */
@Mapper
public interface CustomerToCustomerResponseMapper extends BaseMapper<Customer, CustomerResponse> {

    /**
     * Maps Customer to CustomerResponse.
     *
     * @param source The Customer object to map.
     * @return CustomerResponse object containing mapped data.
     */
    @Override
    CustomerResponse map(Customer source);

    /**
     * Initializes and returns an instance of CustomerToCustomerResponseMapper.
     *
     * @return Initialized CustomerToCustomerResponseMapper instance.
     */
    static CustomerToCustomerResponseMapper initialize() {
        return Mappers.getMapper(CustomerToCustomerResponseMapper.class);
    }

}
