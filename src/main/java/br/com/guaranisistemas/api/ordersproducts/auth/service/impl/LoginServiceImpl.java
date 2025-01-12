package br.com.guaranisistemas.api.ordersproducts.auth.service.impl;

import br.com.guaranisistemas.api.ordersproducts.auth.exception.PasswordNotValidException;
import br.com.guaranisistemas.api.ordersproducts.auth.exception.UserNotFoundException;
import br.com.guaranisistemas.api.ordersproducts.auth.model.Token;
import br.com.guaranisistemas.api.ordersproducts.auth.model.dto.request.LoginRequest;
import br.com.guaranisistemas.api.ordersproducts.auth.model.entity.UserEntity;
import br.com.guaranisistemas.api.ordersproducts.auth.repository.UserRepository;
import br.com.guaranisistemas.api.ordersproducts.auth.service.LoginService;
import br.com.guaranisistemas.api.ordersproducts.auth.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service implementation named {@link LoginServiceImpl} for handling user login operations.
 */
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    /**
     * Performs user login based on the provided login request.
     *
     * @param loginRequest The login request containing user credentials.
     * @return The token representing the user's session.
     */
    @Override
    public Token login(LoginRequest loginRequest) {

        final UserEntity userEntityFromDB = userRepository
                .findUserEntityByEmail(loginRequest.getEmail())
                .orElseThrow(
                        () -> new UserNotFoundException(loginRequest.getEmail())
                );

        if (Boolean.FALSE.equals(passwordEncoder.matches(
                loginRequest.getPassword(), userEntityFromDB.getPassword()))) {
            throw new PasswordNotValidException();
        }

        return tokenService.generateToken(userEntityFromDB.getClaims());
    }

}
