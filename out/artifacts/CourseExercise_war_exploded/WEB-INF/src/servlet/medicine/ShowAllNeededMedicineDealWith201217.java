package servlet.medicine;

import bean.medicine.A60;
import service.serviceIMP;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ShowAllNeededMedicineDealWith201217Servlet", urlPatterns = "/servlet/medicine/ShowAllNeededMedicineDealWith201217Servlet")
public class ShowAllNeededMedicineDealWith201217 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int a201 = Integer.valueOf(req.getParameter("a201"));
        String a217 = req.getParameter("a217");
        HttpSession session = req.getSession();
        session.setAttribute("a201", a201);
        session.setAttribute("a217", a217);
        req.getRequestDispatcher(req.getContextPath() + "/servlet/medicine/ShowAllNeededMedicineServlet").forward(req,resp);
    }
}
