package br.com.guaranisistemas.api.ordersproducts.auth.service.impl;

import br.com.guaranisistemas.api.ordersproducts.auth.exception.UserNotFoundException;
import br.com.guaranisistemas.api.ordersproducts.auth.exception.UserStatusNotValidException;
import br.com.guaranisistemas.api.ordersproducts.auth.model.Token;
import br.com.guaranisistemas.api.ordersproducts.auth.model.dto.request.TokenRefreshRequest;
import br.com.guaranisistemas.api.ordersproducts.auth.model.entity.UserEntity;
import br.com.guaranisistemas.api.ordersproducts.auth.model.enums.TokenClaims;
import br.com.guaranisistemas.api.ordersproducts.auth.model.enums.UserStatus;
import br.com.guaranisistemas.api.ordersproducts.auth.repository.UserRepository;
import br.com.guaranisistemas.api.ordersproducts.auth.service.RefreshTokenService;
import br.com.guaranisistemas.api.ordersproducts.auth.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service implementation named {@link RefreshTokenServiceImpl} for refreshing authentication tokens.
 */
@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final UserRepository userRepository;
    private final TokenService tokenService;

    /**
     * Refreshes an authentication token based on the provided refresh token request.
     *
     * @param tokenRefreshRequest The request containing the refresh token.
     * @return The refreshed authentication token.
     */
    @Override
    public Token refreshToken(TokenRefreshRequest tokenRefreshRequest) {

        tokenService.verifyAndValidate(tokenRefreshRequest.getRefreshToken());

        final String adminId = tokenService
                .getPayload(tokenRefreshRequest.getRefreshToken())
                .get(TokenClaims.USER_ID.getValue())
                .toString();

        final UserEntity userEntityFromDB = userRepository
                .findById(adminId)
                .orElseThrow(UserNotFoundException::new);

        this.validateAdminStatus(userEntityFromDB);

        return tokenService.generateToken(
                userEntityFromDB.getClaims(),
                tokenRefreshRequest.getRefreshToken()
        );
    }

    /**
     * Validates the status of an admin user.
     *
     * @param userEntity The user entity to validate.
     * @throws UserStatusNotValidException If the user status is not valid.
     */
    private void validateAdminStatus(final UserEntity userEntity) {
        if (!(UserStatus.ACTIVE.equals(userEntity.getUserStatus()))) {
            throw new UserStatusNotValidException("UserStatus = " + userEntity.getUserStatus());
        }
    }

}
