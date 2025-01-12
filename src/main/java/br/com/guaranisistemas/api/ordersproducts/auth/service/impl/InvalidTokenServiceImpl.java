package br.com.guaranisistemas.api.ordersproducts.auth.service.impl;

import br.com.guaranisistemas.api.ordersproducts.auth.exception.TokenAlreadyInvalidatedException;
import br.com.guaranisistemas.api.ordersproducts.auth.model.entity.InvalidTokenEntity;
import br.com.guaranisistemas.api.ordersproducts.auth.repository.InvalidTokenRepository;
import br.com.guaranisistemas.api.ordersproducts.auth.service.InvalidTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Service implementation named {@link InvalidTokenServiceImpl} for managing invalid tokens.
 */
@Service
@RequiredArgsConstructor
public class InvalidTokenServiceImpl implements InvalidTokenService {

    private final InvalidTokenRepository invalidTokenRepository;

    /**
     * Invalidates multiple tokens identified by their IDs.
     *
     * @param tokenIds The set of token IDs to invalidate.
     */
    @Override
    public void invalidateTokens(Set<String> tokenIds) {

        final Set<InvalidTokenEntity> invalidTokenEntities = tokenIds.stream()
                .map(tokenId -> InvalidTokenEntity.builder()
                        .tokenId(tokenId)
                        .build()
                )
                .collect(Collectors.toSet());

        invalidTokenRepository.saveAll(invalidTokenEntities);
    }

    /**
     * Checks if a token identified by its ID is invalid.
     *
     * @param tokenId The ID of the token to check for invalidity.
     * @throws TokenAlreadyInvalidatedException If the token is already invalidated.
     */
    @Override
    public void checkForInvalidityOfToken(String tokenId) {

        final boolean isTokenInvalid = invalidTokenRepository.findByTokenId(tokenId).isPresent();

        if (isTokenInvalid) {
            throw new TokenAlreadyInvalidatedException(tokenId);
        }

    }

}