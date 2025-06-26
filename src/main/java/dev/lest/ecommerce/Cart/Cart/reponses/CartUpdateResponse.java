package dev.lest.ecommerce.Cart.Cart.reponses;

import dev.lest.ecommerce.Cart.Product.Product;
import dev.lest.ecommerce.Cart.Product.response.ProductReponse;
import lombok.Builder;

import java.util.List;

@Builder
public record CartUpdateResponse(Long clientId,
                                 List<ProductReponse> products) {
}
