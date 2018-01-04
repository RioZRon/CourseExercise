package servlet.main;

import bean.main.A10;
import service.serviceIMP;
import tools.StringTools;
import tools.programTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@WebServlet(name = "SignUpServlet", urlPatterns = "/servlet/main/SignUpServlet")
public class SignUp extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String a102 = req.getParameter("a102");
        String a103 = req.getParameter("a103");
        String a104 = req.getParameter("a104");
        try{
            a104  = StringTools.EncoderByMd5(a104);
        }catch (NoSuchAlgorithmException |UnsupportedEncodingException e){
            e.printStackTrace();
        }
        int a105 = Integer.valueOf(req.getParameter("a105"));
        A10 a10 = new A10(a102,a103,a104,a105);
        serviceIMP serviceIMP = new serviceIMP();
        serviceIMP.AddStaff(a10);
        req.getRequestDispatcher(req.getContextPath() + "/Content/HTML/HR/signup.jsp").forward(req,resp);
    }
}
