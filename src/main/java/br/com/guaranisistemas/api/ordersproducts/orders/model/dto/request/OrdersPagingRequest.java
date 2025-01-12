package br.com.guaranisistemas.api.ordersproducts.orders.model.dto.request;

import br.com.guaranisistemas.api.ordersproducts.common.model.dto.request.CustomPagingRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Represents a paging request object for retrieving orders as {@link OrdersPagingRequest}.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class OrdersPagingRequest extends CustomPagingRequest {


}
