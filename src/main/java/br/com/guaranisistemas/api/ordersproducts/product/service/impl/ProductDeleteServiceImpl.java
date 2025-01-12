package br.com.guaranisistemas.api.ordersproducts.product.service.impl;

import br.com.guaranisistemas.api.ordersproducts.product.exception.ProductNotFoundException;
import br.com.guaranisistemas.api.ordersproducts.product.model.entity.ProductEntity;
import br.com.guaranisistemas.api.ordersproducts.product.repository.ProductRepository;
import br.com.guaranisistemas.api.ordersproducts.product.service.ProductDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service implementation named {@link ProductDeleteServiceImpl} for deleting products.
 */
@Service
@RequiredArgsConstructor
public class ProductDeleteServiceImpl implements ProductDeleteService {

    private final ProductRepository productRepository;

    /**
     * Deletes a product identified by its unique ID.
     *
     * @param productId The ID of the product to delete.
     * @throws ProductNotFoundException If no product with the given ID exists.
     */
    @Override
    public void deleteProductById(String productId) {

        final ProductEntity productEntityToBeDelete = productRepository
                .findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("With given productID = " + productId));

        productRepository.delete(productEntityToBeDelete);

    }

}
