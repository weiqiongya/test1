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

@WebServlet("/delInfo.do")
public class Delinfo extends HttpServlet {
    private static final long serialVersionUID=1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//1导入驱动jar包
//2注册驱动
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        System.out.println("id:"+id);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver") ;//这里会抛出异常 throws Exception直接全部抛出 只抛出一个的话后面还是会接着叫你抛出异常
//3获取连接对线
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wei?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC", "root", "wqy201010086");
//“jdbc:mysql://localhost:3306(这里数据库端口)/db3（这里是要连接的数据库） ？useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC（8.x.x以后连接数据库需要在后面这一串加入不然会报错说你时区不对）”,“root（这里是账号）”, “root（这里是密码)”
//4定义SQL语句
            System.out.println("连接成功");

            String sql ="delete from zuzi where id = "+id;
//5获取执行SQL的对象 statement
            PreparedStatement pst =connection.prepareStatement(sql);
//            执行SQL语句返回提交
            int result=pst.executeUpdate();
            if (result>0){
                System.out.println("返回成功");
                request.getRequestDispatcher("/findAll.do").forward(request,response);
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
