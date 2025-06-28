package dev.lest.ecommerce.Cart.Cart.mapper;

import dev.lest.ecommerce.Cart.Cart.Cart;
import dev.lest.ecommerce.Cart.Cart.reponses.CartUpdateResponse;
import dev.lest.ecommerce.Cart.Cart.resquests.CartUpdateRequest;
import dev.lest.ecommerce.Cart.Product.Product;
import dev.lest.ecommerce.Cart.Product.mapper.ProductMapper;
import dev.lest.ecommerce.Cart.Product.response.ProductReponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CartUpdateMapper {

    private final ProductMapper productMapper;

    //CartUpdateRequest -> Cart

    public Cart map(CartUpdateRequest cart) {

        List<Product> productList = cart.products().stream()
                .map(productMapper::map)
                .collect(Collectors.toList());

        return Cart.builder()
                .clientId(cart.clientId())
                .products(productList)
                .build();
    }

    //Cart -> CartUpdateResponse

    public CartUpdateResponse map(Cart cart) {

        List<ProductReponse> productReponseList = cart.getProducts().stream()
                .map(ProductMapper::map)
                .toList();

        return CartUpdateResponse.builder()
                .clientId(cart.getClientId())
                .products(productReponseList)
                .build();
    }
}
