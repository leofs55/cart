package dev.lest.ecommerce.Cart.exception;

public class PaymentAlreadyPendingException extends RuntimeException {
    public PaymentAlreadyPendingException(String message) {
        super(message);
    }
}
