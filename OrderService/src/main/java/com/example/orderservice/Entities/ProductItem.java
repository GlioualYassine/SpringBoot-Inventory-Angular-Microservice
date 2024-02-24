package com.example.orderservice.Entities;

import com.example.orderservice.Model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class ProductItem {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private Long productId  ; // the foreign KEY to the real product
   @Transient
   private Product product ;
   private double price ;
   private int qty ; // qty tu produit dans la commande
   private double discount ;
   @ManyToOne
   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // pour dire que cette propriété est en mode écriture seulement pas de lecture
   private Order order;
   public double getAmount(){
      return (price * qty) *(1-discount);
   }
}
