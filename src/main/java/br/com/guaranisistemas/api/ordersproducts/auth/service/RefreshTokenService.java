package br.com.guaranisistemas.api.ordersproducts.auth.service;

import br.com.guaranisistemas.api.ordersproducts.auth.model.Token;
import br.com.guaranisistemas.api.ordersproducts.auth.model.dto.request.TokenRefreshRequest;

/**
 * Service interface named {@link RefreshTokenService} for refreshing authentication tokens.
 */
public interface RefreshTokenService {

    /**
     * Refreshes an authentication token based on the provided refresh token request.
     *
     * @param tokenRefreshRequest The request containing the refresh token.
     * @return The refreshed authentication token.
     */
    Token refreshToken(final TokenRefreshRequest tokenRefreshRequest);

}
