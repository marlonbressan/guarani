package br.com.guaranisistemas.api.ordersproducts.orders.exception;

import java.io.Serial;

/**
 * Exception class named {@link OrdersAlreadyExistException} thrown when attempting to create a Orders that already exists.
 */
public class OrdersAlreadyExistException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 53457089789182737L;

    private static final String DEFAULT_MESSAGE = """
            Orders already exist!
            """;

    /**
     * Constructs a new OrdersAlreadyExistException with a default message.
     */
    public OrdersAlreadyExistException() {
        super(DEFAULT_MESSAGE);
    }

    /**
     * Constructs a new OrdersAlreadyExistException with a custom message appended to the default message.
     *
     * @param message the custom message indicating details about the exception
     */
    public OrdersAlreadyExistException(final String message) {
        super(DEFAULT_MESSAGE + " " + message);
    }

}
