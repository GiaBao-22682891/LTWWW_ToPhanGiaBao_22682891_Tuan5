package org.example.tuan5.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table (name = "NhaCungCap")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
@ToString(exclude = "dienThoais")
public class NhaCungCap {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int maNCC;
    private String tenNCC;
    private String diaChi;
    private String soDienThoai;

    @OneToMany (mappedBy = "nhaCungCap")
    private List<DienThoai> dienThoais;

}
