package controller;

import model.House;
import service.IServiceService;
import service.impl.ServiceService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HouseServlet", urlPatterns = {"/index_service"})
public class HouseServlet extends HttpServlet {
    private IServiceService service = new ServiceService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            default:
                getList(request, response);
                break;
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("service/create_house.jsp");
        requestDispatcher.forward(request, response);
    }

    private void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<House> houseList = service.showHouse();
        if (houseList == null) {
            request.setAttribute("msg", "No data to display");
        } else {
            request.setAttribute("house", houseList);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("service/house_interaction.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createHouse(request, response);
                break;
            default:
                break;
        }
    }

    private void createHouse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Double area = Double.parseDouble(request.getParameter("area"));
        Double cost = Double.parseDouble(request.getParameter("cost"));
        int amount_person = Integer.parseInt(request.getParameter("amount_person"));
        int type_rent = Integer.parseInt(request.getParameter("type_rent"));
        String standard = request.getParameter("standard");
        String description = request.getParameter("description");
        int floor = Integer.parseInt(request.getParameter("floor"));
        House house = new House(id, name, area, cost, amount_person, type_rent, standard, description, floor);
        service.createHouse(house);
        request.setAttribute("house", service.showHouse());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("service/house_interaction.jsp");
        requestDispatcher.forward(request, response);
    }
}
