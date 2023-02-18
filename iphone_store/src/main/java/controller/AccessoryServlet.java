package controller;

import model.Accessory;
import service.IAccessoryService;
import service.impl.AccessoryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AccessoryServlet", value = "/accessory")
public class AccessoryServlet extends HttpServlet {
    IAccessoryService iAccessoryService = new AccessoryService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actions = request.getParameter("actions");
        if (actions == null){
            actions = "";
        }
        switch (actions){
            case "create":
                break;
            case "update":
                break;
            case "delete":
                break;
            default:
                listAccForm(request, response);
                break;
        }
    }

    private void listAccForm(HttpServletRequest request, HttpServletResponse response) {
        String accSearch = request.getParameter("accSearch");
        request.setAttribute("accSearch", accSearch);
        List<Accessory> accessoryList = this.iAccessoryService.listAll(accSearch);
        request.setAttribute("accessoryList", accessoryList);
        try {
            request.getRequestDispatcher("/iphone/list2.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
