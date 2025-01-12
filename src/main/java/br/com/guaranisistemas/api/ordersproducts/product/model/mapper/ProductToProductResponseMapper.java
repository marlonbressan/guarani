package br.com.guaranisistemas.api.ordersproducts.product.model.mapper;

import br.com.guaranisistemas.api.ordersproducts.common.model.mapper.BaseMapper;
import br.com.guaranisistemas.api.ordersproducts.product.model.Product;
import br.com.guaranisistemas.api.ordersproducts.product.model.dto.response.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper interface named {@link ProductToProductResponseMapper} for converting {@link Product} to {@link ProductResponse}.
 */
@Mapper
public interface ProductToProductResponseMapper extends BaseMapper<Product, ProductResponse> {

    /**
     * Maps Product to ProductResponse.
     *
     * @param source The Product object to map.
     * @return ProductResponse object containing mapped data.
     */
    @Override
    ProductResponse map(Product source);

    /**
     * Initializes and returns an instance of ProductToProductResponseMapper.
     *
     * @return Initialized ProductToProductResponseMapper instance.
     */
    static ProductToProductResponseMapper initialize() {
        return Mappers.getMapper(ProductToProductResponseMapper.class);
    }

}
