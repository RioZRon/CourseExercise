package servlet.outpatientDoctor;

import tools.StringTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "PatientSelectDealWithNameIdServlet", urlPatterns = "/servlet/outpatientDoctor/PatientSelectDealWithNameIdServlet")
public class PatientSelectDealWithNameId extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = StringTools.emptyToNull(req.getParameter("name"));
        String id = StringTools.emptyToNull(req.getParameter("id"));
        HttpSession session = req.getSession();
        session.setAttribute("name", name);
        session.setAttribute("id", id);
        req.getRequestDispatcher(req.getContextPath()+"/servlet/outpatientDoctor/PatientSelectServlet").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
