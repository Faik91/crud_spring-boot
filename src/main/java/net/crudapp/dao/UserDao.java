package net.crudapp.dao;

import net.crudapp.model.User;

import java.util.List;

public interface UserDao {
    User getUserByName(String name);
    List<User> allUsers();
    void addUser(User user);
    void deleteUser(long id);
    void editUser(User user);
    User getUserById(long id);
}
