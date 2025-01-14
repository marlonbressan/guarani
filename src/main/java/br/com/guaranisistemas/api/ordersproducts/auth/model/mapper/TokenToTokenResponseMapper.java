package br.com.guaranisistemas.api.ordersproducts.auth.model.mapper;

import br.com.guaranisistemas.api.ordersproducts.auth.model.Token;
import br.com.guaranisistemas.api.ordersproducts.auth.model.dto.response.TokenResponse;
import br.com.guaranisistemas.api.ordersproducts.common.model.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper interface named {@link TokenToTokenResponseMapper} for mapping {@link Token} to {@link TokenResponse}.
 */
@Mapper
public interface TokenToTokenResponseMapper extends BaseMapper<Token, TokenResponse> {

    /**
     * Maps a {@link Token} object to a {@link TokenResponse} object.
     *
     * @param source The {@link Token} object to map.
     * @return A {@link TokenResponse} object mapped from the {@link Token}.
     */
    @Override
    TokenResponse map(Token source);

    /**
     * Initializes and returns an instance of {@code TokenToTokenResponseMapper}.
     *
     * @return An initialized {@code TokenToTokenResponseMapper} instance.
     */
    static TokenToTokenResponseMapper initialize() {
        return Mappers.getMapper(TokenToTokenResponseMapper.class);
    }

}
