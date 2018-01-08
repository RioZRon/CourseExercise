package servlet.medicine;

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

@WebServlet(name = "PatientSelectServlet", urlPatterns = "/servlet/registration/PatientSelectServlet")
public class PatientSelect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String name = (String)session.getAttribute("name");
        String id = (String)session.getAttribute("id");
        ArrayList<A20> a20ArrayList = new ArrayList<>();
        serviceIMP serviceIMP = new serviceIMP();
        a20ArrayList = serviceIMP.FindPatients(name, id);
//        //测试
//        System.out.println("test");
//        Iterator<A10>a10Iterator = a10ArrayList.iterator();
//        while (a10Iterator.hasNext()){
//           System.out.println(a10Iterator.next().toString());
//        }
        //将搜索条件和搜索结果存在sesstion
        session.setAttribute("a20ArrayList",a20ArrayList);

        req.getRequestDispatcher(req.getContextPath()+"/Content/HTML/registration/keeperResult.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }
}
