package com.chandkhat.ecommerce.web.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByStatus(CartStatus status);
    List<Cart> findByStatusAndCustomerId(CartStatus status, Long customerId);
}
