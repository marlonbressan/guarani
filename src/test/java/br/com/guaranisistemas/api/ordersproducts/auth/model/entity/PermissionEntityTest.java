package br.com.guaranisistemas.api.ordersproducts.auth.model.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PermissionEntityTest {

    @Test
    void testGettersAndSettersForId() {

        // Given
        String id = "test-id";
        PermissionEntity permissionEntity = new PermissionEntity();

        // When
        permissionEntity.setId(id);

        // Then
        assertEquals(id, permissionEntity.getId());

    }

    @Test
    void testIdFieldInitialValue() {

        // Given
        PermissionEntity permissionEntity = new PermissionEntity();

        // Then
        assertNull(permissionEntity.getId());

    }

}