package com.chandkhat.ecommerce.web.cart;


import com.chandkhat.ecommerce.web.customer.Customer;
import com.chandkhat.ecommerce.web.customer.CustomerRepository;
import com.chandkhat.ecommerce.web.order.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class CartService {
    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;
    private final OrderService orderService;

    public static CartDto mapToDto(Cart cart) {
        if (cart == null) {
            return null;
        }
        return new CartDto(
                cart.getId(),
                cart.getOrder(),
                CustsomerSerice.mapToDto(cart.getCustomer()),
                cart.getStatus().name()
        );
    }

    public List<CartDto> findAllActiveCarts() {
        return this.cartRepository.findByStatus(CartStatus.NEW)
                .stream()
                .map(CartService::mapToDto)
                .collect(Collectors.toList());
    }

    public CartDto create(Long customerId) {
        if (this.getActiveCart(customerId) == null) {
            Customer customer = this.customerRepository.findById(customerId)
                    .orElseThrow(() -> new IllegalStateException("The Customer doesn't exist!"));
            Cart cart = new Cart(
                    null,
                    customer,
                    CartStatus.NEW
            );
            Order order = this.orderService.create(cart);
            cart.setOrder(order);

            return mapToDto(this.cartRepository.save(cart));

        } else {
            throw new IllegalStateException("There is already an acive cart");
        }
    }

    @Transactional(readOnly = true)
    public CartDto findById(Long id) {
        log.debug("Request to get Cart : {}", id);
        return this.cartRepository.findById(id).map(CartService::mapToDto).orElse(null);
    }

    public void delete(Long id) {
        log.debug("Request to delete Cart: {}", id);
        Cart cart = this.cartRepository.findById(id).orElseThrow(() -> new IllegalStateException("Cannot find cart with id " + id));
        cart.setStatus(CartStatus.CANCELED);
        this.cartRepository.save(cart);

    }

    public CartDto getActiveCart(Long customerId) {
        List<Cart> carts = this.cartRepository
                .findByStatusAndCustomerId(CartStatus.NEW, customerId);
        if (carts != null) {
            if (carts.size() == 1) {
                return mapToDto(carts.get(0));
            }
            if (carts.size() > 1) {
                throw new IllegalStateException("Many active carts detected!!!");
            }
        }
        return null;
    }
}




