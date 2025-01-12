package br.com.guaranisistemas.api.ordersproducts.customer.service;

/**
 * Service interface named {@link CustomerDeleteService} for deleting Customer.
 */
public interface CustomerDeleteService {

    /**
     * Deletes a Customer identified by its unique ID.
     *
     * @param customerId The ID of the Customer to delete.
     */
    void deleteCustomerById(final String customerId);

}
