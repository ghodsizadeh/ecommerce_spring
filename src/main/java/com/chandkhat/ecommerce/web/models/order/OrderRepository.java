package com.chandkhat.ecommerce.web.models.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    public List<Order> findByCartCustomer_Id(Long id);
}