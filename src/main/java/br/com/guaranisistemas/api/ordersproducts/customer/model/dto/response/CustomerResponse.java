package br.com.guaranisistemas.api.ordersproducts.customer.model.dto.response;

import lombok.*;

/**
 * Represents a response object Customer product details as {@link CustomerResponse}.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {

    private String id;
    private String name;
    private String endereco;

}
