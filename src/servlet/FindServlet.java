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

@WebServlet("/findAll.do")
public class FindServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//1导入驱动jar包
//2注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver") ;//这里会抛出异常 throws Exception直接全部抛出 只抛出一个的话后面还是会接着叫你抛出异常
//3获取连接对线
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wei?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC", "root", "wqy201010086");
//“jdbc:mysql://localhost:3306(这里数据库端口)/db3（这里是要连接的数据库） ？useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC（8.x.x以后连接数据库需要在后面这一串加入不然会报错说你时区不对）”,“root（这里是账号）”, “root（这里是密码)”
//4定义SQL语句
            System.out.println("连接成功");
            String sql ="select * from zuzi";
//5获取执行SQL的对象 statement
            PreparedStatement pst=connection.prepareStatement(sql);
//            执行SQL语句返回提交
            ResultSet result= pst.executeQuery();
            List<ClassFind>list=new ArrayList<>();
            while (result.next()){
                int id = result.getInt("id");
                String username = result.getString("username");
                String address = result.getString("address");
                String man = result.getString("man");
                ClassFind find =new ClassFind(id,username,address,man);
                list.add(find);
            }
            connection.close();
            //绑定数据d
            request.setAttribute("list",list);
            //请求转发到find
            request.getRequestDispatcher("delete.jsp").forward(request,response);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}

