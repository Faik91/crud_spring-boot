package net.crudapp.service;

import net.crudapp.dao.UserDao;
import net.crudapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;


    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Override
    @Transactional
    public List<User> allUsers() {
        return this.userDao.allUsers();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        this.userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public void editUser(User user) {
        this.userDao.editUser(user);
    }

    @Override
    @Transactional
    public User getUserById(long id) {
        return this.userDao.getUserById(id);
    }
}
