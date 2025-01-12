package br.com.guaranisistemas.api.ordersproducts.customer.service;

import br.com.guaranisistemas.api.ordersproducts.common.model.CustomPage;
import br.com.guaranisistemas.api.ordersproducts.customer.model.Customer;
import br.com.guaranisistemas.api.ordersproducts.customer.model.dto.request.CustomerPagingRequest;

/**
 * Service interface named {@link CustomerReadService} for reading Customer.
 */
public interface CustomerReadService {

    /**
     * Retrieves a Customer by its unique ID.
     *
     * @param customerId The ID of the Customer to retrieve.
     * @return The Customer object corresponding to the given ID.
     */
    Customer getCustomerById(final String customerId);

    /**
     * Retrieves a page of Customer based on the paging request criteria.
     *
     * @param customerPagingRequest The paging request criteria.
     * @return A CustomPage containing the list of Customer that match the paging criteria.
     */
    CustomPage<Customer> getCustomer(final CustomerPagingRequest customerPagingRequest);

}
