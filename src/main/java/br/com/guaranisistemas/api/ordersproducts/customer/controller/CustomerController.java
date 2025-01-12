package br.com.guaranisistemas.api.ordersproducts.customer.controller;

import br.com.guaranisistemas.api.ordersproducts.common.model.CustomPage;
import br.com.guaranisistemas.api.ordersproducts.common.model.dto.response.CustomPagingResponse;
import br.com.guaranisistemas.api.ordersproducts.common.model.dto.response.CustomResponse;
import br.com.guaranisistemas.api.ordersproducts.customer.mapper.CustomPageToCustomPagingResponseMapper;
import br.com.guaranisistemas.api.ordersproducts.customer.mapper.CustomerToCustomerResponseMapper;
import br.com.guaranisistemas.api.ordersproducts.customer.model.Customer;
import br.com.guaranisistemas.api.ordersproducts.customer.model.dto.request.CustomerCreateRequest;
import br.com.guaranisistemas.api.ordersproducts.customer.model.dto.request.CustomerPagingRequest;
import br.com.guaranisistemas.api.ordersproducts.customer.model.dto.request.CustomerUpdateRequest;
import br.com.guaranisistemas.api.ordersproducts.customer.model.dto.response.CustomerResponse;
import br.com.guaranisistemas.api.ordersproducts.customer.service.CustomerCreateService;
import br.com.guaranisistemas.api.ordersproducts.customer.service.CustomerDeleteService;
import br.com.guaranisistemas.api.ordersproducts.customer.service.CustomerReadService;
import br.com.guaranisistemas.api.ordersproducts.customer.service.CustomerUpdateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.UUID;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class named {@link CustomerController} for handling customer-related CRUD operations.
 * Exposes endpoints under "/api/v1/customers".
 */
@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
@Validated
public class CustomerController {

    private final CustomerCreateService customerCreateService;
    private final CustomerReadService customerReadService;
    private final CustomerUpdateService customerUpdateService;
    private final CustomerDeleteService customerDeleteService;

    private final CustomerToCustomerResponseMapper customerToCustomerResponseMapper = CustomerToCustomerResponseMapper.initialize();

    private final CustomPageToCustomPagingResponseMapper customPageToCustomPagingResponseMapper =
            CustomPageToCustomPagingResponseMapper.initialize();

    /**
     * Creates a new Customer.
     *
     * @param customerCreateRequest the request body containing Customer creation details
     * @return a CustomResponse with the ID of the created customer upon successful creation
     */
    @PostMapping
    public CustomResponse<String> createCustomer(@RequestBody @Valid final CustomerCreateRequest customerCreateRequest) {

        final Customer createdCustomer = customerCreateService
                .createCustomer(customerCreateRequest);

        return CustomResponse.successOf(createdCustomer.getId());
    }

    /**
     * Retrieves a Customer by its ID.
     *
     * @param customerId the ID of the Customer to retrieve
     * @return a CustomResponse containing the Customer details
     */
    @GetMapping("/{customerId}")
    public CustomResponse<CustomerResponse> getCustomerById(@PathVariable @UUID final String customerId) {

        final Customer customer = customerReadService.getCustomerById(customerId);
        final CustomerResponse customerResponse = customerToCustomerResponseMapper.map(customer);
        return CustomResponse.successOf(customerResponse);
    }

    /**
     * Retrieves a list of Customer based on pagination criteria.
     *
     * @param customerPagingRequest the request body containing pagination parameters
     * @return a CustomResponse with paginated Customer details
     */
    @GetMapping
    public CustomResponse<CustomPagingResponse<CustomerResponse>> getCustomers(
            @RequestBody @Valid final CustomerPagingRequest customerPagingRequest) {

        final CustomPage<Customer> customerPage = customerReadService.getCustomer(customerPagingRequest);

        final CustomPagingResponse<CustomerResponse> customerPagingResponse =
                customPageToCustomPagingResponseMapper.toPagingResponse(customerPage);

        return CustomResponse.successOf(customerPagingResponse);
    }

    /**
     * Updates an existing Customer by its ID.
     *
     * @param customerUpdateRequest the request body containing updated Customer details
     * @param customerId            the ID of the Customer to update
     * @return a CustomResponse with updated Customer details
     */
    @PutMapping("/{customerId}")
    public CustomResponse<CustomerResponse> updatedCustomerById(
            @RequestBody @Valid final CustomerUpdateRequest customerUpdateRequest,
            @PathVariable @UUID final String customerId) {

        final Customer updatedCustomer = customerUpdateService.updateCustomerById(customerId, customerUpdateRequest);

        final CustomerResponse customerResponse = customerToCustomerResponseMapper.map(updatedCustomer);

        return CustomResponse.successOf(customerResponse);
    }

    /**
     * Deletes a Customer by its ID.
     *
     * @param customerId the ID of the Customer to delete
     * @return a CustomResponse indicating the success of the deletion operation
     */
    @DeleteMapping("/{customerId}")
    public CustomResponse<Void> deleteCustomerById(@PathVariable @UUID final String customerId) {

        customerDeleteService.deleteCustomerById(customerId);
        return CustomResponse.SUCCESS;
    }

}
