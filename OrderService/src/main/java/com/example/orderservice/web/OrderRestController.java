package com.example.orderservice.web;

import com.example.orderservice.Entities.Order;
import com.example.orderservice.Model.Customer;
import com.example.orderservice.Model.Product;
import com.example.orderservice.Repository.OrderRepository;
import com.example.orderservice.Repository.ProductItemRepository;
import com.example.orderservice.services.CustomerRestClientService;
import com.example.orderservice.services.InventoryRestClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {
    private OrderRepository orderRepository ;
    private ProductItemRepository productItemRepository ;
    private CustomerRestClientService customerRestClientService ;
    private InventoryRestClientService inventoryRestClientService;

    public OrderRestController(OrderRepository orderRepository, ProductItemRepository productItemRepository, CustomerRestClientService customerRestClientService, InventoryRestClientService inventoryRestClientService) {
        this.orderRepository = orderRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClientService = customerRestClientService;
        this.inventoryRestClientService = inventoryRestClientService;
    }
    @GetMapping("/fullOrder/{id}") // path ; /fullOrder --> this Controller
    //  path : /orders --> spring data rest
    public Order getOrder(@PathVariable Long id){
        Order order = orderRepository.findById(id).get();
        Customer customer = customerRestClientService.customerById(order.getCustomerId());
        order.setCustomer(customer);
        order.getProductItems().forEach(productItem -> {
            Product product = inventoryRestClientService.productById(productItem.getId());
            productItem.setProduct(product);
        });
        return order ;
    }
}
