package br.com.guaranisistemas.api.ordersproducts.product.model.dto.request;

import br.com.guaranisistemas.api.ordersproducts.common.model.dto.request.CustomPagingRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Represents a paging request object for retrieving products as {@link ProductPagingRequest}.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class ProductPagingRequest extends CustomPagingRequest {


}
