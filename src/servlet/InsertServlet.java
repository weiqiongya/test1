package servlet;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;
import service.UserServiceImpl;
import vo.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class InsertServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService=new UserServiceImpl();
        try {
            List<User> list =userService.queryUsers();
            //将查询内容返回给JSP
            req.setAttribute("userList",list);
            //跳转页面至
            req.getRequestDispatcher("/pages/user/userList.jsp").forward(req,resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
