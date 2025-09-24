package org.example.tuan5.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "DienThoai")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
public class DienThoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int maDT;
    private String tenDT;
    private int namSX;
    private String cauHinh;

    @ManyToOne
    @JoinColumn(name = "maNCC")
    private NhaCungCap nhaCungCap;

    private String hinhAnh;


}
