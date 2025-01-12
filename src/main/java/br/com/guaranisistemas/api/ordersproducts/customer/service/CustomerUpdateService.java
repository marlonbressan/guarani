package br.com.guaranisistemas.api.ordersproducts.customer.service;

import br.com.guaranisistemas.api.ordersproducts.customer.model.Customer;
import br.com.guaranisistemas.api.ordersproducts.customer.model.dto.request.CustomerUpdateRequest;

/**
 * Service interface named {@link CustomerUpdateService} for updating Customer.
 */
public interface CustomerUpdateService {

    /**
     * Updates a Customer identified by its unique ID using the provided update request.
     *
     * @param customerId            The ID of the Customer to update.
     * @param customerUpdateRequest The request containing updated data for the Customer.
     * @return The updated Customer object.
     */
    Customer updateCustomerById(final String customerId, final CustomerUpdateRequest customerUpdateRequest);

}
