package com.example.projectwebburguer.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Collection;

@Data
@Entity
@Table(name = "DETAILS_ORDER")
public class DetailsOrderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long orderId;
    private long clientId;
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinTable(name = "details_order_product",
            joinColumns = @JoinColumn(name = "detail_order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private Collection<ProductRecord> productRecords;
    private int quantity;
    private double price;
}
