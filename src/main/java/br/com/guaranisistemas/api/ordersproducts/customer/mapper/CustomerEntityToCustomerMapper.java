package br.com.guaranisistemas.api.ordersproducts.customer.mapper;

import br.com.guaranisistemas.api.ordersproducts.common.model.mapper.BaseMapper;
import br.com.guaranisistemas.api.ordersproducts.customer.model.Customer;
import br.com.guaranisistemas.api.ordersproducts.customer.model.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper interface named {@link CustomerEntityToCustomerMapper} for converting {@link CustomerEntity} to {@link Customer}.
 */
@Mapper
public interface CustomerEntityToCustomerMapper extends BaseMapper<CustomerEntity, Customer> {

    /**
     * Maps CustomerEntity to Customer.
     *
     * @param source The CustomerEntity object to map.
     * @return Customer object containing mapped data.
     */
    @Override
    Customer map(CustomerEntity source);

    /**
     * Initializes and returns an instance of CustomerEntityToCustomerMapper.
     *
     * @return Initialized CustomerEntityToCustomerMapper instance.
     */
    static CustomerEntityToCustomerMapper initialize() {
        return Mappers.getMapper(CustomerEntityToCustomerMapper.class);
    }

}
