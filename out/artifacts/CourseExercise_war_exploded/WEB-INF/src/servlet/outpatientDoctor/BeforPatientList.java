package servlet.outpatientDoctor;

import bean.main.A10;
import bean.register.A20;
import service.serviceIMP;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "BeforPatientListServlet", urlPatterns = "/servlet/outpatientDoctor/BeforPatientListServlet")
public class BeforPatientList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        A10 doc = (A10)session.getAttribute("a10");
        //ҽ���в�ͬ ��������ֻ��һ�� ����ֵ�ĳ�Ƶ� ��ô�Ǹ��Ƶ�����ҽ�����ܿ��������Ϣ
        //�ȵõ�ҽ����Ӧ�Ŀ�
        serviceIMP serviceIMP = new serviceIMP();
        int roomNum = serviceIMP.FindDoctorRoom(doc.getA101());
        ArrayList<A20> a20ArrayList = new ArrayList<>();
        a20ArrayList = serviceIMP.FindPatientsBya2010(roomNum);
        req.setAttribute("a20ArrayList",a20ArrayList);
        req.getRequestDispatcher(req.getContextPath()+"/Content/HTML/outpatientDoctor/patientList.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }
}
