package dev.lest.ecommerce.Cart.Product;

import dev.lest.ecommerce.Cart.Platzi.client.PlatziStoreClient;
import dev.lest.ecommerce.Cart.Platzi.client.response.PlatziRecordResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final PlatziStoreClient platziStoreClient;

    @Cacheable(value = "products")
    public List<PlatziRecordResponse> getAllProducts() {
        log.info("Getting all products");
        return platziStoreClient.getAllProducts();
    }

    @Cacheable(value = "products", key = "#productId")
    public PlatziRecordResponse getProductById(Long productId) {
        log.info("Getting product with id: {}", productId);
        return platziStoreClient.getProductById(productId);
    }
}
