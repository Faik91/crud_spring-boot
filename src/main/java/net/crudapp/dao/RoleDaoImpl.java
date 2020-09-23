package net.crudapp.dao;

import net.crudapp.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Role getByRoleId(long id) {
        return this.entityManager.find(Role.class, id);
    }
}
