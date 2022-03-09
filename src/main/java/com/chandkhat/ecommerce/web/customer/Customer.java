package com.chandkhat.ecommerce.web.customer;

import com.chandkhat.ecommerce.web.AbstractEntity;
import com.chandkhat.ecommerce.web.cart.Cart;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "customer")
public class Customer extends AbstractEntity {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "telephone")
    private String telephone;

    @Column(name = "enabled")
    private Boolean enabled;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private Set<Cart> carts;
}