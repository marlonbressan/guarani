package br.com.guaranisistemas.api.ordersproducts.customer.service.impl;

import br.com.guaranisistemas.api.ordersproducts.customer.exception.CustomerAlreadyExistException;
import br.com.guaranisistemas.api.ordersproducts.customer.mapper.CustomerCreateRequestToCustomerEntityMapper;
import br.com.guaranisistemas.api.ordersproducts.customer.mapper.CustomerEntityToCustomerMapper;
import br.com.guaranisistemas.api.ordersproducts.customer.model.Customer;
import br.com.guaranisistemas.api.ordersproducts.customer.model.dto.request.CustomerCreateRequest;
import br.com.guaranisistemas.api.ordersproducts.customer.model.entity.CustomerEntity;
import br.com.guaranisistemas.api.ordersproducts.customer.repository.CustomerRepository;
import br.com.guaranisistemas.api.ordersproducts.customer.service.CustomerCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service implementation named {@link CustomerCreateServiceImpl} for creating customers.
 */
@Service
@RequiredArgsConstructor
public class CustomerCreateServiceImpl implements CustomerCreateService {

    private final CustomerRepository customerRepository;

    private final CustomerCreateRequestToCustomerEntityMapper customerCreateRequestToCustomerEntityMapper =
            CustomerCreateRequestToCustomerEntityMapper.initialize();

    private final CustomerEntityToCustomerMapper customerEntityToCustomerMapper = CustomerEntityToCustomerMapper.initialize();

    /**
     * Creates a new customer based on the provided customer creation request.
     *
     * @param customerCreateRequest The request containing data to create the customer.
     * @return The created Customer object.
     * @throws CustomerAlreadyExistException If a customer with the same name already exists.
     */
    @Override
    public Customer createCustomer(CustomerCreateRequest customerCreateRequest) {

        checkUniquenessCustomerName(customerCreateRequest.getName());

        final CustomerEntity customerEntityToBeSave = customerCreateRequestToCustomerEntityMapper.mapForSaving(customerCreateRequest);

        CustomerEntity savedCustomerEntity = customerRepository.save(customerEntityToBeSave);

        return customerEntityToCustomerMapper.map(savedCustomerEntity);

    }

    /**
     * Checks if a customer with the given name already exists in the repository.
     *
     * @param customerName The name of the customer to check.
     * @throws CustomerAlreadyExistException If a customer with the same name already exists.
     */
    private void checkUniquenessCustomerName(final String customerName) {
        if (customerRepository.existsCustomerEntityByName(customerName)) {
            throw new CustomerAlreadyExistException("There is another customer with given name: " + customerName);
        }
    }

}
