package br.com.guaranisistemas.api.ordersproducts.product.model.mapper;

import br.com.guaranisistemas.api.ordersproducts.common.model.mapper.BaseMapper;
import br.com.guaranisistemas.api.ordersproducts.product.model.Product;
import br.com.guaranisistemas.api.ordersproducts.product.model.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper interface named {@link ProductEntityToProductMapper} for converting {@link ProductEntity} to {@link Product}.
 */
@Mapper
public interface ProductEntityToProductMapper extends BaseMapper<ProductEntity, Product> {

    /**
     * Maps ProductEntity to Product.
     *
     * @param source The ProductEntity object to map.
     * @return Product object containing mapped data.
     */
    @Override
    Product map(ProductEntity source);

    /**
     * Initializes and returns an instance of ProductEntityToProductMapper.
     *
     * @return Initialized ProductEntityToProductMapper instance.
     */
    static ProductEntityToProductMapper initialize() {
        return Mappers.getMapper(ProductEntityToProductMapper.class);
    }

}
