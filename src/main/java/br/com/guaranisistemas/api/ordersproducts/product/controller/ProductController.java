package br.com.guaranisistemas.api.ordersproducts.product.controller;

import br.com.guaranisistemas.api.ordersproducts.common.model.CustomPage;
import br.com.guaranisistemas.api.ordersproducts.common.model.dto.response.CustomPagingResponse;
import br.com.guaranisistemas.api.ordersproducts.common.model.dto.response.CustomResponse;
import br.com.guaranisistemas.api.ordersproducts.product.model.Product;
import br.com.guaranisistemas.api.ordersproducts.product.model.dto.request.ProductCreateRequest;
import br.com.guaranisistemas.api.ordersproducts.product.model.dto.request.ProductPagingRequest;
import br.com.guaranisistemas.api.ordersproducts.product.model.dto.request.ProductUpdateRequest;
import br.com.guaranisistemas.api.ordersproducts.product.model.dto.response.ProductResponse;
import br.com.guaranisistemas.api.ordersproducts.product.model.mapper.CustomPageToCustomPagingResponseMapper;
import br.com.guaranisistemas.api.ordersproducts.product.model.mapper.ProductToProductResponseMapper;
import br.com.guaranisistemas.api.ordersproducts.product.service.ProductCreateService;
import br.com.guaranisistemas.api.ordersproducts.product.service.ProductDeleteService;
import br.com.guaranisistemas.api.ordersproducts.product.service.ProductReadService;
import br.com.guaranisistemas.api.ordersproducts.product.service.ProductUpdateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.UUID;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * Controller class named {@link ProductController} for handling product-related CRUD operations.
 * Exposes endpoints under "/api/v1/products".
 */
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Validated
public class ProductController {

    private final ProductCreateService productCreateService;
    private final ProductReadService productReadService;
    private final ProductUpdateService productUpdateService;
    private final ProductDeleteService productDeleteService;

    private final ProductToProductResponseMapper productToProductResponseMapper = ProductToProductResponseMapper.initialize();

    private final CustomPageToCustomPagingResponseMapper customPageToCustomPagingResponseMapper =
            CustomPageToCustomPagingResponseMapper.initialize();

    /**
     * Creates a new product.
     *
     * @param productCreateRequest the request body containing product creation details
     * @return a CustomResponse with the ID of the created product upon successful creation
     */
    @PostMapping
    //@PreAuthorize("hasAnyAuthority('admin:create')")
    public CustomResponse<String> createProduct(@RequestBody @Valid final ProductCreateRequest productCreateRequest) {

        final Product createdProduct = productCreateService
                .createProduct(productCreateRequest);

        return CustomResponse.successOf(createdProduct.getId());
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param productId the ID of the product to retrieve
     * @return a CustomResponse containing the product details
     */
    @GetMapping("/{productId}")
    //@PreAuthorize("hasAnyAuthority('admin:get', 'user:get', 'operator:get')")
    public CustomResponse<ProductResponse> getProductById(@PathVariable @UUID final String productId) {

        final Product product = productReadService.getProductById(productId);

        final ProductResponse productResponse = productToProductResponseMapper.map(product);

        return CustomResponse.successOf(productResponse);

    }

    /**
     * Retrieves a list of products based on pagination criteria.
     *
     * @param productPagingRequest the request body containing pagination parameters
     * @return a CustomResponse with paginated product details
     */
    @GetMapping
    public CustomResponse<CustomPagingResponse<ProductResponse>> getProducts(
            @RequestBody @Valid final ProductPagingRequest productPagingRequest) {

        final CustomPage<Product> productPage = productReadService.getProducts(productPagingRequest);

        final CustomPagingResponse<ProductResponse> productPagingResponse =
                customPageToCustomPagingResponseMapper.toPagingResponse(productPage);

        return CustomResponse.successOf(productPagingResponse);

    }

    @GetMapping("/findByFilters")
    public CustomResponse<CustomPagingResponse<ProductResponse>> findByFilters(
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) BigDecimal price,
            @RequestBody @Valid final ProductPagingRequest productPagingRequest
    ) {

        final CustomPage<Product> productPage = productReadService.getProductsByFilters(productPagingRequest, description, category, price);

        final CustomPagingResponse<ProductResponse> productPagingResponse =
                customPageToCustomPagingResponseMapper.toPagingResponse(productPage);

        return CustomResponse.successOf(productPagingResponse);

    }

    /**
     * Updates an existing product by its ID.
     *
     * @param productUpdateRequest the request body containing updated product details
     * @param productId            the ID of the product to update
     * @return a CustomResponse with updated product details
     */
    @PutMapping("/{productId}")
    //@PreAuthorize("hasAnyAuthority('admin:update')")
    public CustomResponse<ProductResponse> updatedProductById(
            @RequestBody @Valid final ProductUpdateRequest productUpdateRequest,
            @PathVariable @UUID final String productId) {

        final Product updatedProduct = productUpdateService.updateProductById(productId, productUpdateRequest);

        final ProductResponse productResponse = productToProductResponseMapper.map(updatedProduct);

        return CustomResponse.successOf(productResponse);
    }

    /**
     * Deletes a product by its ID.
     *
     * @param productId the ID of the product to delete
     * @return a CustomResponse indicating the success of the deletion operation
     */
    @DeleteMapping("/{productId}")
    //@PreAuthorize("hasAnyAuthority('admin:delete')")
    public CustomResponse<Void> deleteProductById(@PathVariable @UUID final String productId) {

        productDeleteService.deleteProductById(productId);
        return CustomResponse.SUCCESS;
    }

}
