package br.com.guaranisistemas.api.ordersproducts.customer.exception;

import java.io.Serial;

/**
 * Exception class named {@link CustomerNotFoundException} thrown when a requested customer cannot be found.
 */
public class CustomerNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 5854010258697200749L;

    private static final String DEFAULT_MESSAGE = """
            Customer not found!
            """;

    /**
     * Constructs a new CustomerNotFoundException with a default message.
     */
    public CustomerNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    /**
     * Constructs a new CustomerNotFoundException with a custom message appended to the default message.
     *
     * @param message the custom message indicating details about the exception
     */
    public CustomerNotFoundException(final String message) {
        super(DEFAULT_MESSAGE + " " + message);
    }

}
