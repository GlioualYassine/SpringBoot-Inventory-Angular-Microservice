package com.example.inventoryservice.Entities;

import com.example.inventoryservice.Entities.Product;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="fullProduct",types= Product.class)
public interface ProductProjection
{
    public Long getId();
    public String getName();
    public double getPrice();
    public int getQty();
}
