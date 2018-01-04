package servlet.main;

import bean.main.A10;
import service.serviceIMP;
import tools.StringTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AccountUpdateServlet", urlPatterns = "/servlet/main/AccountUpdateServlet")
public class AccountUpdate extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //�п�����ί�и��� Ҳ�Ϳ��Բ��������� �ж��������Ϊ�� �Ͳ��ı� ���������Ϊ�ս���js�ж��ܲ����ύ
        String na102 = req.getParameter("a102");
        String na103 = req.getParameter("a103");
        String na104 = req.getParameter("a104");
        int na105 = Integer.valueOf(req.getParameter("a105"));

        HttpSession session = req.getSession();
        A10 a10 = (A10)session.getAttribute("a10");
        if (!na104.equals("���޸ľͱ����û�ԭ����")) {
            try{
                na104 = StringTools.EncoderByMd5(na104);
            }catch (Exception e){
                e.printStackTrace();
            }
            a10.setA104(na104);
        }
        a10.setA102(na102);
        a10.setA103(na103);
        a10.setA105(na105);
//        System.out.println(a10.toString());
        serviceIMP serviceIMP= new serviceIMP();
        serviceIMP.UpdateStaff(a10);

        req.getRequestDispatcher(req.getContextPath() + "/server/main/AaccountSelectServlet").forward(req,resp);
    }
}
