package br.com.guaranisistemas.api.ordersproducts.product.service;

import br.com.guaranisistemas.api.ordersproducts.product.model.Product;
import br.com.guaranisistemas.api.ordersproducts.product.model.dto.request.ProductCreateRequest;

/**
 * Service interface named {@link ProductCreateService} for creating products.
 */
public interface ProductCreateService {

    /**
     * Creates a new product based on the provided product creation request.
     *
     * @param productCreateRequest The request containing data to create the product.
     * @return The created Product object.
     */
    Product createProduct(final ProductCreateRequest productCreateRequest);

}
