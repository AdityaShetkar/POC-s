package com.reactivedb.repo;

import com.reactivedb.dto.ProductDTO;
import com.reactivedb.model.Product;
import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepo extends ReactiveMongoRepository<Product, String> {

    Flux<ProductDTO> findByPriceBetween(Range<Double> priceRange);
}
