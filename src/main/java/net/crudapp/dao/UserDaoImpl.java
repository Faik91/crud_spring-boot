package net.crudapp.dao;


import net.crudapp.model.Role;
import net.crudapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Repository
public class UserDaoImpl implements UserDao {

    private RoleDao roleDao;

    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserByName(String username) {

        return (User) entityManager.createQuery("FROM User WHERE name =:name").setParameter("name", username).getSingleResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        return this.entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void addUser(User user) {
        //каждому новому юзеру даем роль 'ROLE_USER'
        Set<Role> roles = new HashSet<>();
        roles.add(this.roleDao.getByRoleId(1L));
        user.setRoles(roles);
        this.entityManager.persist(user);
    }

    @Override
    public void deleteUser(long id) {
        User user = (User) this.entityManager.find(User.class, id);
        this.entityManager.remove(user);
    }

    @Override
    public void editUser(User user) {
        this.entityManager.merge(user);

    }

    @Override
    public User getUserById(long id) {
        return (User) this.entityManager.find(User.class, id);

    }
}
