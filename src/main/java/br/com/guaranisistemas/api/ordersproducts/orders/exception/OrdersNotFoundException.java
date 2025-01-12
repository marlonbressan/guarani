package br.com.guaranisistemas.api.ordersproducts.orders.exception;

import java.io.Serial;

/**
 * Exception class named {@link OrdersNotFoundException} thrown when a requested orders cannot be found.
 */
public class OrdersNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 5854010258697200749L;

    private static final String DEFAULT_MESSAGE = """
            Orders not found!
            """;

    /**
     * Constructs a new OrdersNotFoundException with a default message.
     */
    public OrdersNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    /**
     * Constructs a new OrdersNotFoundException with a custom message appended to the default message.
     *
     * @param message the custom message indicating details about the exception
     */
    public OrdersNotFoundException(final String message) {
        super(DEFAULT_MESSAGE + " " + message);
    }

}
