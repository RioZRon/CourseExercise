package servlet.registration;

import bean.main.A10;
import bean.register.A20;
import service.serviceIMP;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TurnPatientDetailServlet", urlPatterns = "/servlet/registration/TurnPatientDetailServlet")
public class TurnPatientDetail extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int a201 = Integer.valueOf(req.getParameter("a201"));
        serviceIMP serviceIMP = new serviceIMP();
        A20 a20 = serviceIMP.FindPatient(a201);
//        System.out.println(a10.toString());
        req.getSession().setAttribute("a20", a20);
        req.getRequestDispatcher(req.getContextPath() + "/Content/HTML/registration/patientDetail.jsp").forward(req,resp);
    }
}
