package com.ivo.ew.system.service;

import com.ivo.ew.common.PageResult;
import com.ivo.ew.system.model.LoginRecord;

public interface LoginRecordService {

    boolean add(LoginRecord loginRecord);

    PageResult<LoginRecord> list(int pageNum, int pageSize, String startDate, String endDate, String account);
}
