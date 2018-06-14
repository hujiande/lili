package com.learn.chapter2.mapper;

import com.learn.chapter2.po.Role;

public interface RoleMapper {
    public Role getRole(Integer id);
    public int delRole(Integer id);
    public int insertRole(Role role);
}
