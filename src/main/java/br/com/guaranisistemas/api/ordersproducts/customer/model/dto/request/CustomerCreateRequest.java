package br.com.guaranisistemas.api.ordersproducts.customer.model.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * Represents a request object for creating a new customer as {@link CustomerCreateRequest}.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerCreateRequest {

    @Size(
            min = 1,
            message = "Customer name can't be blank."
    )
    private String name;

    @Size(
            min = 1,
            message = "Address can't be blank."
    )
    private String endereco;

}
