package servlet.medicine;

import bean.medicine.A60;
import bean.medicine.A62;
import service.serviceIMP;
import tools.OtherTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "DoNewFlowInServlet", urlPatterns = "/servlet/medicine/DoNewFlowInServlet")
public class DoNewFlowIn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先生成A60 然后生成A62
        String a602 = req.getParameter("a602");
        int a603 = Integer.valueOf(req.getParameter("a603"));
        String a604 = req.getParameter("a604");
        int a605 = Integer.valueOf(req.getParameter("a605"));
        int a606 = Integer.valueOf(req.getParameter("a606"));
        int a625 = Integer.valueOf(req.getParameter("a625"));
        String Stra628 = req.getParameter("a628");
        String Stra624 = req.getParameter("a624");
        Date a628 = null;
        Date a624 = null;
        java.util.Date temp = new java.util.Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            temp = simpleDateFormat.parse(Stra628);
            a628 = new Date(temp.getTime());
            temp = simpleDateFormat.parse(Stra624);
            a624 = new Date(temp.getTime());
        }catch (ParseException e){
            System.out.println("日期格式问题");
        }
//        System.out.println(a628);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a628);
        stringBuffer.append("|");
        int minu = a606 - OtherTools.DifferentDaysByMillisecond(new java.util.Date(),temp);
        stringBuffer.append(minu);
        stringBuffer.append(":");
        stringBuffer.append(a625);
        String a607 = stringBuffer.toString();
//        System.out.println(a607);
        int a608 = Integer.valueOf(req.getParameter("a608"));
        String a609 = req.getParameter("a609");
        String a6010 = req.getParameter("a6010");
        A60 a60 = new A60(a605,a606,a608,a603,a602,a604,a607,a609,a6010);
//        先添加a60
        serviceIMP serviceIMP = new serviceIMP();
        //先判断是不是已经有的
        int testa601 = serviceIMP.SelectMedicinId(a602);
        if (testa601 != 0) {
            PrintWriter out = resp.getWriter();
            out.print("<script language='javascript'>alert('库中已有该类药品,请先搜索再添加');window.location.href='" + req.getContextPath() + "/Content/HTML/medicine/newInFlow.jsp'</script>");
        }
//



        int a601 = serviceIMP.AddMedicineAndReturna601(a60);
        //创建A62
        int a627 = Integer.valueOf(req.getParameter("a627"));
        String a623 = a602;
        String a626 = req.getParameter("a626");

        A62 a62 = new A62(a601, a625,a627,a623,a626,a624,a628);
        System.out.println(a62.toString());
        serviceIMP.AddFlowIn(a62);

        req.getRequestDispatcher(req.getContextPath() + "/Content/HTML/medicine/newInFlow.jsp").forward(req,resp);
    }
}
