package br.com.guaranisistemas.api.ordersproducts.auth.service.impl;

import br.com.guaranisistemas.api.ordersproducts.auth.exception.PermissionNotFoundException;
import br.com.guaranisistemas.api.ordersproducts.auth.exception.RoleNotFoundException;
import br.com.guaranisistemas.api.ordersproducts.auth.exception.UserAlreadyExistException;
import br.com.guaranisistemas.api.ordersproducts.auth.model.User;
import br.com.guaranisistemas.api.ordersproducts.auth.model.dto.request.RegisterRequest;
import br.com.guaranisistemas.api.ordersproducts.auth.model.entity.RoleEntity;
import br.com.guaranisistemas.api.ordersproducts.auth.model.entity.UserEntity;
import br.com.guaranisistemas.api.ordersproducts.auth.model.mapper.RegisterRequestToUserEntityMapper;
import br.com.guaranisistemas.api.ordersproducts.auth.model.mapper.UserEntityToUserMapper;
import br.com.guaranisistemas.api.ordersproducts.auth.repository.PermissionRepository;
import br.com.guaranisistemas.api.ordersproducts.auth.repository.RoleRepository;
import br.com.guaranisistemas.api.ordersproducts.auth.repository.UserRepository;
import br.com.guaranisistemas.api.ordersproducts.auth.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation named {@link RegisterServiceImpl} for user registration operations.
 */
@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PermissionRepository permissionRepository;

    private final RegisterRequestToUserEntityMapper registerRequestToUserEntityMapper =
            RegisterRequestToUserEntityMapper.initialize();

    private final UserEntityToUserMapper userEntityToUserMapper = UserEntityToUserMapper.initialize();

    private final PasswordEncoder passwordEncoder;

    /**
     * Registers a new user based on the provided registration request.
     *
     * @param registerRequest The registration request containing user details.
     * @return The registered user entity.
     */
    @Override
    public User registerUser(RegisterRequest registerRequest) {

        if (userRepository.existsUserEntityByEmail(registerRequest.getEmail())) {
            throw new UserAlreadyExistException("The email is already used for another user : " + registerRequest.getEmail());
        }

        final UserEntity userEntityToBeSaved = registerRequestToUserEntityMapper.mapForSaving(registerRequest);

        userEntityToBeSaved.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        List<RoleEntity> roles = registerRequest.getRole().stream()
                .map(roleName -> roleRepository.findByName(roleName)
                        .orElseThrow(() -> new RoleNotFoundException(roleName)))
                .collect(Collectors.toList());

        roles.forEach(role -> role.setPermissions(
                registerRequest.getPermissions().stream()
                        .map(permissionName -> permissionRepository.findByName(permissionName)
                                .orElseThrow(() -> new PermissionNotFoundException(permissionName)))
                        .collect(Collectors.toList())
        ));

        userEntityToBeSaved.setRoles(roles);

        final UserEntity savedUserEntity = userRepository.save(userEntityToBeSaved);

        return userEntityToUserMapper.map(savedUserEntity);

    }

}
