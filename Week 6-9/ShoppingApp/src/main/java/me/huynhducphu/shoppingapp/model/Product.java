package me.huynhducphu.shoppingapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
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

    @NotBlank(message = "Tên sản phẩm không được để trống")
    @Size(max = 255, message = "Tên sản phẩm tối đa 255 ký tự")
    private String name;

    @NotNull(message = "Giá sản phẩm không được null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Giá sản phẩm phải > 0")
    private Double price;

    @NotNull(message = "Trạng thái tồn kho không được null")
    private Boolean inStock;

    @OneToMany(mappedBy = "product")
    @ToString.Exclude
    private List<Comment> comments;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<OrderLine> orderLines;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(nullable = false)
    private Boolean isActive = true;

}
