package br.com.guaranisistemas.api.ordersproducts.customer.service.impl;

import br.com.guaranisistemas.api.ordersproducts.common.model.CustomPage;
import br.com.guaranisistemas.api.ordersproducts.common.util.HelperPagination;
import br.com.guaranisistemas.api.ordersproducts.customer.exception.CustomerNotFoundException;
import br.com.guaranisistemas.api.ordersproducts.customer.mapper.CustomerEntityToCustomerMapper;
import br.com.guaranisistemas.api.ordersproducts.customer.mapper.ListCustomerEntityToListCustomerMapper;
import br.com.guaranisistemas.api.ordersproducts.customer.model.Customer;
import br.com.guaranisistemas.api.ordersproducts.customer.model.dto.request.CustomerPagingRequest;
import br.com.guaranisistemas.api.ordersproducts.customer.model.entity.CustomerEntity;
import br.com.guaranisistemas.api.ordersproducts.customer.repository.CustomerRepository;
import br.com.guaranisistemas.api.ordersproducts.customer.service.CustomerReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation named {@link CustomerReadServiceImpl} for reading customers.
 */
@Service
@RequiredArgsConstructor
public class CustomerReadServiceImpl implements CustomerReadService {

    private final CustomerRepository customerRepository;

    private final CustomerEntityToCustomerMapper customerEntityToCustomerMapper = CustomerEntityToCustomerMapper.initialize();

    private final ListCustomerEntityToListCustomerMapper listCustomerEntityToListCustomerMapper =
            ListCustomerEntityToListCustomerMapper.initialize();

    /**
     * Retrieves a customer by its unique ID.
     *
     * @param customerId The ID of the customer to retrieve.
     * @return The Customer object corresponding to the given ID.
     * @throws CustomerNotFoundException If no customer with the given ID exists.
     */
    @Override
    public Customer getCustomerById(String customerId) {

        final CustomerEntity customerEntityFromDB = customerRepository
                .findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("With given customerID = " + customerId));

        return customerEntityToCustomerMapper.map(customerEntityFromDB);
    }

    /**
     * Retrieves a page of customers based on the paging request criteria.
     *
     * @param customerPagingRequest The paging request criteria.
     * @return A CustomPage containing the list of customers that match the paging criteria.
     * @throws CustomerNotFoundException If no customers are found based on the paging criteria.
     */
    @Override
    public CustomPage<Customer> getCustomer(CustomerPagingRequest customerPagingRequest) {

        if (customerPagingRequest == null) {
            customerPagingRequest = HelperPagination.createCustomerDefaultPagination();
        }
        final Page<CustomerEntity> customerEntityPage = customerRepository.findAll(customerPagingRequest.toPageable());

        if (customerEntityPage.getContent().isEmpty()) {
            throw new CustomerNotFoundException("Couldn't find any Customer");
        }

        final List<Customer> customerDomainModels = listCustomerEntityToListCustomerMapper
                .toCustomerList(customerEntityPage.getContent());

        return CustomPage.of(customerDomainModels, customerEntityPage);
    }

}
