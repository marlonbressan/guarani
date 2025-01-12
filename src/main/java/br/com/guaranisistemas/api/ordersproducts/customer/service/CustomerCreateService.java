package br.com.guaranisistemas.api.ordersproducts.customer.service;

import br.com.guaranisistemas.api.ordersproducts.customer.model.Customer;
import br.com.guaranisistemas.api.ordersproducts.customer.model.dto.request.CustomerCreateRequest;

/**
 * Service interface named {@link CustomerCreateService} for creating customers.
 */
public interface CustomerCreateService {

    /**
     * Creates a new Customer based on the provided Customer creation request.
     *
     * @param customerCreateRequest The request containing data to create the Customer.
     * @return The created Product object.
     */
    Customer createCustomer(final CustomerCreateRequest customerCreateRequest);

}
