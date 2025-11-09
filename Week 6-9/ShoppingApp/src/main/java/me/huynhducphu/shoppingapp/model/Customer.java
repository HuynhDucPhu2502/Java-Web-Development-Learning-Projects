package me.huynhducphu.shoppingapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
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

    @Column(name = "phone_number", length = 30, nullable = false)
    @Size(max = 30, message = "SDT tối đa 30 ký tự")
    @NotBlank(message = "SDT không được để trống")
    private String phoneNumber;

    @NotBlank(message = "Tên KH không được để trống")
    @Size(max = 255, message = "Tên KH tối đa 255 ký tự")
    private String name;

    @NotNull(message = "Ngày tham gia không được để trống")
    @PastOrPresent(message = "Ngày tham gia không được lớn hơn hôm nay")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate customerSince;

    @OneToMany(mappedBy = "customer")
    @ToString.Exclude
    private List<Order> orders;

    @Column(nullable = false)
    private Boolean isActive = true;

}
