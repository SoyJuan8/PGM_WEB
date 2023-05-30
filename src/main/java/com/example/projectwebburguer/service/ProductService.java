package com.example.projectwebburguer.service;

import com.example.projectwebburguer.mapper.ProductMapper;
import com.example.projectwebburguer.model.ProductRecord;
import com.example.projectwebburguer.repository.PrductRepository;
import com.example.projectwebburguer.request.CreateProductRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final PrductRepository prductRepository;

    public ProductService(PrductRepository prductRepository) {
        this.prductRepository = prductRepository;
    }

    public List<ProductRecord> findAll(){
        return prductRepository.findAll();
    }

    public List<ProductRecord> findAllByCategory(String category){
        return prductRepository.findAllByCategoryIs(category);
    }

    public List<ProductRecord> findAllCarIsTrue(){
        return prductRepository.findAllByCarIsTrue();
    }

    public ProductRecord updateCar(long id){
        ProductRecord productRecord = prductRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        productRecord.setCar(true);
        return prductRepository.save(productRecord);
    }

    public ProductRecord updateDeleteCar(long id){
        ProductRecord productRecord = prductRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        productRecord.setCar(false);
        return prductRepository.save(productRecord);
    }
    public ProductRecord findById(Long id){
        return prductRepository.findById(id).get();
    }

    public ProductRecord save(CreateProductRequest request){
        return prductRepository.save(ProductMapper.toProductRecord(request));
    }

    public ProductRecord update(Long id, CreateProductRequest request){
        ProductRecord productRecord = prductRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return prductRepository.save(ProductMapper.toMapUpdate(productRecord, request));
    }
}
