package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDB {

    private final static String DB_DRIVER="com.mysql.jdbc.Driver"; //驱动
    private final static String DB_URL="jdbc:mysql://localhost:3306/水利管理系统";//地址
    private final static String DB_USER="root";//用户名
    private final static String DB_PASSwD ="wqy201010086";//密码
    public Connection getConn() {
        Connection conn = null;
        try {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSwD);
        }catch(SQLException throwables){
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
