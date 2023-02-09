package com.reactivedb.service;

import com.reactivedb.dto.ProductDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Flux<ProductDTO> getAllProducts();

    Mono<ProductDTO> getProduct(String id);

    Flux<ProductDTO> getProductsInRange(double min, double max);

    Mono<ProductDTO> saveProduct(Mono<ProductDTO> productDTOMono);

    Mono<ProductDTO> updateProduct(Mono<ProductDTO> productDTOMono, String id);

    Mono<Void> deleteProduct(String id);
}
