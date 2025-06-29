package dev.lest.ecommerce.Cart.Cart;

import dev.lest.ecommerce.Cart.Cart.mapper.CartCreateMapper;
import dev.lest.ecommerce.Cart.Cart.mapper.CartDeleteMapper;
import dev.lest.ecommerce.Cart.Cart.mapper.CartUpdateMapper;
import dev.lest.ecommerce.Cart.Cart.mapper.CartValidMapper;
import dev.lest.ecommerce.Cart.Cart.reponses.CartCreateResponse;
import dev.lest.ecommerce.Cart.Cart.reponses.CartDeleteResponse;
import dev.lest.ecommerce.Cart.Cart.reponses.CartUpdateResponse;
import dev.lest.ecommerce.Cart.Cart.reponses.CartValidResponse;
import dev.lest.ecommerce.Cart.Cart.resquests.CartCreateRequest;
import dev.lest.ecommerce.Cart.Cart.resquests.CartDeleteRequest;
import dev.lest.ecommerce.Cart.Cart.resquests.CartUpdateRequest;
import dev.lest.ecommerce.Cart.Payment.Payment;
import dev.lest.ecommerce.Cart.Payment.PaymentService;
import dev.lest.ecommerce.Cart.Payment.mapper.PaymentMapper;
import dev.lest.ecommerce.Cart.Payment.request.PaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final PaymentService paymentService;

    private final CartCreateMapper cartCreateMapper;
    private final CartUpdateMapper cartUpdateMapper;


    @PostMapping
    public ResponseEntity<CartCreateResponse> createCart(@RequestBody CartCreateRequest cart) {

        Cart cartCreated = cartService.createCart(cartCreateMapper.map(cart));

        return ResponseEntity.status(HttpStatus.CREATED).body(cartCreateMapper.map(cartCreated));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartUpdateResponse> updateCart(@PathVariable String id, @RequestBody CartUpdateRequest cart) {

        Cart updatedCart = cartService.updateCartProducts(id, cartUpdateMapper.map(cart));

        return ResponseEntity.status(HttpStatus.CREATED).body(cartUpdateMapper.map(updatedCart));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable String id) {

        return ResponseEntity.status(HttpStatus.FOUND).body(cartService.getCart(id));
    }

    @PostMapping("/{id}/payment")
    public ResponseEntity<CartValidResponse> cartValidatePayment(@PathVariable String id, @RequestBody PaymentRequest paymentRequest) {

        Payment payment = paymentService.validatePayment(PaymentMapper.map(paymentRequest));

        Cart cart = cartService.updateStatusCart(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(CartValidMapper.map(cart, payment));
    }

    @DeleteMapping
    public ResponseEntity<CartDeleteResponse> deleteCart(@RequestBody CartDeleteRequest cart) {

        CartDeleteResponse cartDeleteResponse = cartService.deleteCart(CartDeleteMapper.map(cart));

        return ResponseEntity.status(HttpStatus.CREATED).body(cartDeleteResponse);
    }
}
