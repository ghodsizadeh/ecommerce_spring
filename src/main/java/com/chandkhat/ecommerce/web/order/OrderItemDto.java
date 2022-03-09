package com.chandkhat.ecommerce.web.order;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderItemDto {
    private  Long id;
    private Long quantity;
    private Long productId;
    private Long orderId;
}
