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
            case "edit":
                showEdit(request,response);
                break;
            case "delete":
                deleteIphone(request, response);
                break;
            default:
                listForm(request, response);
                break;
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int id =Integer.parseInt(request.getParameter("id"));
            Iphone iphone =this.iIphoneService.findById(id);
            request.setAttribute("iphone",iphone);
            request.getRequestDispatcher("/iphone/edit.jsp").forward(request,response);
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

    private void deleteIphone(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("deleteIphone"));
        this.iIphoneService.delete(id);
        RequestDispatcher dispatcher;
        try {
                response.sendRedirect("/iphone");
            } catch (IOException ioException) {
            ioException.printStackTrace();
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
                pcreateFormIphone(request,response);
                break;
            case "edit":
                edit(request,response);
                break;
            case "delete":
                deleteIphone(request, response);
                break;
            default:
                listForm(request, response);
                break;
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id =Integer.parseInt(request.getParameter("id"));
        int id_lsp =Integer.parseInt(request.getParameter("id_lsp"));
        String iphoneName=request.getParameter("iphoneName");
        String supplier = request.getParameter("supplier");
        String photo =request.getParameter("photo");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity =Integer.parseInt(request.getParameter("quantity"));
        Iphone iphone = new Iphone(id,id_lsp,iphoneName,supplier,photo,price,quantity);
        RequestDispatcher dispatcher =null;
        if (iphone==null){
            dispatcher=request.getRequestDispatcher("iphone/edit.jsp");
        }else {
            this.iIphoneService.updateIphone(id,iphone);
            listForm(request,response);
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void pcreateFormIphone(HttpServletRequest request, HttpServletResponse response) {
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
