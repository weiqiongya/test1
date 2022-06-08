package service;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import vo.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService{
    @Override
    public List<User> queryUsers() throws SQLException {
        UserDao userDao=new UserDaoImpl();
        return userDao.queryUsers();
    }
}
