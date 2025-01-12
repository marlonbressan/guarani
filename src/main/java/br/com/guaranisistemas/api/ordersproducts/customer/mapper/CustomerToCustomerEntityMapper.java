package br.com.guaranisistemas.api.ordersproducts.customer.mapper;

import br.com.guaranisistemas.api.ordersproducts.common.model.mapper.BaseMapper;
import br.com.guaranisistemas.api.ordersproducts.customer.model.Customer;
import br.com.guaranisistemas.api.ordersproducts.customer.model.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper interface named {@link CustomerToCustomerEntityMapper} for converting {@link Customer} to {@link CustomerEntity}.
 */
@Mapper
public interface CustomerToCustomerEntityMapper extends BaseMapper<Customer, CustomerEntity> {

    /**
     * Maps Customer to CustomerEntity.
     *
     * @param source The Customer object to map.
     * @return CustomerEntity object containing mapped data.
     */
    @Override
    CustomerEntity map(Customer source);

    /**
     * Initializes and returns an instance of CustomerToCustomerEntityMapper.
     *
     * @return Initialized CustomerToCustomerEntityMapper instance.
     */
    static CustomerToCustomerEntityMapper initialize() {
        return Mappers.getMapper(CustomerToCustomerEntityMapper.class);
    }

}
