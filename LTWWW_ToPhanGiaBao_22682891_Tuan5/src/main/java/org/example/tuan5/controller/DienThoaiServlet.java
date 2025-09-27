package org.example.tuan5.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
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
import org.example.tuan5.model.NhaCungCap;
//import org.example.tuan5.utils.JPAUtils;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DienThoaiServlet", value = "/dien-thoai-servlet")
public class DienThoaiServlet extends HttpServlet {
    private DienThoaiDAO dienThoaiDAO;
    private NhaCungCapDAO nhaCungCapDAO;

    public void init() {
        // lấy emf trong servlet context
        EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        System.out.println(emf);
        if(emf != null) {
            EntityManager entityManager = emf.createEntityManager();
            this.dienThoaiDAO = new DienThoaiImpl(entityManager);
            this.nhaCungCapDAO = new NhaCungCapImpl(entityManager);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nccIdParam = req.getParameter("nccId");
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
        req.getRequestDispatcher("/nha-cung-cap-servlet").forward(req, resp);

    }

    public void destroy() {
    }
}