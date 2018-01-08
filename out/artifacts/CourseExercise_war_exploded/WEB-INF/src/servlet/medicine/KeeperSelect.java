package servlet.medicine;

import bean.medicine.A60;
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

@WebServlet(name = "KeeperSelectServlet", urlPatterns = "/servlet/medicine/KeeperSelectServlet")
public class KeeperSelect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String name = (String)session.getAttribute("name");
        String id = (String)session.getAttribute("id");
        ArrayList<A60> a60ArrayList = new ArrayList<>();
        serviceIMP serviceIMP = new serviceIMP();
        a60ArrayList = serviceIMP.FindMedicines(name, id);
//        //≤‚ ‘
//        System.out.println("test");
//        Iterator<A10>a10Iterator = a10ArrayList.iterator();
//        while (a10Iterator.hasNext()){
//           System.out.println(a10Iterator.next().toString());
//        }
        session.setAttribute("a60ArrayList",a60ArrayList);
        for(A60 a60:a60ArrayList)
            System.out.println(a60.toString());
        req.getRequestDispatcher(req.getContextPath()+"/Content/HTML/medicine/keeperResult.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }
}
