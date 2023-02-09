package com.reactivedb.controller;

import com.reactivedb.dto.ProductDTO;
import com.reactivedb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Flux<ProductDTO> getAllProducts(){
        return this.productService.getAllProducts();
    }

    @GetMapping("/byId")
    public Mono<ProductDTO> getProduct(@RequestParam("id") String id){
        return this.productService.getProduct(id);
    }

    @GetMapping("/product-range")
    public Flux<ProductDTO> getProductsInRange(@RequestParam("min") Double min, @RequestParam("max") Double max){
        return this.productService.getProductsInRange(min, max);
    }

    @PutMapping("/update")
    public Mono<ProductDTO> updateProduct(@RequestBody Mono<ProductDTO> productDTOMono, @RequestParam("id") String id){
        return this.productService.updateProduct(productDTOMono, id);
    }

    @PostMapping("/save")
    public Mono<ProductDTO> saveProduct(@RequestBody Mono<ProductDTO> productDTOMono){
        return this.productService.saveProduct(productDTOMono);
    }

    @DeleteMapping("/delete")
    public Mono<Void> deleteProduct(@RequestParam("id") String id){
        return this.productService.deleteProduct(id);
    }

}
