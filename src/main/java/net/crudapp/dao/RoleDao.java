package net.crudapp.dao;

import net.crudapp.model.Role;

public interface RoleDao {
    Role getByRoleId(long id);
}
