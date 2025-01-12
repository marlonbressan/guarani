package br.com.guaranisistemas.api.ordersproducts.product.service;

import br.com.guaranisistemas.api.ordersproducts.common.model.CustomPage;
import br.com.guaranisistemas.api.ordersproducts.product.model.Product;
import br.com.guaranisistemas.api.ordersproducts.product.model.dto.request.ProductPagingRequest;

import java.math.BigDecimal;

/**
 * Service interface named {@link ProductReadService} for reading products.
 */
public interface ProductReadService {

    /**
     * Retrieves a product by its unique ID.
     *
     * @param productId The ID of the product to retrieve.
     * @return The Product object corresponding to the given ID.
     */
    Product getProductById(final String productId);

    /**
     * Retrieves a page of products based on the paging request criteria.
     *
     * @param productPagingRequest The paging request criteria.
     * @return A CustomPage containing the list of products that match the paging criteria.
     */
    CustomPage<Product> getProducts(final ProductPagingRequest productPagingRequest);

    CustomPage<Product> getProductsByFilters(final ProductPagingRequest productPagingRequest,
                                             String description, String category, BigDecimal price);

}
