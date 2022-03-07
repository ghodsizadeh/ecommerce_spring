package com.chandkhat.ecommerce.web.cart;

import com.chandkhat.ecommerce.web.AbstractEntity;
import com.chandkhat.ecommerce.web.customer.Customer;
import com.chandkhat.ecommerce.web.order.Order;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "cart")
public class Cart extends AbstractEntity {

    @OneToOne
    @JoinColumn(unique = true)
    private Order order;

    @ManyToMany
    private Customer customer;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CartStatus status;

    public Cart(Customer customer){
        this.customer = customer;
        this.status = CartStatus.NEW;

    }


}