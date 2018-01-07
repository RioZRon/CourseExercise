package servlet.outpatientDoctor;

import bean.outpatientdocter.A21;
import bean.register.A20;
import service.serviceIMP;
import tools.StringTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "PrescriptionDetailSaveServlet", urlPatterns = "/servlet/outpatientDoctor/PrescriptionDetailSaveServlet")
public class PrescriptionDetailSave extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        A20 a20 = (A20)req.getSession().getAttribute("a20");
        A21 a21 = (A21)req.getSession().getAttribute("a21");
        String a202 = StringTools.nullToEmpty(req.getParameter("a202"));
        int a203 = Integer.valueOf(req.getParameter("a203"));
        String a204 = StringTools.nullToEmpty(req.getParameter("a204"));
        String a208 = StringTools.nullToEmpty(req.getParameter("a208"));
        String a209 = StringTools.nullToEmpty(req.getParameter("a209"));
        String a2011 = StringTools.nullToEmpty(req.getParameter("a2011"));
        //因为是要求保存的 以前的修改复原
        String a212 = req.getParameter("a212");
        String a213 = req.getParameter("a213");
        String a214 = req.getParameter("a214");
        //a215
        String a215 = null;
        if (req.getParameterValues("a2151") != null) {
            List<String> a2151list = Arrays.asList(req.getParameterValues("a2151"));
            ArrayList<String> a2151arraylist = new ArrayList<>(a2151list);
            List<String> a2152list = Arrays.asList(req.getParameterValues("a2152"));
            ArrayList<String> a2152arraylist = new ArrayList<>(a2152list);
            HashMap<String, String> rs = new HashMap<>();
            int keyLen = a2151arraylist.size();
            int valLen = a2152arraylist.size();
            int len = keyLen;
            if (len > valLen)
                len = valLen;
            for (int i = 0; i < len; i++)
                rs.put(a2151arraylist.get(i), a2152arraylist.get(i));
            a215 = StringTools.A215MapToStr(rs);
        }

        String a216 = req.getParameter("a216");
        String a217 = req.getParameter("a217");
        String a218 = req.getParameter("a218");
        String a219 = req.getParameter("a219");


        a20.setA202(a202);
        a20.setA203(a203);
        a20.setA204(a204);
        a20.setA208(a208);
        a20.setA209(a209);
        a20.setA2011(a2011);


        a21.setA212(a212);
        a21.setA213(a213);
        a21.setA214(a214);
        a21.setA215(a215);
        a21.setA216(a216);
        a21.setA217(a217);
        a21.setA218(a218);
        a21.setA219(a219);

        serviceIMP serviceIMP= new serviceIMP();
        serviceIMP.UpdatePatient(a20);
        serviceIMP.UpdateMedicalrecord(a21);
        req.getRequestDispatcher(req.getContextPath() + "/servlet/outpatientDoctor/BeforPatientListServlet").forward(req,resp);
    }
}
