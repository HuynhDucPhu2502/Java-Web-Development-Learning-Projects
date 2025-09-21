package me.huynhducphu.midterm2.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Admin 9/21/2025
 **/
@Entity
@Table(name = "TINTUC")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TinTuc {

    @Id
    @Column(name = "MATT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long maTT;

    @Column(name = "TIEUDE")
    private String tieuDe;

    @Column(name = "NOIDUNGTT")
    private String noiDungTT;

    @Column(name = "LIENKET")
    private String lienKet;

    @ManyToOne
    @JoinColumn(name = "MADM")
    @ToString.Exclude
    private DanhMuc danhMuc;

}
