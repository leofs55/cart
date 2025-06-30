package dev.lest.ecommerce.Cart.Cart;

import dev.lest.ecommerce.Cart.Cart.mapper.CartDeleteMapper;
import dev.lest.ecommerce.Cart.Cart.reponses.CartDeleteResponse;
import dev.lest.ecommerce.Cart.Product.ProductService;
import dev.lest.ecommerce.Cart.exception.CartAlreadyOpenException;
import dev.lest.ecommerce.Cart.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final ProductService productService;

    public Cart createCart(Cart cart) {

        cartRepository.findByClientIdAndStatus(cart.getClientId(), Status.OPEN)
                .ifPresent(cart1 -> {
                    throw new CartAlreadyOpenException("Já existe um carrinho aberto para este usuario!");
                });

        cart.calculateTotalPrice();
        return cartRepository.save(cart);
    }

    public Cart updateCartProducts(String id, Cart cart) {

        Optional<Cart> cartOptional = cartRepository.findById(id);

        if (cartOptional.isPresent()) {
            Cart cartUpdadted = cartOptional.get();
            cartUpdadted.calculateTotalPrice();
            return cartRepository.save(cartUpdadted);
        }
        throw new DataNotFoundException("Objeto não encontrado");
    }

    public Cart getCart(String cartId) {

        return cartRepository.
                findById(cartId)
                .orElseThrow(() -> new DataNotFoundException("Objeto não encontrado"));
    }

    public Cart updateStatusCart(String id) {

        Cart cart = getCart(id);
        cart.setStatus(Status.SOLD);
        return cartRepository.save(cart);

    }

    public CartDeleteResponse deleteCart(Cart cartWithOnlyId) {


        Optional<Cart> cartOptional = cartRepository.findById(cartWithOnlyId.getId());

        if (cartOptional.isPresent()) {
            Cart cart = cartOptional.get();
            cartRepository.delete(cart);
            return CartDeleteMapper.map(cart.getId(), "Objeto encontrado e deletado!");
        }

        throw new DataNotFoundException("Objeto não encontrado");
    }

}
