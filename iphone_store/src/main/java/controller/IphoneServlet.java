package controller;

import model.Iphone;
import repository.impl.BaseRepository;
import service.IIphoneService;
import service.impl.IphoneService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "IphoneServlet", value = "/iphone")
public class IphoneServlet extends HttpServlet {
    IIphoneService iIphoneService = new IphoneService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                break;
            case "update":
                break;
            case "delete":
                break;
            default:
                listForm(request, response);
                break;
        }
    }

    private void listForm(HttpServletRequest request, HttpServletResponse response) {
        String nameSearch = request.getParameter("nameSearch");
        request.setAttribute("nameSearch", nameSearch);
        List<Iphone> iphoneList = this.iIphoneService.listAll(nameSearch);
        request.setAttribute("iphoneList", iphoneList);
        try {
            request.getRequestDispatcher("/iphone/list.jsp").forward(request, response);
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
