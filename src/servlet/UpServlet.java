package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/up.do")
public class UpServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//1导入驱动jar包
//2注册驱动
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String address = request.getParameter("address");
        String man = request.getParameter("man");
        String id = request.getParameter("id");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//这里会抛出异常 throws Exception直接全部抛出 只抛出一个的话后面还是会接着叫你抛出异常
//3获取连接对线
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wei?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC", "root", "wqy201010086");
//“jdbc:mysql://localhost:3306(这里数据库端口)/db3（这里是要连接的数据库） ？useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC（8.x.x以后连接数据库需要在后面这一串加入不然会报错说你时区不对）”,“root（这里是账号）”, “root（这里是密码)”
//4定义SQL语句
            System.out.println("连接成功");

//5获取执行SQL的对象 statement

            String sql = "update zuzi set username=?,address=?,man=? where id=?";

//            PreparedStatement pst = connection.prepareStatement("");
//            执行SQL语句返回提交
//            pst.setString(1,username);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, man);
            preparedStatement.setString(4, id);
            int result = preparedStatement.executeUpdate();
            preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("返回成功");
                request.getRequestDispatcher("/findAll.do").forward(request, response);
            } else {
                System.out.println("跟新失败");
            }
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    }
