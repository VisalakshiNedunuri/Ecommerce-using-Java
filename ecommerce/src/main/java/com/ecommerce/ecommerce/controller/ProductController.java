
package com.ecommerce.ecommerce.controller;


import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.ecommerce.model.Product;
import com.ecommerce.ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }
    @PostMapping("/api/products")
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@Valid @RequestBody Product product) {
        return productService.saveProduct(product);
    
    }
   @GetMapping("/api/products/{id}")
   public Product getProductById(@PathVariable Integer id) {
       return productService.getProductById(id);
   }
   @PutMapping("/api/products/{id}")
   public Product updateProduct(
           @PathVariable Integer id,
          @Valid @RequestBody Product product) {
       return productService.updateProduct(id, product);
   }
   @DeleteMapping("/api/products/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public void deleteProduct(@PathVariable Integer id) {
       productService.deleteProduct(id);
   }

}
