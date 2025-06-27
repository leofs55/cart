package dev.lest.ecommerce.Cart.Payment.request;

import dev.lest.ecommerce.Cart.Payment.PaymentType;
import lombok.Builder;

@Builder
public record ValidatePaymentRequest(PaymentType type,
                                     String cartId) {
}
