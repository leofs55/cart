package dev.lest.ecommerce.Cart.exception;

public class CartAlreadyOpenException extends RuntimeException {
    public CartAlreadyOpenException(String message) {
        super(message);
    }
}
