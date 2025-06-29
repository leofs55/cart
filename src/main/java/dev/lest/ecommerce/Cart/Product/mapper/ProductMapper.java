package dev.lest.ecommerce.Cart.Product.mapper;

import dev.lest.ecommerce.Cart.Platzi.client.response.PlatziRecordResponse;
import dev.lest.ecommerce.Cart.Product.Product;
import dev.lest.ecommerce.Cart.Product.ProductService;
import dev.lest.ecommerce.Cart.Product.request.ProductRequest;
import dev.lest.ecommerce.Cart.Product.response.ProductReponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    private final ProductService productService;

    public Product map(ProductRequest productRequest) {

        PlatziRecordResponse product = productService.getProductById(productRequest.id());

        return Product.builder()
                .id(product.id())
                .title(product.title())
                .price(product.price())
                .quantity(productRequest.quantity())
                .build();
    }

    public static ProductReponse map(Product product) {
        return ProductReponse.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }

}
