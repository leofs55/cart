package dev.lest.ecommerce.Cart.Cart.mapper;

import dev.lest.ecommerce.Cart.Cart.Cart;
import dev.lest.ecommerce.Cart.Cart.reponses.CartDeleteResponse;
import dev.lest.ecommerce.Cart.Cart.resquests.CartDeleteRequest;
import org.springframework.stereotype.Component;

@Component
public class CartDeleteMapper {

    public static Cart map(CartDeleteRequest cartDeleteRequest) {

        return Cart.builder()
                .id(cartDeleteRequest.id())
                .build();
    }

    public static CartDeleteResponse map(String id, String result) {

        return CartDeleteResponse.builder()
                .id(id)
                .result(result)
                .build();
    }
}
