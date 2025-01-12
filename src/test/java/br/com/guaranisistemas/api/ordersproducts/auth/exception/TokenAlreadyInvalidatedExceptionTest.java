package br.com.guaranisistemas.api.ordersproducts.auth.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TokenAlreadyInvalidatedExceptionTest {

    @Test
    void testDefaultConstructor() {
        TokenAlreadyInvalidatedException exception = new TokenAlreadyInvalidatedException();
        assertNotNull(exception);
        assertEquals("Token is already invalidated!\n", exception.getMessage());
    }

}