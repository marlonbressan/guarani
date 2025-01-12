package br.com.guaranisistemas.api.ordersproducts.auth.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PermissionNotFoundExceptionTest {

    @Test
    void testDefaultConstructor() {
        PermissionNotFoundException exception = new PermissionNotFoundException();
        assertNotNull(exception);
        assertEquals("Permission not found!\n", exception.getMessage());
    }

}