
package com.ecommerce.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.model.Product;
import com.ecommerce.ecommerce.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
       return productRepository.save(product);
    }
    public Product getProductById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() ->
                    new org.springframework.web.server.ResponseStatusException(
                        org.springframework.http.HttpStatus.NOT_FOUND,
                        "Product not found"
                    )
                );
    }
    public Product updateProduct(Integer id, Product updatedProduct) {
        if (!productRepository.existsById(id)) {
            throw new org.springframework.web.server.ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND,
                    "Product not found");
        }

        updatedProduct.setId(id);
        return productRepository.save(updatedProduct);
    }
    public void deleteProduct(Integer id) {
        if (!productRepository.existsById(id)) {
            throw new org.springframework.web.server.ResponseStatusException(
                org.springframework.http.HttpStatus.NOT_FOUND,
                "Product not found"
            );
        }

        productRepository.deleteById(id);
    }

}
