package com.chandkhat.ecommerce.web.cart;

import com.chandkhat.ecommerce.web.customer.CustomerDto;
import com.chandkhat.ecommerce.web.order.Order;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartDto {
    private Long id;
    private Order order;
    private CustomerDto customerDto;
    private  String status;
}
