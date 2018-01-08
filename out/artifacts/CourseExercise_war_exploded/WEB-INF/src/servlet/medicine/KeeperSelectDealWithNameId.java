package servlet.medicine;

import tools.StringTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "KeeperSelectDealWithNameIdServlet", urlPatterns = "/servlet/medicine/KeeperSelectDealWithNameIdServlet")
public class KeeperSelectDealWithNameId extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = StringTools.emptyToNull(req.getParameter("name"));
        String id = StringTools.emptyToNull(req.getParameter("id"));
        boolean keeperInFlag = false;
        HttpSession session = req.getSession();
        session.setAttribute("name", name);
        session.setAttribute("id", id);
        session.setAttribute("keeperInFlag", keeperInFlag);
        req.getRequestDispatcher(req.getContextPath()+"/servlet/medicine/KeeperSelectServlet").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
