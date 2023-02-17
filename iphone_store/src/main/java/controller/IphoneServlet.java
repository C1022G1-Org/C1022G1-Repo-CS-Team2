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
                createFormIphone(request,response);
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

    private void createFormIphone(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher=request.getRequestDispatcher("iphone/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
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
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                createIphone(request,response);
                break;
            case "update":
                break;
            case "delete":
                break;
        }
    }

    private void createIphone(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id_lsp"));
        String productName = request.getParameter("name");
        String supplier = request.getParameter("supplier");
        String photo = request.getParameter("photo");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Iphone iphone = new Iphone(id,productName,supplier,photo,price,quantity);
        iIphoneService.inserIphone(iphone);
       listForm(request,response);
    }
}
