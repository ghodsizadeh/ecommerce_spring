package com.chandkhat.ecommerce.web.payment;

import com.chandkhat.ecommerce.web.AbstractEntity;
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
@EqualsAndHashCode
@Entity
@Table(name = "payment")
public class Payment extends AbstractEntity {
    @Column(name = "paypal_payment_id")
    private String paypalPaymentId;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private PaymentStatus status;
    @OneToOne
    @JoinColumn(unique = true)
    private Order order;
}

