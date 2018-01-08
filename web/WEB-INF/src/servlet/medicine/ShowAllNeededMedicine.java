package servlet.medicine;

import bean.medicine.A60;
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
import java.util.TreeMap;

@WebServlet(name = "ShowAllNeededMedicineServlet", urlPatterns = "/servlet/medicine/ShowAllNeededMedicineServlet")
public class ShowAllNeededMedicine extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //217要现场查
        int a201= (int)session.getAttribute("a201");
        //得到剩余数量以及药物的基本信息
        serviceIMP serviceIMP = new serviceIMP();
        String a217= serviceIMP.SelectMedicineNeeded(a201);
        ArrayList<A60> a60ArrayList = serviceIMP.ShowAllNeededMedicine(a217);
        //为了方便修改我决定吧需要的数量存在预警中A608
        session.setAttribute("a60ArrayList",a60ArrayList);
//        session.setAttribute("a201", a201);
        session.setAttribute("a217", a217);
        req.getRequestDispatcher(req.getContextPath() + "/Content/HTML/medicine/neededList.jsp").forward(req,resp);
    }
}
