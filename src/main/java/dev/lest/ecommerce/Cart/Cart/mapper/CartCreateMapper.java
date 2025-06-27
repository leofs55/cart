package dev.lest.ecommerce.Cart.Cart.mapper;

import dev.lest.ecommerce.Cart.Cart.Cart;
import dev.lest.ecommerce.Cart.Cart.reponses.CartCreateResponse;
import dev.lest.ecommerce.Cart.Cart.resquests.CartCreateRequest;
import dev.lest.ecommerce.Cart.Product.Product;
import dev.lest.ecommerce.Cart.Product.mapper.ProductMapper;
import dev.lest.ecommerce.Cart.Product.response.ProductReponse;
import dev.lest.ecommerce.Cart.Cart.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CartCreateMapper {

    private final ProductMapper productMapper;

    //CartCreateRequest -> Cart

    public Cart map(CartCreateRequest cart) {

        List<Product> productList = cart.products().stream()
                .map(productMapper::map)
                .collect(Collectors.toList());

        return Cart.builder()
                .clientId(cart.clientId())
                .products(productList)
                .status(Status.OPEN)
                .build();
    }

    //Cart -> CartCreateResponse

    public CartCreateResponse map(Cart cart) {

        List<ProductReponse> productReponseList = cart.getProducts().stream()
                .map(productMapper::map)
                .toList();

        return CartCreateResponse.builder()
                .id(cart.getId())
                .clientId(cart.getClientId())
                .products(productReponseList)
                .totalPrice(cart.getTotalPrice())
                .status(cart.getStatus())
                .build();
    }


}
