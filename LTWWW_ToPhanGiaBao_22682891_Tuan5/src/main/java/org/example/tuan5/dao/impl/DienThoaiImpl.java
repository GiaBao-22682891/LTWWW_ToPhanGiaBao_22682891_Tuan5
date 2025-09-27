package org.example.tuan5.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.example.tuan5.dao.DienThoaiDAO;
import org.example.tuan5.dao.NhaCungCapDAO;
import org.example.tuan5.model.DienThoai;
import org.example.tuan5.model.NhaCungCap;
//import org.example.tuan5.utils.JPAUtils;

import java.util.List;

public class DienThoaiImpl implements DienThoaiDAO {
    public EntityManager em;

    public DienThoaiImpl(EntityManager entityManager) {
        this.em = entityManager;
    }


    @Override
    public List<DienThoai> getListDienThoai(int maNhaCungCap) {
        String sql =
                "SELECT dt from DienThoai dt "
               + "WHERE dt.nhaCungCap.id = :nhaCungCap";

        try {
            TypedQuery<DienThoai> query = em.createQuery(sql, DienThoai.class);
            query.setParameter("nhaCungCap", maNhaCungCap);

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addDienThoai(DienThoai dienThoai) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(dienThoai);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    @Override
    public void deleteDienThoai(DienThoai dienThoai) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.remove(dienThoai);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    @Override
    public DienThoai updateDienThoai(DienThoai dienThoai) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(dienThoai);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return dienThoai;
    }
}
