package com.chandkhat.ecommerce.web.models.product;

import com.chandkhat.ecommerce.web.models.AbstractEntity;
import com.chandkhat.ecommerce.web.models.category.Category;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "product")
public class Product extends AbstractEntity {

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;
    @NotNull
    @Column(name = "description", nullable = false)
    private String description;
    @NotNull
    @Column(name = "price", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;
    @Column(name = "quantity")
    private Integer quantity;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ProductStatus status;
    @Column(name = "sales_counter")
    private Integer salesCounter;
    @OneToMany
    private Set<Review> reviews = new HashSet<>();
    @ManyToOne
    private Category category;
}