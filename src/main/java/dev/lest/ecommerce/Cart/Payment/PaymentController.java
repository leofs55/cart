package dev.lest.ecommerce.Cart.Payment;

import dev.lest.ecommerce.Cart.Payment.mapper.PaymentMapper;
import dev.lest.ecommerce.Cart.Payment.request.PaymentRequest;
import dev.lest.ecommerce.Cart.Payment.request.ValidatePaymentRequest;
import dev.lest.ecommerce.Cart.Payment.response.PaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService service;

    @PostMapping
    public ResponseEntity<PaymentResponse> createPayment(@RequestBody PaymentRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(PaymentMapper
                        .map(service
                                .createPayment(PaymentMapper.map(request))
                        )
                );
    }

    @PostMapping("/validate")
    public ResponseEntity<PaymentResponse> validatePaymentOffCart(@RequestBody ValidatePaymentRequest paymentRequest) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(PaymentMapper
                        .map(service.
                                validatePayment(paymentRequest.type(), paymentRequest.cartId()
                                )
                        )
                );
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<PaymentResponse> getPayment(@PathVariable String cartId) {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(PaymentMapper
                        .map(service
                                .findPaymentByCartId(cartId)
                        )
                );
    }
}
