package br.com.guaranisistemas.api.ordersproducts.customer.service.impl;

import br.com.guaranisistemas.api.ordersproducts.customer.exception.CustomerNotFoundException;
import br.com.guaranisistemas.api.ordersproducts.customer.model.entity.CustomerEntity;
import br.com.guaranisistemas.api.ordersproducts.customer.repository.CustomerRepository;
import br.com.guaranisistemas.api.ordersproducts.customer.service.CustomerDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service implementation named {@link CustomerDeleteServiceImpl} for deleting customers.
 */
@Service
@RequiredArgsConstructor
public class CustomerDeleteServiceImpl implements CustomerDeleteService {

    private final CustomerRepository customerRepository;

    /**
     * Deletes a customer identified by its unique ID.
     *
     * @param customerId The ID of the customer to delete.
     * @throws CustomerNotFoundException If no customer with the given ID exists.
     */
    @Override
    public void deleteCustomerById(String customerId) {

        final CustomerEntity customerEntityToBeDelete = customerRepository
                .findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("With given customerID = " + customerId));

        customerRepository.delete(customerEntityToBeDelete);

    }

}
