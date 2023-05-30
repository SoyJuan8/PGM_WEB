package com.example.projectwebburguer.request;

import lombok.Data;

@Data
public class CreateProductRequest {
    private String name;
    private String category;
    private String description;
    private double price;
}
