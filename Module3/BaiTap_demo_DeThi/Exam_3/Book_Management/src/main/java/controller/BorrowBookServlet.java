package controller;

import model.Book;
import model.CardBorrowBook;
import model.Student;
import service.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BorrowBookServlet", urlPatterns = "/borrow")
public class BorrowBookServlet extends HttpServlet {
    IStudentService studentService = new StudentServiceImpl();
    IBookService bookService = new BookServiceImpl();
    ICardBorrowBookService cardBorrowBookService = new CardBorrowBookImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":

                break;
            case "edit":

                break;
            case "delete":

                break;
            case "search":

                break;
            case "sort":

                break;
            default:
                listBorrow(request, response);
                break;
        }
    }

    private void listBorrow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        CardBorrowBook cardBorrowBook = cardBorrowBookService.selectCardBorrowBook(id);
        List<Student> studentList = studentService.selectStudent();
        List<Book> bookList = bookService.selectAllBook();
        request.setAttribute("cardBorrowBook", cardBorrowBook);
        request.setAttribute("studentList", studentList);
        request.setAttribute("bookList", bookList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/borrow/list.jsp");
        dispatcher.forward(request, response);
    }
}
