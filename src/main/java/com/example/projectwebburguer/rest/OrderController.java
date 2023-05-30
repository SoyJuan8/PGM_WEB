package com.example.projectwebburguer.rest;

import com.example.projectwebburguer.model.DetailsOrderRecord;
import com.example.projectwebburguer.model.OrderRecord;
import com.example.projectwebburguer.request.ProductIdReques;
import com.example.projectwebburguer.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order/list")
    public List<OrderRecord> findAll(){
        return orderService.findAll();
    }

    @GetMapping("/order/{id}")
    public OrderRecord findById(@PathVariable Long id){
        return orderService.findById(id);
    }

    @GetMapping("/details/list")
    public List<DetailsOrderRecord> findAllDetails(){
        return orderService.findAllDetails();
    }

    @PostMapping("/buy/{clientId}/{productId}")
    public DetailsOrderRecord buyProduct(@PathVariable long clientId, @PathVariable long productId){
        return orderService.buyProduct(clientId, productId);
    }

    @GetMapping("/details/{id}")
    public DetailsOrderRecord findDetailsById(@PathVariable long id){
        return orderService.findDetailsById(id);
    }

    @PostMapping("/{clientId}")
    public DetailsOrderRecord saveDetails(@PathVariable long clientId ,@RequestBody List<ProductIdReques> request){
        return orderService.saveDetails(clientId ,request);
    }
}
