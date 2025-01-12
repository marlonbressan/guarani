package br.com.guaranisistemas.api.ordersproducts.customer.repository;

import br.com.guaranisistemas.api.ordersproducts.customer.model.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface named {@link CustomerRepository} for managing CustomerEntity objects in the database.
 */
public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {

    /**
     * Checks if a Customer entity with the given name exists in the database.
     *
     * @param name the name of the Customer to check for existence
     * @return true if a Customer entity with the given name exists, false otherwise
     */
    boolean existsCustomerEntityByName(final String name);

}
