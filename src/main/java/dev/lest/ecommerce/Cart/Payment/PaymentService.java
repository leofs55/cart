package dev.lest.ecommerce.Cart.Payment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository repository;

    public Payment findPaymentByTypeAndCartId(PaymentType type, String cartId) {

        Optional<Payment> optionalPayment = repository.findByCartIdAndType(cartId, type);

        if (optionalPayment.isPresent()) {
            return optionalPayment.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Objeto não encontrado");

    }

    public Payment findPaymentByCartId(String cartId) {

        Optional<Payment> optionalPayment = repository.findByCartId(cartId);

        if (optionalPayment.isPresent()) {
            return optionalPayment.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Objeto não encontrado");

    }

    public Payment validatePayment(Payment paymentRequest) {

        Payment payment = findPaymentByTypeAndCartId(paymentRequest.getType(), paymentRequest.getCartId());

        payment.setValidated(Boolean.TRUE);

        return repository.save(payment);

    }

    public void paymentPending(PaymentType type, String cartId) {

        repository.findByCartIdAndType(cartId, type)
                .ifPresent(paymentPending -> {
                            throw new ResponseStatusException(HttpStatus.FORBIDDEN,
                                    "Já existe um pagamento aberto para este usuario!");
                        }
                );

    }

    public Payment createPayment(Payment payment) {

        try {

            paymentPending(payment.getType(), payment.getCartId());

            payment.setValidated(Boolean.FALSE);

            return repository.save(payment);

        } catch (ResponseStatusException e) {

            throw new ResponseStatusException(HttpStatus.FORBIDDEN,
                    "Já existe um pagamento aberto para este usuario!");
        }

    }
}
