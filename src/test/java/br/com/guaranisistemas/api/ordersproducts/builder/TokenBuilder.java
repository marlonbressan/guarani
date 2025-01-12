package br.com.guaranisistemas.api.ordersproducts.builder;

import br.com.guaranisistemas.api.ordersproducts.auth.model.enums.TokenClaims;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@UtilityClass
public class TokenBuilder {

    public Claims getValidClaims(String userId, String firstName) {
        Map<String, Object> mockClaimsMap = new HashMap<>();
        mockClaimsMap.put(TokenClaims.JWT_ID.getValue(), UUID.randomUUID().toString());
        mockClaimsMap.put(TokenClaims.USER_ID.getValue(), userId);
        mockClaimsMap.put(TokenClaims.USER_FIRST_NAME.getValue(), firstName);
        return Jwts.claims(mockClaimsMap);
    }

}
