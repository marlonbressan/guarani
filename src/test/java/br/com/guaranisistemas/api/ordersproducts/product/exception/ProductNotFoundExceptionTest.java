package br.com.guaranisistemas.api.ordersproducts.product.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ProductNotFoundExceptionTest {

    @Test
    void testDefaultConstructor() {
        ProductNotFoundException exception = new ProductNotFoundException();
        assertNotNull(exception);
        assertEquals("Product not found!\n", exception.getMessage());
    }

}