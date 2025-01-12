package br.com.guaranisistemas.api.ordersproducts.customer.exception;

import java.io.Serial;

/**
 * Exception class named {@link CustomerAlreadyExistException} thrown when attempting to create a Customer that already exists.
 */
public class CustomerAlreadyExistException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 53457089789182737L;

    private static final String DEFAULT_MESSAGE = """
            Customer already exist!
            """;

    /**
     * Constructs a new CustomerAlreadyExistException with a default message.
     */
    public CustomerAlreadyExistException() {
        super(DEFAULT_MESSAGE);
    }

    /**
     * Constructs a new CustomerAlreadyExistException with a custom message appended to the default message.
     *
     * @param message the custom message indicating details about the exception
     */
    public CustomerAlreadyExistException(final String message) {
        super(DEFAULT_MESSAGE + " " + message);
    }

}
