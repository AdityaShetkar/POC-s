package com.reactivedb.service;

import com.reactivedb.dto.ProductDTO;
import com.reactivedb.repo.ProductRepo;
import com.reactivedb.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Flux<ProductDTO> getAllProducts() {
        return this.productRepo.findAll().map(AppUtils::entityToDto);
    }

    @Override
    public Mono<ProductDTO> getProduct(String id) {
        return this.productRepo.findById(id).map(AppUtils::entityToDto);
    }

    @Override
    public Flux<ProductDTO> getProductsInRange(double min, double max) {
        return this.productRepo.findByPriceBetween(Range.closed(min, max));
    }

    @Override
    public Mono<ProductDTO> saveProduct(Mono<ProductDTO> productDTOMono) {
        return productDTOMono.map(AppUtils::dtoToEntity)
                .flatMap(productRepo::insert)
                .map(AppUtils::entityToDto);
    }

    @Override
    public Mono<ProductDTO> updateProduct(Mono<ProductDTO> productDTOMono, String id){
        return this.productRepo.findById(id)
                .flatMap(p->productDTOMono.map(AppUtils::dtoToEntity)
                        .doOnNext(e->e.setProductId(id)))
                .flatMap(productRepo::save)
                .map(AppUtils::entityToDto);
    }

    @Override
    public Mono<Void> deleteProduct(String id){
        return this.productRepo.deleteById(id);
    }
}
