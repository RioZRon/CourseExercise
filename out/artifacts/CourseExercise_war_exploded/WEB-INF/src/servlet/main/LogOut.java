package servlet.main;

import bean.main.A10;
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

@WebServlet(name = "LogOutServlet", urlPatterns = "/servlet/main/LogOutServlet")
public class LogOut extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("a10");
        resp.sendRedirect(req.getContextPath() +  "/Content/HTML/main/signin.html");

//            req.getRequestDispatcher(req.getContextPath() + "/servlet/medicine/SelectAllAlertMedicineServlet").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
