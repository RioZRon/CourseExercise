package servlet.outpatientDoctor;

import bean.outpatientdocter.A21;
import bean.register.A20;
import service.serviceIMP;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TurnprescriptionDetailServlet", urlPatterns = "/servlet/outpatientDoctor/TurnprescriptionDetailServlet")
public class TurnprescriptionDetail extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stmp = req.getParameter("a201");
//        System.out.println(stmp);
        int a201 = Integer.valueOf(stmp);
        System.out.println("-----ceshi1-------");
        serviceIMP serviceIMP = new serviceIMP();
        A20 a20 = serviceIMP.FindPatient(a201);
//        System.out.println("-----ceshi1-------");
        //搜索a21 如果为空建立一个空的a21
        A21 a21 = serviceIMP.FindMedicalrecord(a201);
        if (a21 == null) {
            a21 = new A21(a201);
            serviceIMP.addEmptyFindMedicalrecord(a21);
        }
        System.out.println("a21 = " + a21);
        req.getSession().setAttribute("a20", a20);
        req.getSession().setAttribute("a21", a21);
//        req.getRequestDispatcher(req.getContextPath() + "/Content/HTML/outpatientDoctor/patientDetail.jsp").forward(req,resp);
        resp.sendRedirect(req.getContextPath() + "/Content/HTML/outpatientDoctor/patientDetail.jsp");
    }
}
