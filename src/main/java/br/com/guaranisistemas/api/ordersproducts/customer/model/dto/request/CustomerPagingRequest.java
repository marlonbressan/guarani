package br.com.guaranisistemas.api.ordersproducts.customer.model.dto.request;

import br.com.guaranisistemas.api.ordersproducts.common.model.dto.request.CustomPagingRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Represents a paging request object for retrieving customer as {@link CustomerPagingRequest}.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class CustomerPagingRequest extends CustomPagingRequest {


}
