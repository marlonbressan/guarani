package br.com.guaranisistemas.api.ordersproducts.product.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ProductAlreadyExistExceptionTest {

    @Test
    void testDefaultConstructor() {
        ProductAlreadyExistException exception = new ProductAlreadyExistException();
        assertNotNull(exception);
        assertEquals("Product already exist!\n", exception.getMessage());
    }

}