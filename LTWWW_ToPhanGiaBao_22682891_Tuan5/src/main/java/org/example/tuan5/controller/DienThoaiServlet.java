package org.example.tuan5.controller;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.tuan5.dao.DienThoaiDAO;
import org.example.tuan5.dao.NhaCungCapDAO;
import org.example.tuan5.dao.impl.DienThoaiImpl;
import org.example.tuan5.dao.impl.NhaCungCapImpl;
import org.example.tuan5.model.DienThoai;
import org.example.tuan5.utils.JPAUtils;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DienThoaiServlet", value = "/dien-thoai-servlet")
public class DienThoaiServlet extends HttpServlet {
    public EntityManager em = JPAUtils.getEntityManager();
    private DienThoaiDAO dienThoaiDAO;

    public void init() {
        this.dienThoaiDAO = new DienThoaiImpl(em);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nccIdParam = req.getParameter("nccId");
        String test = req.getParameter("tendt");
        System.out.println(test);
        if (nccIdParam != null) {
            int nccId = Integer.parseInt(nccIdParam);
            List<DienThoai> dienThoaiList = dienThoaiDAO.getListDienThoai(nccId);

            req.setAttribute("dienThoaiList", dienThoaiList);
            req.getRequestDispatcher("/view/danh-sach-dien-thoai-NCC.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/view/nha-cung-cap-list.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public void destroy() {
    }
}