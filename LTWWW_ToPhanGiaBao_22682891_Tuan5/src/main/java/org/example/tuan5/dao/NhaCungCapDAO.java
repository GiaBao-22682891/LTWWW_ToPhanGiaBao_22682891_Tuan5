package org.example.tuan5.dao;

import org.example.tuan5.model.NhaCungCap;

import java.util.List;

public interface NhaCungCapDAO {
    public List<NhaCungCap> getListNhaCungCap() ;

    public void addNhaCungCap(NhaCungCap nhaCungCap) ;

    public void deleteNhaCungCap(NhaCungCap nhaCungCap) ;

    public NhaCungCap updateNhaCungCap(NhaCungCap nhaCungCap) ;

    public NhaCungCap getNhaCungCap(int id) ;

}
