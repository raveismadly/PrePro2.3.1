package web.service;

import web.dao.UserDao;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private UserDao userDao;
    @Autowired
    public void getUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public List<User> allUsers() {
        return userDao.allUsers();
    }
    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
    @Transactional
    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }
    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
    @Transactional
    @Override
    public User getUserById(int id) {
       return userDao.getUserById(id);
    }
}
