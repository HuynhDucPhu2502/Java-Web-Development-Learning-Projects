package me.huynhducphu.shoppingapp.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

/**
 * Admin 10/7/2025
 *
 **/
@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(unique = true)
    private String phoneNumber;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate customerSince;

    @OneToMany(mappedBy = "customer")
    @ToString.Exclude
    private List<Order> orders;

    @OneToMany(mappedBy = "customer")
    @ToString.Exclude
    private List<Comment> comments;

    @Column(nullable = false)
    private Boolean isActive = true;

}
