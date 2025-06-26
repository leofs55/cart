package dev.lest.ecommerce.Cart.Platzi.client.response;

import java.io.Serializable;
import java.math.BigDecimal;

public record PlatziRecordResponse(Long id,
                                   String title,
                                   BigDecimal price,
                                   String description) implements Serializable {
}
