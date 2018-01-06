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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "PatientUpdateServlet", urlPatterns = "/servlet/registration/PatientUpdateServlet")
public class PatientUpdate extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String a202 = req.getParameter("a202");
        int a203 = Integer.valueOf(req.getParameter("a203"));
        String a204 = req.getParameter("a204");
        String a205 = req.getParameter("a205");
        String a206 = req.getParameter("a206");
        String a207 = req.getParameter("a207");
        String a208 = req.getParameter("a208");
        String a209 = req.getParameter("a209");
        int a2010 = Integer.valueOf(req.getParameter("a2010"));
        String a2011 = req.getParameter("a2011");
        //还是需要修改时间  这个挂号时间应该算作预约时间
        String a2012str = req.getParameter("a2012");
        Date a2012 = null;
        try {
            SimpleDateFormat simFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            a2012 = simFormat.parse(a2012str);
        }catch (ParseException e){
            e.getErrorOffset();
        }
        HttpSession session = req.getSession();
        A20 a20 = (A20)session.getAttribute("a20");
        a20.setA202(a202);
        a20.setA203(a203);
        a20.setA204(a204);
        a20.setA205(a205);
        a20.setA206(a206);
        a20.setA207(a207);
        a20.setA208(a208);
        a20.setA209(a209);
        a20.setA2010(a2010);
        a20.setA2011(a2011);
        a20.setA2012(a2012);
//        System.out.println(a20.toString());
        serviceIMP serviceIMP= new serviceIMP();
        serviceIMP.UpdatePatient(a20);
        req.getRequestDispatcher(req.getContextPath() + "/servlet/registration/PatientSelectServlet").forward(req,resp);
    }
}
