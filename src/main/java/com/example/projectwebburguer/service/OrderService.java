package com.example.projectwebburguer.service;

import com.example.projectwebburguer.model.DetailsOrderRecord;
import com.example.projectwebburguer.model.OrderRecord;
import com.example.projectwebburguer.model.ProductRecord;
import com.example.projectwebburguer.repository.DetailsOrderRepository;
import com.example.projectwebburguer.repository.OrderRepository;
import com.example.projectwebburguer.repository.PrductRepository;
import com.example.projectwebburguer.request.ProductIdReques;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final PrductRepository prductRepository;
    private final DetailsOrderRepository detailsOrderRepository;

    public OrderService(OrderRepository orderRepository, PrductRepository prductRepository, DetailsOrderRepository detailsOrderRepository) {
        this.orderRepository = orderRepository;
        this.prductRepository = prductRepository;
        this.detailsOrderRepository = detailsOrderRepository;
    }

    public List<DetailsOrderRecord> findAllDetails(){
        return detailsOrderRepository.findAll();
    }

    public DetailsOrderRecord findDetailsById(Long id){
        return detailsOrderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public List<OrderRecord> findAll(){
        return orderRepository.findAll();
    }

    public OrderRecord findById(Long id){
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public OrderRecord save(OrderRecord orderRecord){
        return orderRepository.save(orderRecord);
    }

    public DetailsOrderRecord saveDetails(long clientId, List<ProductIdReques> detailsOrderRecord){
        double price = 0;
        int quantity = 0;
        List<ProductRecord> productRecords = detailsOrderRecord.stream().map(
                products -> {
                    ProductRecord product = prductRepository.findById((long) products.getId()).orElseThrow(() -> new RuntimeException("Product not found"));
                    return product;
                }).collect(Collectors.toList());
        for (ProductRecord productRecord : productRecords) {
            price += productRecord.getPrice();
            quantity++;
            productRecord.setCar(false);
        }
        OrderRecord orderRecord = new OrderRecord();
        orderRecord.setDate(LocalDateTime.now());
        orderRecord.setTotal(price);
        orderRepository.save(orderRecord);
        DetailsOrderRecord detailsOrderRecord1 = new DetailsOrderRecord();
        detailsOrderRecord1.setOrderId(orderRecord.getId());
        detailsOrderRecord1.setProductRecords(productRecords);
        detailsOrderRecord1.setClientId(clientId);
        detailsOrderRecord1.setPrice(price);
        detailsOrderRecord1.setQuantity(quantity);
        return detailsOrderRepository.save(detailsOrderRecord1);
    }

    public DetailsOrderRecord buyProduct(long clientId, long productId){
        ProductRecord productRecord = prductRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        OrderRecord orderRecord = new OrderRecord();
        orderRecord.setDate(LocalDateTime.now());
        orderRecord.setTotal(productRecord.getPrice());
        orderRepository.save(orderRecord);
        DetailsOrderRecord detailsOrderRecord = new DetailsOrderRecord();
        detailsOrderRecord.setOrderId(orderRecord.getId());
        detailsOrderRecord.setProductRecords(List.of(productRecord));
        detailsOrderRecord.setClientId(clientId);
        detailsOrderRecord.setPrice(productRecord.getPrice());
        detailsOrderRecord.setQuantity(1);
        return detailsOrderRepository.save(detailsOrderRecord);
    }


}
