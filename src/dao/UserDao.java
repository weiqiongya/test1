package dao;

import vo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    List<User> queryUsers () throws SQLException;
}
