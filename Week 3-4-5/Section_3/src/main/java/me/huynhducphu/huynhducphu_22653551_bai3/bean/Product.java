package me.huynhducphu.huynhducphu_22653551_bai3.bean;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "products")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private String description;
    private int quantity;
    private double price;

    @Column(columnDefinition = "TEXT")
    private String imgUrl;

}
