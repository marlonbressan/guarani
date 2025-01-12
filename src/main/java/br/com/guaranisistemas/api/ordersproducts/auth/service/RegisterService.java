package br.com.guaranisistemas.api.ordersproducts.auth.service;

import br.com.guaranisistemas.api.ordersproducts.auth.model.User;
import br.com.guaranisistemas.api.ordersproducts.auth.model.dto.request.RegisterRequest;

/**
 * Service interface named {@link RegisterService} for user registration operations.
 */
public interface RegisterService {

    /**
     * Registers a new user based on the provided registration request.
     *
     * @param registerRequest The registration request containing user details.
     * @return The registered user entity.
     */
    User registerUser(final RegisterRequest registerRequest);
}
