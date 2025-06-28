package dev.lest.ecommerce.Cart.Cart.reponses;

import dev.lest.ecommerce.Cart.Cart.Status;
import dev.lest.ecommerce.Cart.Payment.response.PaymentResponse;
import dev.lest.ecommerce.Cart.Product.response.ProductReponse;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record CartValidResponse(String id,
                                Long clientId,
                                BigDecimal totalPrice,
                                List<ProductReponse> products,
                                Status status,
                                PaymentResponse paymentResponse) {
}
