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
import java.util.Date;

@WebServlet(name = "DoOldFlowInServlet", urlPatterns = "/servlet/medicine/DoOldFlowInServlet")
public class DoOldFlowIn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int a622 =  Integer.valueOf(req.getParameter("a622"));
        String a623 = req.getParameter("a623");
        int a627 = Integer.valueOf(req.getParameter("a627"));
        int a625 =  Integer.valueOf(req.getParameter("a625"));
        String a626 = req.getParameter("a626");
        java.sql.Date a624 = java.sql.Date.valueOf(req.getParameter("a624"));
        java.sql.Date a628 = java.sql.Date.valueOf(req.getParameter("a628"));
        A62 a62 = new A62(a622, a625,a627, a623,a626, a624, a628);
//        System.out.println(a62.toString());
        serviceIMP serviceIMP= new serviceIMP();
        serviceIMP.AddFlowIn(a62);
        //还要修改对应的A607
        serviceIMP.UpdateRemainNumByA62(a62);
        boolean keeperInFlag = (boolean)req.getSession().getAttribute("keeperInFlag");
        if (keeperInFlag)
            req.getRequestDispatcher(req.getContextPath() + "/servlet/medicine/SelectAllAlertMedicineServlet").forward(req,resp);
        else
            req.getRequestDispatcher(req.getContextPath() + "/servlet/medicine/KeeperSelectServlet").forward(req,resp);
    }
}
