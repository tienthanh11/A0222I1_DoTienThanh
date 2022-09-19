package controller;

import lombok.SneakyThrows;
import models.MatBang;
import models.StatusStage;
import models.TypeStatus;
import repository.impl.MatBangRepository;
import service.IBaseService;
import service.ITypeService;
import service.impl.MatBangService;
import service.impl.StatusService;
import service.impl.TypeService;
import utils.CreateMatBang;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;

@WebServlet(name = "MainServlet", urlPatterns = "/main")
public class MainServlet extends HttpServlet {
    IBaseService<MatBang> matBangIBaseService = new MatBangService();
    ITypeService<StatusStage> statusService = new StatusService();
    ITypeService<TypeStatus> typeService = new TypeService();

    @SneakyThrows
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = Optional.ofNullable(request.getParameter("action")).orElse("display");
        switch (action) {
            case "insert": {
                create(request, response);
                break;
            }
            case "delete": {
                delete(request, response);
                break;
            }
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_delete = request.getParameter("id");
        matBangIBaseService.removeById(id_delete);
        displayList(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Map<String, String> mapError = matBangIBaseService.save(CreateMatBang.createMatBangByRequest(request));
        if (mapError.isEmpty()) {
            request.setAttribute("message", "Create Success!!!");
            createForm(request, response);
            return;
        }
        request.setAttribute("message", "Create Fail !!!");
        request.setAttribute("error", mapError);
        createForm(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = Optional.ofNullable(request.getParameter("action")).orElse("display");
        switch (action) {
            case "display": {
                displayList(request, response);
                break;
            }
            case "insert": {
                createForm(request, response);
                break;
            }
            case "search": {
                search(request, response);
                break;
            }
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("nameSearch");
        String stage = request.getParameter("stageSearch");
        String dateIn = request.getParameter("dateInSearch");
        String dateOut = request.getParameter("dateOutSearch");
        request.setAttribute("list", matBangIBaseService.findBy(name, stage, dateIn, dateOut));
        request.setAttribute("listStatus", statusService.findAll());
        request.setAttribute("listType", typeService.findAll());
        request.getRequestDispatcher("views/list.jsp").forward(request, response);
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("target", new MatBang());
        request.setAttribute("listStatus", statusService.findAll());
        request.setAttribute("listType", typeService.findAll());
        try {
            request.getRequestDispatcher("views/form.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void displayList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int offset = Integer.parseInt(Optional.ofNullable(request.getParameter("offset")).orElse("0"));
        request.setAttribute("max_page", matBangIBaseService.count());
        request.setAttribute("list", matBangIBaseService.findAll(MatBangRepository.LIMIT_DISPLAY, offset));
        request.setAttribute("listStatus", statusService.findAll());
        request.setAttribute("listType", typeService.findAll());
        request.getRequestDispatcher("views/list.jsp").forward(request, response);
    }
}
