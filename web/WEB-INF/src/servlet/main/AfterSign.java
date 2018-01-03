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

@WebServlet(name = "AfterSignServlet", urlPatterns = "/servlet/main/AfterSignServlet")
public class AfterSign extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String passwordMd5 = null;
        try{
           passwordMd5  = StringTools.EncoderByMd5(password);
        }catch (NoSuchAlgorithmException|UnsupportedEncodingException e){
            e.printStackTrace();
        }
        serviceIMP serviceIMP = new serviceIMP();
        A10 a10 = serviceIMP.SignIn(name, passwordMd5);
        req.getSession().setAttribute("a10", a10);
        // TODO: 2018/1/3 判断身份角色跳转页面 


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
