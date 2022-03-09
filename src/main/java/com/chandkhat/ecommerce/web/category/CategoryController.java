package com.chandkhat.ecommerce.web.category;


import com.chandkhat.ecommerce.web.cart.CartDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.chandkhat.ecommerce.web.Web.API;

@RequiredArgsConstructor
@RestController
@RequestMapping(API + "/categories")
public class CategoryController {
    private  final  CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> findAll(){
        return  this.categoryService.findAll();
    }
    @GetMapping("/{id}")
    public CategoryDto findById(@PathVariable Long id) {
        return this.categoryService.findById(id);
    }

    @PostMapping
    public CategoryDto create(CategoryDto categoryDto) {
        return  this.categoryService.create(categoryDto);
    }

    @DeleteMapping("/{id}")
    public  void  delete(@PathVariable Long id) {
         this.categoryService.delete(id);
    }
}
