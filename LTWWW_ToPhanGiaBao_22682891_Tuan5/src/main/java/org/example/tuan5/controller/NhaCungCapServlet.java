package org.example.tuan5.controller;

import java.io.*;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.tuan5.dao.NhaCungCapDAO;
import org.example.tuan5.dao.impl.NhaCungCapImpl;
import org.example.tuan5.utils.JPAUtils;

@WebServlet(name = "nhaCungCapServlet", value = "/nha-cung-cap-servlet")
public class NhaCungCapServlet extends HttpServlet {
    public EntityManager em = JPAUtils.getEntityManager();
    private NhaCungCapDAO nhaCungCapDAO;

    public void init() {
        this.nhaCungCapDAO = new NhaCungCapImpl(em);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("nccList", nhaCungCapDAO.getListNhaCungCap());
        req.getRequestDispatcher("/view/nha-cung-cap-list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public void destroy() {
    }
}