package dev.lest.ecommerce.Cart.Cart.resquests;

import dev.lest.ecommerce.Cart.Product.Product;
import dev.lest.ecommerce.Cart.Product.request.ProductRequest;
import lombok.Builder;

import java.util.List;

@Builder
public record CartUpdateRequest(Long clientId,
                                List<ProductRequest> products) {
}
