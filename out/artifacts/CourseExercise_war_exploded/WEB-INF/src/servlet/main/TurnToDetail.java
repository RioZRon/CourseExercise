package servlet.main;

import bean.main.A10;
import service.serviceIMP;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TurnToDetailServlet", urlPatterns = "/servlet/main/TurnToDetailServlet")
public class TurnToDetail extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int a101 = Integer.valueOf(req.getParameter("rsa101"));
        String a103 = req.getParameter("rsa103");
        serviceIMP serviceIMP = new serviceIMP();
        A10 a10 = serviceIMP.FindStaff(a103);
//        System.out.println(a10.toString());
        req.getSession().setAttribute("a10", a10);
        req.getRequestDispatcher(req.getContextPath() + "/Content/HTML/HR/accountDetail.jsp").forward(req,resp);
    }
}
