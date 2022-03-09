package com.chandkhat.ecommerce.web.category;

import com.chandkhat.ecommerce.web.product.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class CategoryDto {
    private Long id;
    private String name;
    private String description;
    private Set<ProductDto> products;
}
