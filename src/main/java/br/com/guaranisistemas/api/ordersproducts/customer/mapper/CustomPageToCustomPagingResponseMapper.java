package br.com.guaranisistemas.api.ordersproducts.customer.mapper;

import br.com.guaranisistemas.api.ordersproducts.common.model.CustomPage;
import br.com.guaranisistemas.api.ordersproducts.common.model.dto.response.CustomPagingResponse;
import br.com.guaranisistemas.api.ordersproducts.customer.model.Customer;
import br.com.guaranisistemas.api.ordersproducts.customer.model.dto.response.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper interface named {@link CustomPageToCustomPagingResponseMapper} for converting {@link CustomPage<Customer>} to {@link CustomPagingResponse<CustomerResponse>}.
 */
@Mapper
public interface CustomPageToCustomPagingResponseMapper {

    CustomerToCustomerResponseMapper customerToCustomerResponseMapper = Mappers.getMapper(CustomerToCustomerResponseMapper.class);

    /**
     * Converts a CustomPage<Customer> object to CustomPagingResponse<CustomerResponse>.
     *
     * @param customerPage The CustomPage<Customer> object to convert.
     * @return CustomPagingResponse<CustomerResponse> object containing mapped data.
     */
    default CustomPagingResponse<CustomerResponse> toPagingResponse(CustomPage<Customer> customerPage) {

        if (customerPage == null) {
            return null;
        }

        return CustomPagingResponse.<CustomerResponse>builder()
                .content(toCustomerResponseList(customerPage.getContent()))
                .totalElementCount(customerPage.getTotalElementCount())
                .totalPageCount(customerPage.getTotalPageCount())
                .pageNumber(customerPage.getPageNumber())
                .pageSize(customerPage.getPageSize())
                .build();

    }

    /**
     * Converts a list of customer objects to a list of customerResponse objects.
     *
     * @param customer The list of customer objects to convert.
     * @return List of CustomerResponse objects containing mapped data.
     */
    default List<CustomerResponse> toCustomerResponseList(List<Customer> customers) {

        if (customers == null) {
            return null;
        }

        return customers.stream()
                .map(customerToCustomerResponseMapper::map)
                .collect(Collectors.toList());

    }

    /**
     * Initializes and returns an instance of CustomPageToCustomPagingResponseMapper.
     *
     * @return Initialized CustomPageToCustomPagingResponseMapper instance.
     */
    static CustomPageToCustomPagingResponseMapper initialize() {
        return Mappers.getMapper(CustomPageToCustomPagingResponseMapper.class);
    }

}
