package dev.lest.ecommerce.Cart.Payment;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PaymentRepository extends MongoRepository<Payment, String> {

    Optional<Payment> findByCartIdAndType(String cartId, PaymentType type);

    Optional<Payment> findByCartId(String cartId);
}
