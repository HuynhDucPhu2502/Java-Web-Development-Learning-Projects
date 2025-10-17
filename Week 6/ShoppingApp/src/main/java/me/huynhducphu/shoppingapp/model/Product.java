package me.huynhducphu.shoppingapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Admin 10/7/2025
 *
 **/
@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;
    private Double price;
    private Boolean inStock;

    @OneToMany(mappedBy = "product")
    @ToString.Exclude
    private List<Comment> comments;

    @OneToMany(mappedBy = "product")
    @ToString.Exclude
    private List<OrderLine> orderLines;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(nullable = false)
    private Boolean isActive = true;

}
