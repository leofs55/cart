package dev.lest.ecommerce.Cart.Cart;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface CartRepository extends MongoRepository<Cart, String> {

    Optional<Cart> findByClientIdAndStatus(Long client, Status status);

}
