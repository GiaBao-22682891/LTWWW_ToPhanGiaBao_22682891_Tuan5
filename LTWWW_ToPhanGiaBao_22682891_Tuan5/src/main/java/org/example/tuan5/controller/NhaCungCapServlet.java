package org.example.tuan5.controller;

import java.io.*;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.tuan5.dao.NhaCungCapDAO;
import org.example.tuan5.dao.impl.NhaCungCapImpl;
import org.example.tuan5.model.NhaCungCap;
import org.example.tuan5.utils.JPAUtils;

@WebServlet(name = "nhaCungCapServlet", value = "/view/nha-cung-cap-servlet")
public class NhaCungCapServlet extends HttpServlet {
    public EntityManager em = JPAUtils.getEntityManager();
    private NhaCungCapDAO nhaCungCap;

    public void init() {
        this.nhaCungCap = new NhaCungCapImpl(em);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("nccList", nhaCungCap.getListNhaCungCap());
        req.getRequestDispatcher("/view/nha-cung-cap-list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public void destroy() {
    }
}