package me.huynhducphu.shoppingapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Admin 10/7/2025
 *
 **/
@Entity
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category")
    @ToString.Exclude
    private List<Product> products;

}
