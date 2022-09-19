package controller;

import model.Product;
import model.Category;
import service.ICategoryService;
import service.IProductService;
import service.impl.CategoryService;
import service.impl.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {
    IProductService productService = new ProductService();
    ICategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "search":
                search(request, response);
                break;
            default:
                listProduct(request, response);
                break;
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = categoryService.findAll();
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Product> productList = productService.findAll();
        List<Category> categoryList = categoryService.findAll();
        request.setAttribute("productList", productList);
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameProductSearch = request.getParameter("nameProductSearch");
        List<Product> productList = productService.search("nameProductSearch");
        List<Category> categoryList = categoryService.findAll();
        request.setAttribute("nameProductSearch", nameProductSearch);
        request.setAttribute("productList", productList);
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request, response);
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.findAll();
        List<Category> categoryList = categoryService.findAll();
        request.setAttribute("productList", productList);
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insert(request, response);
                break;
            case "edit":
                update(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
        }
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String describe = request.getParameter("describe");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        Product product = new Product(name, price, quantity, color, describe, categoryId);
        boolean flag = productService.insert(product);
        if(flag) {
            List<Product> productList = productService.findAll();
            List<Category> categoryList = categoryService.findAll();
            request.setAttribute("productList", productList);
            request.setAttribute("categoryList", categoryList);
            request.setAttribute("mess", "thêm mới thành công");
            RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("mess", "thêm mới thất bại");
            RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = categoryService.findAll();
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String describe = request.getParameter("describe");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        Product product = new Product(name, price, quantity, color, describe, categoryId);
        boolean flag = productService.update(product);
        if (flag) {
            request.setAttribute("product", product);
            request.setAttribute("categoryList", categoryList);
            request.setAttribute("mess", "edit thành công");
            RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("mess", "edit thất bại");
            RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        boolean flag = productService.delete(id);
        if(flag) {
            request.setAttribute("mess", "xoá thành công");
        } else {
            request.setAttribute("mess", "xoá thất bại");
        }

        // trả về trang list
        List<Product> productList = productService.findAll();
        List<Category> categoryList = categoryService.findAll();
        request.setAttribute("productList", productList);
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request, response);
    }
}
