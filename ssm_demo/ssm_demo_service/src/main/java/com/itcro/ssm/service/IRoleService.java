package com.itcro.ssm.service;

import com.itcro.ssm.domain.Permission;
import com.itcro.ssm.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IRoleService {

    List<Role> findAll() throws Exception;

    void save(Role role);

    Role findById(String roleId);

    List<Permission> findOtherPermissions(String roleId);

    void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;
}
