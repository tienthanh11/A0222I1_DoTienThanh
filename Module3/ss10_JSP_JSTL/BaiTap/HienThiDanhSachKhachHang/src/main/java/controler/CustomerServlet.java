package controler;

import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {
    private static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer("Mai Van Hoan", "1983-08-20", "Ha Noi", "https://1.bp.blogspot.com/-rt6mn1dJJ7M/XqZl2p-TboI/AAAAAAAAjO8/SzKdmwQAFhUH2CXgUH6kluj_G8Gig2-xgCLcBGAsYHQ/s1600/Anh-avatar-dep-cho-con-trai%2B%25281%2529.jpg"));
        customerList.add(new Customer("Nguyen Van Nam", "1983-08-21", "Bac Giang", "https://toigingiuvedep.vn/wp-content/uploads/2021/05/hinh-anh-avatar-cho-con-gai-1-600x600.jpg"));
        customerList.add(new Customer("Nguyen Thai Hoa", "1983-08-22", "Nam Dinh", "https://sumuoi.mobi/avatar-con-trai/imager_4_15129_700.jpg"));
        customerList.add(new Customer("Tran Dang Khoa", "1983-08-17", "Ha Tay", "https://scr.vn/wp-content/uploads/2020/08/H%C3%ACnh-%E1%BA%A3nh-%C4%91%E1%BA%B9p-l%C3%A0m-avt-cho-con-trai.jpg"));
        customerList.add(new Customer("Nguyen Dinh Thi", "1983-08-25", "Ha Noi", "https://allimages.sgp1.digitaloceanspaces.com/tipeduvn/2022/01/1643616980_253_Hinh-anh-avatar-dep-cho-con-gai-cute-da-phong.jpg"));
    }

/*    @Override
    public void init() throws ServletException {
        customerList.add(new Customer("Mai Văn Hoàn", "1983-08-20", "Hà Nội", "https://1.bp.blogspot.com/-rt6mn1dJJ7M/XqZl2p-TboI/AAAAAAAAjO8/SzKdmwQAFhUH2CXgUH6kluj_G8Gig2-xgCLcBGAsYHQ/s1600/Anh-avatar-dep-cho-con-trai%2B%25281%2529.jpg"));
        customerList.add(new Customer("Nguyễn Văn Nam", "1983-08-21", "Bắc Giang", "https://toigingiuvedep.vn/wp-content/uploads/2021/05/hinh-anh-avatar-cho-con-gai-1-600x600.jpg"));
        customerList.add(new Customer("Nguyễn Thái Hoà", "1983-08-22", "Nam Định", "https://sumuoi.mobi/avatar-con-trai/imager_4_15129_700.jpg"));
        customerList.add(new Customer("Trần Đăng Khoa", "1983-08-17", "Hà Tây", "https://scr.vn/wp-content/uploads/2020/08/H%C3%ACnh-%E1%BA%A3nh-%C4%91%E1%BA%B9p-l%C3%A0m-avt-cho-con-trai.jpg"));
        customerList.add(new Customer("Nguyễn Đình Thi", "1983-08-25", "Hà Nội", "https://allimages.sgp1.digitaloceanspaces.com/tipeduvn/2022/01/1643616980_253_Hinh-anh-avatar-dep-cho-con-gai-cute-da-phong.jpg"));
    }*/

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerListServlet", customerList);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}
