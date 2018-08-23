package com.ivo.ew.system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ivo.ew.system.model.Role;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {

    List<Role> selectByUserId(Integer userId);
}
