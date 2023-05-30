package com.example.projectwebburguer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Entity
@Data
@Table(name = "PRODUCT")
public class ProductRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String category;
    private String description;
    private double price;
    private boolean car;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "productRecords")
    @JsonIgnore
    private Collection<DetailsOrderRecord> detailsOrderRecords;
}
