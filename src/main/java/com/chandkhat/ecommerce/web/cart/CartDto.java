package com.chandkhat.ecommerce.web.cart;

import com.chandkhat.ecommerce.web.customer.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartDto {
    private Long id;
    private Long orderId;
    private CustomerDto customerDto;
    private  String status;
}
