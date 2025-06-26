package dev.lest.ecommerce.Cart.Cart.reponses;

import lombok.Builder;

@Builder
public record CartDeleteResponse(String id,
                                 String result) {
}
