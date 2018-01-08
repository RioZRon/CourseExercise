package servlet.medicine;

import bean.register.A20;
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

@WebServlet(name = "PatientSelectServlet", urlPatterns = "/servlet/medicine/PatientSelectServlet")
public class PatientSelect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String name = (String)session.getAttribute("name");
        String id = (String)session.getAttribute("id");
        ArrayList<A20> a20ArrayList = new ArrayList<>();
        ArrayList<A20> a20ArrayListReasult = new ArrayList<>();
        serviceIMP serviceIMP = new serviceIMP();
        a20ArrayList = serviceIMP.FindPatients(name, id);
//        根据a20ArrayList来找A215
        ArrayList<String> a217list = new ArrayList<>();
        for(A20 a20: a20ArrayList){
            String a217Str = serviceIMP.SelectMedicineNeeded(a20.getA201());
            if(a217Str!=null && !a217Str.isEmpty() ){
                TreeMap<String, Integer> treeMap = StringTools.PrescriptionStringToMap(a217Str);
                if (!treeMap.isEmpty()) {
                    a217list.add(a217Str);
                    a20ArrayListReasult.add(a20);
                }
            }
        }
        //将搜索条件和搜索结果存在sesstion
        session.setAttribute("a20ArrayList",a20ArrayListReasult);
        session.setAttribute("a215list",a217list);
        req.getRequestDispatcher(req.getContextPath()+"/Content/HTML/medicine/patientResult.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }
}
