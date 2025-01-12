package br.com.guaranisistemas.api.ordersproducts.customer.mapper;

import br.com.guaranisistemas.api.ordersproducts.customer.model.Customer;
import br.com.guaranisistemas.api.ordersproducts.customer.model.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper interface named {@link ListCustomerEntityToListCustomerMapper} for converting {@link List<CustomerEntity>} to {@link List<Customer>}.
 */
@Mapper
public interface ListCustomerEntityToListCustomerMapper {

    CustomerEntityToCustomerMapper customerEntityToCustomerMapper = Mappers.getMapper(CustomerEntityToCustomerMapper.class);

    /**
     * Converts a list of CustomerEntity objects to a list of Customer objects.
     *
     * @param customerEntities The list of CustomerEntity objects to convert.
     * @return List of Customer objects containing mapped data.
     */
    default List<Customer> toCustomerList(List<CustomerEntity> customerEntities) {

        if (customerEntities == null) {
            return null;
        }

        return customerEntities.stream()
                .map(customerEntityToCustomerMapper::map)
                .collect(Collectors.toList());

    }

    /**
     * Initializes and returns an instance of ListCustomerEntityToListCustomerMapper.
     *
     * @return Initialized ListCustomerEntityToListCustomerMapper instance.
     */
    static ListCustomerEntityToListCustomerMapper initialize() {
        return Mappers.getMapper(ListCustomerEntityToListCustomerMapper.class);
    }

}
