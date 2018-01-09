package servlet.main;

import bean.main.A10;
import service.serviceIMP;
import tools.StringTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AccountSelectDealWitha102103Servlet", urlPatterns = "/servlet/main/AccountSelectDealWitha102103Servlet")
public class AccountSelectDealWitha102103 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String a102 = StringTools.emptyToNull(req.getParameter("a102"));
        String a103 = StringTools.emptyToNull(req.getParameter("a103"));
        HttpSession session = req.getSession();
        session.setAttribute("a102", a102);
        session.setAttribute("a103", a103);
        req.getRequestDispatcher(req.getContextPath()+"/servlet/main/AaccountSelectServlet").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
