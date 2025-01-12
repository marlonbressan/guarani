package br.com.guaranisistemas.api.ordersproducts.product.model.dto.response;

import br.com.guaranisistemas.api.ordersproducts.product.model.entity.ProductCategoryEntity;
import lombok.*;

import java.math.BigDecimal;

/**
 * Represents a response object containing product details as {@link ProductResponse}.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private String id;
    private String name;
    private ProductCategoryEntity category;
    private BigDecimal amount;
    private BigDecimal unitPrice;

}
