package org.example.tuan5.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.tuan5.dao.NhaCungCapDAO;
import org.example.tuan5.model.NhaCungCap;
//import org.example.tuan5.utils.JPAUtils;

import java.util.ArrayList;
import java.util.List;

public class NhaCungCapImpl implements NhaCungCapDAO {
    public EntityManager em;

    public NhaCungCapImpl(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public List<NhaCungCap> getListNhaCungCap() {
        try  {
            return em.createQuery("select ncc from NhaCungCap ncc", NhaCungCap.class)
                    .getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }
//        finally {
//            em.close();
//        }
        return null;
    }

    @Override
    public void addNhaCungCap(NhaCungCap nhaCungCap) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(nhaCungCap);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    @Override
    public void deleteNhaCungCap(NhaCungCap nhaCungCap) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.remove(nhaCungCap);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

    }

    @Override
    public NhaCungCap updateNhaCungCap(NhaCungCap nhaCungCap) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(nhaCungCap);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return nhaCungCap;
    }

    @Override
    public NhaCungCap getNhaCungCap(int id) {
        try {
            return em.find(NhaCungCap.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
