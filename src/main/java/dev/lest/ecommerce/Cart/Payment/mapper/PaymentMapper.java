package dev.lest.ecommerce.Cart.Payment.mapper;

import dev.lest.ecommerce.Cart.Payment.Payment;
import dev.lest.ecommerce.Cart.Payment.request.PaymentRequest;
import dev.lest.ecommerce.Cart.Payment.request.ValidatePaymentRequest;
import dev.lest.ecommerce.Cart.Payment.response.PaymentResponse;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    public static Payment map(PaymentRequest paymentRequest) {
        return Payment.builder()
                .type(paymentRequest.type())
                .cartId(paymentRequest.cartId())
                .clientId(paymentRequest.clientId())
                .build();
    }

    public static PaymentResponse map(Payment payment) {
        return PaymentResponse.builder()
                .type(payment.getType())
                .clientId(payment.getClientId())
                .cartId(payment.getCartId())
                .validated(payment.getValidated())
                .build();
    }

    public static Payment map(ValidatePaymentRequest validatePaymentRequest) {
        return Payment.builder()
                .type(validatePaymentRequest.type())
                .cartId(validatePaymentRequest.cartId())
                .build();
    }
}
