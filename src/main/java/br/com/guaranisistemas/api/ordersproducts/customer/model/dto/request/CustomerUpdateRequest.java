package br.com.guaranisistemas.api.ordersproducts.customer.model.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * Represents a request object for updating an existing Customer as {@link CustomerUpdateRequest}.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerUpdateRequest {

    @Size(
            min = 1,
            message = "Customer name can't be blank."
    )
    private String name;

    @Size(
            min = 1,
            message = "Customer name can't be blank."
    )
    private String endereco;

}
