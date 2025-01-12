package br.com.guaranisistemas.api.ordersproducts.common.util;

import br.com.guaranisistemas.api.ordersproducts.common.model.CustomPaging;
import br.com.guaranisistemas.api.ordersproducts.customer.model.dto.request.CustomerPagingRequest;
import br.com.guaranisistemas.api.ordersproducts.orders.model.dto.request.OrdersPagingRequest;
import br.com.guaranisistemas.api.ordersproducts.product.model.dto.request.ProductPagingRequest;
import lombok.experimental.UtilityClass;

/**
 * Utility class named {@link HelperPagination} for converting objects to lists.
 */
@UtilityClass
public class HelperPagination {

    public static CustomerPagingRequest createCustomerDefaultPagination() {
        CustomerPagingRequest result = new CustomerPagingRequest();
        result.setPagination(createCustomPaging());
        return result;
    }

    public static OrdersPagingRequest createOrderDefaultPagination() {
        OrdersPagingRequest result = new OrdersPagingRequest();
        result.setPagination(createCustomPaging());
        return result;
    }

    public static ProductPagingRequest createProductDefaultPagination() {
        ProductPagingRequest result = new ProductPagingRequest();
        result.setPagination(createCustomPaging());
        return result;
    }

    private static CustomPaging createCustomPaging() {
        CustomPaging result = new CustomPaging();
        result.setPageNumber(1);
        result.setPageSize(1000);
        return result;
    }


}
