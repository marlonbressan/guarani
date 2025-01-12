package br.com.guaranisistemas.api.ordersproducts.product.model.mapper;

import br.com.guaranisistemas.api.ordersproducts.common.model.mapper.BaseMapper;
import br.com.guaranisistemas.api.ordersproducts.product.model.dto.request.ProductUpdateRequest;
import br.com.guaranisistemas.api.ordersproducts.product.model.entity.ProductCategoryEntity;
import br.com.guaranisistemas.api.ordersproducts.product.model.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

/**
 * Mapper interface named {@link ProductUpdateRequestToProductEntityMapper} for updating {@link ProductEntity} using {@link ProductUpdateRequest}.
 */
@Mapper
public interface ProductUpdateRequestToProductEntityMapper extends BaseMapper<ProductUpdateRequest, ProductEntity> {

    /**
     * Maps fields from ProductUpdateRequest to update ProductEntity.
     *
     * @param productEntityToBeUpdate The ProductEntity object to be updated.
     * @param productUpdateRequest    The ProductUpdateRequest object containing updated fields.
     */
    @Named("mapForUpdating")
    default void mapForUpdating(ProductEntity productEntityToBeUpdate, ProductUpdateRequest productUpdateRequest) {
        productEntityToBeUpdate.setName(productUpdateRequest.getName());
        productEntityToBeUpdate.setCategory(ProductCategoryEntity.builder().id(productUpdateRequest.getCategoryId()).build());
        productEntityToBeUpdate.setAmount(productUpdateRequest.getAmount());
        productEntityToBeUpdate.setUnitPrice(productUpdateRequest.getUnitPrice());
    }

    /**
     * Initializes and returns an instance of ProductUpdateRequestToProductEntityMapper.
     *
     * @return Initialized ProductUpdateRequestToProductEntityMapper instance.
     */
    static ProductUpdateRequestToProductEntityMapper initialize() {
        return Mappers.getMapper(ProductUpdateRequestToProductEntityMapper.class);
    }

}
