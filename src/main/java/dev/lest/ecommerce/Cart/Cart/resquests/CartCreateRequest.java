package dev.lest.ecommerce.Cart.Cart.resquests;

import dev.lest.ecommerce.Cart.Product.Product;
import dev.lest.ecommerce.Cart.Product.request.ProductRequest;
import dev.lest.ecommerce.Cart.Status;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record CartCreateRequest(Long clientId,
                                List<ProductRequest> products) {
}
