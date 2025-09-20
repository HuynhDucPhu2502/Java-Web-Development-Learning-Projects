package me.huynhducphu.section_6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Admin 9/19/2025
 *
 **/
@Entity
@Table(name = "DANHMUC")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DanhMuc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MADM")
    private Long maDm;

    @Column(name = "TENDANHMUCH")
    private String tenDanhMuc;

    @Column(name = "NGUOIQUANLY")
    private String nguoiQuanLy;

    @Column(name = "GHICHU")
    private String ghiChu;

    @OneToMany(mappedBy = "danhMuc", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<TinTuc> tinTucList;
}