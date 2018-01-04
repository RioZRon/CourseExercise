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
import java.util.ArrayList;
import java.util.Iterator;

@WebServlet(name = "AaccountSelectServlet", urlPatterns = "/server/main/AaccountSelectServlet")
public class AccountSelect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String a102 = (String)session.getAttribute("a102");
        String a103 = (String)session.getAttribute("a103");
        ArrayList<A10> a10ArrayList = new ArrayList<>();
        serviceIMP serviceIMP = new serviceIMP();
        a10ArrayList = serviceIMP.FindStaffs(a102,a103);
//        //测试
//        System.out.println("test");
//        Iterator<A10>a10Iterator = a10ArrayList.iterator();
//        while (a10Iterator.hasNext()){
//           System.out.println(a10Iterator.next().toString());
//        }
        //将搜索条件和搜索结果存在sesstion
        session.setAttribute("a10ArrayList",a10ArrayList);

        req.getRequestDispatcher(req.getContextPath()+"/Content/HTML/HR/accountResult.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }
}
