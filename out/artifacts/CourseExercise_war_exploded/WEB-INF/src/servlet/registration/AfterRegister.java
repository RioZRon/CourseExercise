package servlet.registration;

import bean.main.A10;
import bean.register.A20;
import service.serviceIMP;
import tools.StringTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AfterRegisterServlet", urlPatterns = "/servlet/registration/AfterRegisterServlet")
public class AfterRegister extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String a202 = StringTools.nullToEmpty(req.getParameter("a202"));
        int a203 = Integer.valueOf(req.getParameter("a203"));
        String a204 = StringTools.nullToEmpty(req.getParameter("a204"));
        String a205 = StringTools.nullToEmpty(req.getParameter("a205"));
        String a206 = StringTools.nullToEmpty(req.getParameter("a206"));
        String a207 = StringTools.nullToEmpty(req.getParameter("a207"));
        String a208 = StringTools.nullToEmpty(req.getParameter("a208"));
        String a209 = StringTools.nullToEmpty(req.getParameter("a209"));
        int a2010 = Integer.valueOf(req.getParameter("a2010"));
        String a2011 = StringTools.nullToEmpty(req.getParameter("a2011"));
        String a2012str = req.getParameter("a2012");
        Date a2012 = null;
        try {
            SimpleDateFormat simFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            a2012 = simFormat.parse(a2012str);
        }catch (ParseException e){
            e.getErrorOffset();
        }
        A20 a20 = new A20(a203, a2010, a202, a204, a205,a206,a207,a208,a209,a2011,a2012);
//        System.out.println(a20.toString());
        serviceIMP serviceIMP = new serviceIMP();
        serviceIMP.addPatientBasicInformation(a20);
        req.getRequestDispatcher(req.getContextPath() + "/Content/HTML/registration/register.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
