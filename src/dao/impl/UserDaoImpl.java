package dao.impl;

import dao.UserDao;
import db.MysqlDB;
import vo.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public List<User> queryUsers() throws SQLException {
        //查询数据库
        //左连的方式进行查询
        String sql="select u.*, r.roleName from userInfo u left join roleInfo r on r.roleId=u.roleId";
        List<User> list=new ArrayList<>();
        MysqlDB mysqlDB=new MysqlDB();
        Connection conn=mysqlDB.getConn();
        Statement stmt=null;
        ResultSet rs=null;
        try{
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                //添加一个user
                User user=new User();
                //创建user信息
                user.setUserId(rs.getString("userId"));
                user.setUserName(rs.getString("userName"));
                user.setGender(rs.getInt("gender"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setRoleId(rs.getInt("roleId"));
                user.setRoleName(rs.getString("roleName"));
                list.add(user);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            rs.close();
            stmt.close();
            conn.close();
        }
        return list;
    }
}
