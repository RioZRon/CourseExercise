package servlet.medicine;

import bean.medicine.A60;
import bean.medicine.A63;
import service.serviceIMP;
import tools.StringTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

@WebServlet(name = "DoAllFlowOutServlet", urlPatterns = "/servlet/medicine/DoAllFlowOutServlet")
public class DoAllFlowOut extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        首先是得到所有的药品列
        int a201 = Integer.valueOf(req.getParameter("a201"));
        String a217 = req.getParameter("a217");
        serviceIMP serviceIMP = new serviceIMP();
        ArrayList<A60> a60ArrayList = serviceIMP.ShowAllNeededMedicine(a217);
        //注意 A608里存到的是需要的数量
        java.util.Date now = new java.util.Date();
        Date a634 = new Date(now.getTime());
        A63 a63 = new A63();
        for (A60 a60 : a60ArrayList){
            int a632 = a60.getA601();
            int a635 = a60.getA608();
            int a636 = a60.getA603();
            String a633 = a60.getA602();
            a63 = new A63(a632, a635, a636, a633, a634);
            serviceIMP.AddFlowOut(a63);
            serviceIMP.UpdateRemainNumByA63(a63);
        }
        //全部导出, 修改全部217
        StringBuffer stringBuffer = new StringBuffer();
        TreeMap<String, Integer> treeMap = StringTools.PrescriptionStringToMap(a217);
        for (Map.Entry<String, Integer> entry:treeMap.entrySet()){
            stringBuffer.append(entry.getKey());
            stringBuffer.append("买了");
            stringBuffer.append(entry.getValue());
            stringBuffer.append(",");
        }
        String new217 = stringBuffer.toString();
        serviceIMP.UpdatePrescrpe(a201, new217);
        req.getRequestDispatcher(req.getContextPath() + "/servlet/medicine/PatientSelectServlet").forward(req,resp);
    }
}
