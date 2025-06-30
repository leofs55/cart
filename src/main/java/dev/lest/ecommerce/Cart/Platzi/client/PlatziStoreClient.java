package dev.lest.ecommerce.Cart.Platzi.client;

import dev.lest.ecommerce.Cart.exception.CustomErrorDecoder;
import dev.lest.ecommerce.Cart.Platzi.client.response.PlatziRecordResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "PlatziStoreClient", url = "${cart.client.platzi}", configuration = {CustomErrorDecoder.class})
public interface PlatziStoreClient {

    @GetMapping("/products")
    List<PlatziRecordResponse> getAllProducts();

    @GetMapping("/products/{id}")
    PlatziRecordResponse getProductById(@PathVariable Long id);
}
