package servlet.main;

import service.serviceIMP;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AccountDeleteServlet", urlPatterns = "/servlet/main/AccountDeleteServlet")
public class AccountDelete extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int a101 = Integer.valueOf(req.getParameter("rsa101"));
        serviceIMP serviceIMP = new serviceIMP();
        serviceIMP.DeleteStaff(a101);
        req.getRequestDispatcher(req.getContextPath() + "/servlet/main/AaccountSelectServlet").forward(req,resp);
    }
}
