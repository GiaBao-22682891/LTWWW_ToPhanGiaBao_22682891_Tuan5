package org.example.tuan5.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
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

import java.io.IOException;

@WebServlet(urlPatterns = "/them-san-pham-servlet")
public class ThemSanPhamServlet extends HttpServlet {
    private DienThoaiDAO dienThoaiDAO;
    private NhaCungCapDAO nhaCungCapDAO;

    @Override
    public void init() throws ServletException {
        EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        if(emf != null) {
            EntityManager entityManager = emf.createEntityManager();
            this.dienThoaiDAO = new DienThoaiImpl(entityManager);
            this.nhaCungCapDAO = new NhaCungCapImpl(entityManager);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("nccList", nhaCungCapDAO.getListNhaCungCap());
        req.getRequestDispatcher("/view/them-san-pham.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tendt = req.getParameter("tenDT");
        String cauHinh = req.getParameter("cauHinh");
        int namSX = Integer.parseInt(req.getParameter("namSX"));
        String hinhAnh = req.getParameter("hinhAnh");
        int nccId = Integer.parseInt(req.getParameter("nccId"));
        dienThoaiDAO.addDienThoai(
                DienThoai.builder()
                        .tenDT(tendt)
                        .cauHinh(cauHinh)
                        .namSX(namSX)
                        .hinhAnh(hinhAnh)
                        .nhaCungCap(nhaCungCapDAO.getNhaCungCap(nccId))
                        .build()
        );

        req.setAttribute("nccList", nhaCungCapDAO.getListNhaCungCap());
        req.getRequestDispatcher("/view/nha-cung-cap-list.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {

    }
}
