package servlet.medicine;

import bean.medicine.A60;
import bean.medicine.A62;
import bean.medicine.A63;
import service.serviceIMP;
import tools.OtherTools;
import tools.StringTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

@WebServlet(name = "DoFlowOutServlet", urlPatterns = "/servlet/medicine/DoFlowOutServlet")
public class DoFlowOut extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int a632 = Integer.valueOf(req.getParameter("a632"));
        String a633 = req.getParameter("a633");
        int a635 = Integer.valueOf(req.getParameter("a635"));
        int a636 = Integer.valueOf(req.getParameter("a636"));
        java.sql.Date a634 = java.sql.Date.valueOf(req.getParameter("a634"));
        A63 a63 = new A63(a632, a635, a636, a633, a634);
        System.out.println(a63.toString());
        serviceIMP serviceIMP = new serviceIMP();
        serviceIMP.AddFlowOut(a63);
        //还要修改对应的A607
        serviceIMP.UpdateRemainNumByA63(a63);
        System.out.println("-----ceshi2-------");
        int a201 = (int) req.getSession().getAttribute("a201");
        String a217 = (String) req.getSession().getAttribute("a217");
        //修改A217
        TreeMap<String, Integer> treeMap = StringTools.PrescriptionStringToMap(a217);
        // 先得到217 然后修改 上传数据库  A633
        String tempKey = null;
        int tempValue = 0;
//        a635
        int remainValue= 0;
        Iterator<Map.Entry<String, Integer>> entryIterator = treeMap.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Integer> entrynext = entryIterator.next();
            if (entrynext.getKey().equals(a633)) {
                if(a635 >= entrynext.getValue()) {
                    tempKey = entrynext.getKey();
                    tempValue = entrynext.getValue();
                    entryIterator.remove();
                    System.out.println("-----ceshi3-------");
                }else {
                    tempKey = entrynext.getKey();
                    tempValue = entrynext.getValue();
                    remainValue = tempValue - a635;
                }
            }
            if (remainValue!=0)
                treeMap.put(tempKey, remainValue);
        }
        System.out.println("-----ceshi1-------");
        System.out.println("原先217:" + a217);
        String new217 = StringTools.PrescriptionMapToString(treeMap);
        System.out.println("raw217:" +new217);
        new217 += "," + tempKey + "买了" + tempValue;
        System.out.println(new217);
        // TODO: 2018/1/8  增加能够修改病历里面处方的能力 并且搜索药物可以贩卖 A217
        serviceIMP.UpdatePrescrpe(a201, new217);
        //还要修改用户的需求  是从病历中得到的 只用删除病历里的数字部分修改它的模式就行
        req.getRequestDispatcher(req.getContextPath() + "/servlet/medicine/ShowAllNeededMedicineServlet").forward(req,resp);
    }
}
