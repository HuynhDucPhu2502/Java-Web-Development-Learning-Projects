package me.huynhducphu.section_6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Admin 9/19/2025
 *
 **/
@Entity
@Table(name = "TINTUC")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TinTuc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
