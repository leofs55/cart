package dev.lest.ecommerce.Cart.Cart.reponses;

import dev.lest.ecommerce.Cart.Product.Product;
import dev.lest.ecommerce.Cart.Product.response.ProductReponse;
import dev.lest.ecommerce.Cart.Status;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record CartCreateResponse(String id,
                                 Long clientId,
                                 BigDecimal totalPrice,
                                 List<ProductReponse> products,
                                 Status status) {
}
