package br.com.guaranisistemas.api.ordersproducts.customer.service.impl;

import br.com.guaranisistemas.api.ordersproducts.customer.exception.CustomerAlreadyExistException;
import br.com.guaranisistemas.api.ordersproducts.customer.exception.CustomerNotFoundException;
import br.com.guaranisistemas.api.ordersproducts.customer.mapper.CustomerEntityToCustomerMapper;
import br.com.guaranisistemas.api.ordersproducts.customer.mapper.CustomerUpdateRequestToCustomerEntityMapper;
import br.com.guaranisistemas.api.ordersproducts.customer.model.Customer;
import br.com.guaranisistemas.api.ordersproducts.customer.model.dto.request.CustomerUpdateRequest;
import br.com.guaranisistemas.api.ordersproducts.customer.model.entity.CustomerEntity;
import br.com.guaranisistemas.api.ordersproducts.customer.repository.CustomerRepository;
import br.com.guaranisistemas.api.ordersproducts.customer.service.CustomerUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service implementation named {@link CustomerUpdateServiceImpl} for updating customers.
 */
@Service
@RequiredArgsConstructor
public class CustomerUpdateServiceImpl implements CustomerUpdateService {

    private final CustomerRepository customerRepository;

    private final CustomerUpdateRequestToCustomerEntityMapper customerUpdateRequestToCustomerEntityMapper =
            CustomerUpdateRequestToCustomerEntityMapper.initialize();

    private final CustomerEntityToCustomerMapper customerEntityToCustomerMapper =
            CustomerEntityToCustomerMapper.initialize();

    /**
     * Updates a customer identified by its unique ID using the provided update request.
     *
     * @param customerId            The ID of the customer to update.
     * @param customerUpdateRequest The request containing updated data for the customer.
     * @return The updated Customer object.
     * @throws CustomerNotFoundException     If no customer with the given ID exists.
     * @throws CustomerAlreadyExistException If another customer with the updated name already exists.
     */
    @Override
    public Customer updateCustomerById(String customerId, CustomerUpdateRequest customerUpdateRequest) {

        checkCustomerNameUniqueness(customerUpdateRequest.getName());

        final CustomerEntity customerEntityToBeUpdate = customerRepository
                .findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("With given customerID = " + customerId));

        customerUpdateRequestToCustomerEntityMapper.mapForUpdating(customerEntityToBeUpdate, customerUpdateRequest);

        CustomerEntity updatedCustomerEntity = customerRepository.save(customerEntityToBeUpdate);

        return customerEntityToCustomerMapper.map(updatedCustomerEntity);

    }

    /**
     * Checks if a customer with the updated name already exists in the repository.
     *
     * @param customerName The updated name of the customer to check.
     * @throws CustomerAlreadyExistException If another customer with the updated name already exists.
     */
    private void checkCustomerNameUniqueness(final String customerName) {
        if (customerRepository.existsCustomerEntityByName(customerName)) {
            throw new CustomerAlreadyExistException("With given customer name = " + customerName);
        }
    }

}
