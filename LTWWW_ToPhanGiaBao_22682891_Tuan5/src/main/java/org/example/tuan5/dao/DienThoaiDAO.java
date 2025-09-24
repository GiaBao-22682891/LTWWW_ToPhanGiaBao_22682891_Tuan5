package org.example.tuan5.dao;

import org.example.tuan5.model.DienThoai;
import org.example.tuan5.model.NhaCungCap;

import java.util.List;

public interface DienThoaiDAO {
    public List<DienThoai> getListDienThoai(int maNhaCungCap) ;

    public void addDienThoai (DienThoai dienThoai) ;

    public void deleteDienThoai (DienThoai dienThoai) ;

    public DienThoai updateDienThoai (DienThoai dienThoai) ;
}
