package dev.lest.ecommerce.Cart.Cart.resquests;

import lombok.Builder;

@Builder
public record CartDeleteRequest(String id) {
}
