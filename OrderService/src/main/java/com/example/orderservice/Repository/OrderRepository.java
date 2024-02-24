package com.example.orderservice.Repository;

import com.example.orderservice.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import  java.util.* ;
@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order,Long> {
    @RestResource(path = "bycustomerId")
    List<Order> findByCustomerId(@Param("customerId") Long customerId);

}

