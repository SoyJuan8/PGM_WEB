package com.example.projectwebburguer.rest;

import com.example.projectwebburguer.model.ProductRecord;
import com.example.projectwebburguer.request.CreateProductRequest;
import com.example.projectwebburguer.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductRecord> findAll(){
        return productService.findAll();
    }

    @GetMapping("/category")
    public List<ProductRecord> findAllByCategory(@RequestParam String category){
        return productService.findAllByCategory(category);
    }

    @PutMapping("/car/{id}")
    public ProductRecord updateCar(@PathVariable long id){
        return productService.updateCar(id);
    }

    @PutMapping("/car/delete/{id}")
    public ProductRecord updateDeleteCar(@PathVariable long id){
        return productService.updateDeleteCar(id);
    }

    @GetMapping("/join/car")
    public List<ProductRecord> findAllCarIsTrue(){
        log.info("Requesting all products with car true");
        return productService.findAllCarIsTrue();
    }

    @GetMapping("/{id}")
    public ProductRecord findById(@PathVariable long id){
        return productService.findById(id);
    }

    @PostMapping
    public ProductRecord save(@RequestBody CreateProductRequest request){
        return productService.save(request);
    }
}
