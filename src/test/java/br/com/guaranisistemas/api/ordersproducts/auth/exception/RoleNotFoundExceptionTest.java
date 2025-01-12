package br.com.guaranisistemas.api.ordersproducts.auth.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RoleNotFoundExceptionTest {

    @Test
    void testDefaultConstructor() {
        RoleNotFoundException exception = new RoleNotFoundException();
        assertNotNull(exception);
        assertEquals("Role not found!\n", exception.getMessage());
    }

}