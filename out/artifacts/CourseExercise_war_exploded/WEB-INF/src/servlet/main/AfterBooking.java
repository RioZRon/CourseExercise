package servlet.main;

import bean.register.A20;
import service.serviceIMP;
import tools.StringTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AfterBookingServlet", urlPatterns = "/servlet/main/AfterBookingServlet")
public class AfterBooking extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----ceshi1-------");
        String name = req.getParameter("name");
        String identityCard = req.getParameter("identityCard");
        String phoneNumber = req.getParameter("phoneNumber");
        serviceIMP serviceIMP = new serviceIMP();
        System.out.println("name:" + name);
        System.out.println("identityCard:" + identityCard);
        System.out.println("phoneNumber:" + phoneNumber);
        serviceIMP.addBookingPatientBasicInformation(name, identityCard, phoneNumber);
        System.out.println("-----ceshi2-------");
        resp.sendRedirect(req.getContextPath() + "/Content/HTML/main/index.html");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
