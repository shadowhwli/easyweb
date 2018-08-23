package com.ivo.ew.system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ivo.ew.system.model.User;

public interface UserMapper extends BaseMapper<User> {

    User getByUsername(String username);
}
