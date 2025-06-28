package dev.lest.ecommerce.Cart.Cart.mapper;

import dev.lest.ecommerce.Cart.Cart.Cart;
import dev.lest.ecommerce.Cart.Cart.reponses.CartValidResponse;
import dev.lest.ecommerce.Cart.Payment.Payment;
import dev.lest.ecommerce.Cart.Payment.mapper.PaymentMapper;
import dev.lest.ecommerce.Cart.Product.mapper.ProductMapper;
import dev.lest.ecommerce.Cart.Product.response.ProductReponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartValidMapper {

    public static CartValidResponse map(Cart cart, Payment payment) {

        List<ProductReponse> productReponseList = cart.getProducts().stream()
                .map(ProductMapper::map)
                .toList();

        return CartValidResponse.builder()
                .id(cart.getId())
                .clientId(cart.getClientId())
                .products(productReponseList)
                .status(cart.getStatus())
                .paymentResponse(PaymentMapper.map(payment))
                .build();
    }

}
