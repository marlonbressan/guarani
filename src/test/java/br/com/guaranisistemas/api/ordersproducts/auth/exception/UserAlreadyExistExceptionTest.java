package br.com.guaranisistemas.api.ordersproducts.auth.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserAlreadyExistExceptionTest {

    @Test
    void testDefaultConstructor() {
        UserAlreadyExistException exception = new UserAlreadyExistException();
        assertNotNull(exception);
        assertEquals("User already exist!\n", exception.getMessage());
    }

}