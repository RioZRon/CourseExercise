package servlet.medicine;

import bean.medicine.A60;
import bean.medicine.A62;
import service.serviceIMP;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MedicineDetailSaveServlet", urlPatterns = "/servlet/medicine/MedicineDetailSaveServlet")
public class MedicineDetailSave extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int a601 = ((A60)req.getSession().getAttribute("a60")).getA601();
        String a602 = req.getParameter("a602");
        int a603 = Integer.valueOf(req.getParameter("a603"));
        String a604 = req.getParameter("a604");
        int a605 = Integer.valueOf(req.getParameter("a605"));
        int a608 =  Integer.valueOf(req.getParameter("a608"));
        String a609 = req.getParameter("a609");
        String a6010 = req.getParameter("a6010");
        A60 a60 =(A60) req.getSession().getAttribute("a60");
        a60.setA602(a602);
        a60.setA603(a603);
        a60.setA604(a604);
        a60.setA605(a605);
        a60.setA608(a608);
        a60.setA609(a609);
        a60.setA6010(a6010);
        //还要修改对应的A607
        serviceIMP serviceIMP = new serviceIMP();
        serviceIMP.UpdateMedicine(a60);
        boolean keeperInFlag = (boolean)req.getSession().getAttribute("keeperInFlag");
        if (keeperInFlag)
            req.getRequestDispatcher(req.getContextPath() + "/servlet/medicine/SelectAllAlertMedicineServlet").forward(req,resp);
        else
            req.getRequestDispatcher(req.getContextPath() + "/servlet/medicine/KeeperSelectServlet").forward(req,resp);
    }
}
