package com.reactivedb.utils;

import com.reactivedb.dto.ProductDTO;
import com.reactivedb.model.Product;
import org.springframework.beans.BeanUtils;

public class AppUtils {

    public static ProductDTO entityToDto(Product product) {
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product, productDTO);
        return productDTO;
    }

    public static Product dtoToEntity(ProductDTO productDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        return product;
    }
}
