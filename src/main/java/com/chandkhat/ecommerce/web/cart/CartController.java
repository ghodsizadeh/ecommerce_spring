package com.chandkhat.ecommerce.web.cart;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.chandkhat.ecommerce.web.Web.API;

@RequiredArgsConstructor
@RestController
@RequestMapping( API + "/carts")
public class CartController {

    private  final  CartService cartService;

    @GetMapping
    public List<CartDto> findALL() {
        return  this.cartService.findAll();
    }

    @GetMapping("/active")
    public List<CartDto> findAllActiveCarts() {
        return  this.cartService.findAllActiveCarts();
    }

    @GetMapping("/{id}")
    public CartDto findById(@PathVariable Long id){
        return  this.cartService.findById(id);
    }

    @PostMapping("/customer/{id}")
    public  CartDto create(@PathVariable("id") Long customerId){
        return  this.cartService.create(customerId);
    }

    @DeleteMapping("/{id}")
    public  void delete(@PathVariable Long id) {
        this.cartService.delete(id );
    }
}
