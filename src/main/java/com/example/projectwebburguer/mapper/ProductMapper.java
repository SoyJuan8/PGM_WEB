package com.example.projectwebburguer.mapper;

import com.example.projectwebburguer.model.ProductRecord;
import com.example.projectwebburguer.request.CreateProductRequest;

public class ProductMapper {

    public static ProductRecord toProductRecord(CreateProductRequest request) {
        ProductRecord productRecord = new ProductRecord();
        productRecord.setName(request.getName());
        productRecord.setCategory(request.getCategory());
        productRecord.setDescription(request.getDescription());
        productRecord.setPrice(request.getPrice());
        return productRecord;
    }

    public static ProductRecord toMapUpdate(ProductRecord productRecord, CreateProductRequest request) {
        productRecord.setName(request.getName());
        productRecord.setDescription(request.getDescription());
        productRecord.setPrice(request.getPrice());
        return productRecord;
    }
}
