package dev.lest.ecommerce.Cart;

import dev.lest.ecommerce.Cart.exception.CartAlreadyOpenException;
import dev.lest.ecommerce.Cart.exception.DataNotFoundException;
import dev.lest.ecommerce.Cart.exception.PaymentAlreadyPendingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleDataNotFoundException(DataNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(CartAlreadyOpenException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleCartAlreadyOpenException(CartAlreadyOpenException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(PaymentAlreadyPendingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlePaymentAlreadyPendingException(PaymentAlreadyPendingException ex) {
        return ex.getMessage();
    }
}
