package com.chandkhat.ecommerce.web.order;

import com.chandkhat.ecommerce.web.AbstractEntity;
import com.chandkhat.ecommerce.web.cart.Cart;
import com.chandkhat.ecommerce.web.payment.Payment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "order")
public class Order extends AbstractEntity {

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus status;

    @Column(name = "shipped")
    private ZonedDateTime shipped;


    @OneToOne
    @JoinColumn(unique = true)
    private Payment payment;

    @Embedded
    private Address shipmentAddress;

    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private Set<OrderItem> orderItems;

    @OneToOne(mappedBy = "order")
    @JsonIgnore
    private Cart cart;


}