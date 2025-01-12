package br.com.guaranisistemas.api.ordersproducts.auth.model;

import br.com.guaranisistemas.api.ordersproducts.auth.model.enums.UserStatus;
import br.com.guaranisistemas.api.ordersproducts.common.model.BaseDomainModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * Represents a user domain object as {@link User} in the application.
 */
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class User extends BaseDomainModel {

    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private UserStatus userStatus;
    private List<Role> roles;
    private List<Permission> permissions;
}
