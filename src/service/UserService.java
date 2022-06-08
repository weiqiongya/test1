package service;

import vo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    List<User> queryUsers() throws SQLException;
}
