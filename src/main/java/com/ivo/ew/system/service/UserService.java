package com.ivo.ew.system.service;

import com.ivo.ew.common.PageResult;
import com.ivo.ew.common.exception.BusinessException;
import com.ivo.ew.common.exception.ParameterException;
import com.ivo.ew.system.model.User;

public interface UserService {

    User getByUsername(String username);

    PageResult<User> list(int pageNum, int pageSize, boolean showDelete, String searchKey, String searchValue);

    User getById(Integer userId);

    boolean add(User user) throws BusinessException;

    boolean update(User user);

    boolean updateState(Integer userId, int state) throws ParameterException;

    boolean updatePsw(Integer userId, String username, String newPsw);

    boolean delete(Integer userId);

}
