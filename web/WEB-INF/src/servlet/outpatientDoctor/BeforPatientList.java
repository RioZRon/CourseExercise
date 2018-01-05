package servlet.outpatientDoctor;

import bean.main.A10;
import bean.register.A20;
import service.serviceIMP;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "BeforPatientListServlet", urlPatterns = "/servlet/outpatientDoctor/BeforPatientListServlet")
public class BeforPatientList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        A10 doc = (A10)session.getAttribute("a10");

        //显示这个医生所有的病人   中午完成
        ArrayList<A20> a20ArrayList = new ArrayList<>();
        serviceIMP serviceIMP = new serviceIMP();

        session.setAttribute("a20ArrayList",a20ArrayList);

        req.getRequestDispatcher(req.getContextPath()+"/Content/HTML/registration/patientResult.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }
}
