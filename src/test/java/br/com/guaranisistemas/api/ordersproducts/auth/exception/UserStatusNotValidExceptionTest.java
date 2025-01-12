package br.com.guaranisistemas.api.ordersproducts.auth.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserStatusNotValidExceptionTest {

    @Test
    void testDefaultConstructor() {
        UserStatusNotValidException exception = new UserStatusNotValidException();
        assertNotNull(exception);
        assertEquals("User status is not valid!\n", exception.getMessage());
    }

}