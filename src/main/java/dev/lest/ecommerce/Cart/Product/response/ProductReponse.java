package dev.lest.ecommerce.Cart.Product.response;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductReponse(Long id,
                             String title,
                             BigDecimal price,
                             Integer quantity) {
}
