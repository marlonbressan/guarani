package br.com.guaranisistemas.api.ordersproducts.auth.service.impl;

import br.com.guaranisistemas.api.ordersproducts.auth.model.dto.request.TokenInvalidateRequest;
import br.com.guaranisistemas.api.ordersproducts.auth.service.InvalidTokenService;
import br.com.guaranisistemas.api.ordersproducts.auth.service.LogoutService;
import br.com.guaranisistemas.api.ordersproducts.auth.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Service implementation named {@link LogoutServiceImpl} for handling user logout operations.
 */
@Service
@RequiredArgsConstructor
public class LogoutServiceImpl implements LogoutService {

    private final TokenService tokenService;
    private final InvalidTokenService invalidTokenService;

    /**
     * Logs out a user session based on the provided token invalidation request.
     *
     * @param tokenInvalidateRequest The request containing tokens to invalidate for logout.
     */
    @Override
    public void logout(TokenInvalidateRequest tokenInvalidateRequest) {

        tokenService.verifyAndValidate(
                Set.of(
                        tokenInvalidateRequest.getAccessToken(),
                        tokenInvalidateRequest.getRefreshToken()
                )
        );

        final String accessTokenId = tokenService
                .getPayload(tokenInvalidateRequest.getAccessToken())
                .getId();

        invalidTokenService.checkForInvalidityOfToken(accessTokenId);


        final String refreshTokenId = tokenService
                .getPayload(tokenInvalidateRequest.getRefreshToken())
                .getId();

        invalidTokenService.checkForInvalidityOfToken(refreshTokenId);

        invalidTokenService.invalidateTokens(Set.of(accessTokenId, refreshTokenId));

    }

}
