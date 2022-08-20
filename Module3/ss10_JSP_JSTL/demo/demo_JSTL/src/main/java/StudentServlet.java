import model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = {"/student"})
public class StudentServlet extends HttpServlet {
    private static List<Student> studentList = new ArrayList<>();

//    static {
//        studentList.add(new Student(1, "thanh", true, "12-12-2022", 9, "thanhdt", 1, "thanhdt@gmail.com"));
//        studentList.add(new Student(2, "thanh2", false, "12-12-2022", 3, "thanhdt", 1, "thanhdt@gmail.com"));
//        studentList.add(new Student(3, "thanh3", false, "12-12-2022", 8, "thanhdt", 1, "thanhdt@gmail.com"));
//        studentList.add(new Student(4, "thanh4", true, "12-12-2022", 7, "thanhdt", 1, "thanhdt@gmail.com"));
//        studentList.add(new Student(5, "thanh5", true, "12-12-2022", 6, "thanhdt", 1, "thanhdt@gmail.com"));
//    }

    @Override
    public void init() throws ServletException {
        studentList.add(new Student(1, "thanh", true, "12-12-2022", 9, "thanhdt", 1, "thanhdt@gmail.com"));
        studentList.add(new Student(2, "thanh2", false, "12-12-2022", 3, "thanhdt", 1, "thanhdt@gmail.com"));
        studentList.add(new Student(3, "thanh3", false, "12-12-2022", 8, "thanhdt", 1, "thanhdt@gmail.com"));
        studentList.add(new Student(4, "thanh4", true, "12-12-2022", 7, "thanhdt", 1, "thanhdt@gmail.com"));
        studentList.add(new Student(5, "thanh5", true, "12-12-2022", 6, "thanhdt", 1, "thanhdt@gmail.com"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/list.jsp");
        request.setAttribute("studentList", studentList);
        requestDispatcher.forward(request, response);
    }
}
