package servlet.medicine;

import bean.medicine.A60;
import service.serviceIMP;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateFlowOutServlet", urlPatterns = "/servlet/medicine/CreateFlowOutServlet")
public class CreateFlowOut extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int a601 = Integer.valueOf(req.getParameter("a601"));
        int numb = Integer.valueOf(req.getParameter("innumber"));
        serviceIMP serviceIMP = new serviceIMP();
        A60 a60 = serviceIMP.SelectMedicinDetail(a601);
        //搜索对应的进价
        int inprice = serviceIMP.SelectInprice(a601);
        req.setAttribute("innumber", numb);
        req.setAttribute("inprice", inprice);
        req.getSession().setAttribute("a60", a60);
        req.getRequestDispatcher(req.getContextPath() + "/Content/HTML/medicine/oldOutFlow.jsp").forward(req,resp);
    }
}
