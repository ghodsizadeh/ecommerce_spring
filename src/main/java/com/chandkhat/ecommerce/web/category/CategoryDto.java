package com.chandkhat.ecommerce.web.category;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryDto {
    private Long id;
    private String name;
    private String descriptions;
    private Set<ProductDto> products;
}
