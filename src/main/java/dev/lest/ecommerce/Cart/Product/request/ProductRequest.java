package dev.lest.ecommerce.Cart.Product.request;

import lombok.Builder;

@Builder
public record ProductRequest(Long id, Integer quantity) {
}
