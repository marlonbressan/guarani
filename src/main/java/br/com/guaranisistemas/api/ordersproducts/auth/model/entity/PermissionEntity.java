package br.com.guaranisistemas.api.ordersproducts.auth.model.entity;

import br.com.guaranisistemas.api.ordersproducts.common.model.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents an entity as {@link PermissionEntity} for permissions.
 */
@Entity
@Getter
@Setter
@Table(name = "PERMISSIONS")
public class PermissionEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String name;

}
