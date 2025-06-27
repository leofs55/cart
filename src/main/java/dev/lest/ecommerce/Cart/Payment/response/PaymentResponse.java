package dev.lest.ecommerce.Cart.Payment.response;

import dev.lest.ecommerce.Cart.Payment.PaymentType;
import lombok.Builder;

@Builder
public record PaymentResponse(PaymentType type,
                              Long clientId,
                              String cartId,
                              Boolean validated) {
}
