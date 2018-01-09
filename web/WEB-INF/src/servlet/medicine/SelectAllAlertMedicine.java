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

@WebServlet(name = "SelectAllAlertMedicineServlet", urlPatterns = "/servlet/medicine/SelectAllAlertMedicineServlet")
public class SelectAllAlertMedicine extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        serviceIMP serviceIMP = new serviceIMP();
        ArrayList<A60> a60ArrayList = serviceIMP.UpdateAndSelectAlertA60();
        boolean keeperInFlag = true;
        HttpSession session = req.getSession();
        session.setAttribute("a60ArrayList",a60ArrayList);
        session.setAttribute("keeperInFlag", keeperInFlag);
        req.getRequestDispatcher(req.getContextPath() + "/Content/HTML/medicine/keeper.jsp").forward(req,resp);
    }
}
