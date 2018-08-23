package com.ivo.ew.sap.controller;

import com.ivo.ew.common.JsonResult;
import com.ivo.ew.common.PageResult;
import com.ivo.ew.sap.core.BapiCaller;
import com.ivo.ew.sap.core.SapCaller;
import com.ivo.ew.sap.model.SapFunction;
import com.ivo.ew.sap.service.SapFunctionService;
import com.sap.conn.jco.JCoException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * sap中function管理
 *
 * @author wangjian
 * @date 2018/8/16
 */
@Controller
@RequestMapping("/sap/function")
public class SapFunctionController {

    @Autowired
    private SapFunctionService sapFunctionService;

    @Autowired
    private BapiCaller bapiCaller;

    @RequiresPermissions("authorities:view")
    @RequestMapping()
    public String sapFunctions(Model model) {
        return "sap/executeFunction.html";
    }

    /**
     * 查询所有角色
     **/
    @RequiresPermissions("function:view")
    @ResponseBody
    @RequestMapping("/list")
    public PageResult<SapFunction> list(String keyword) {
        List<SapFunction> list = new ArrayList<>();
        SapFunction sapFunction = new SapFunction();
        sapFunction.setFunctionName("ZSD_EIF_VBSN");
        sapFunction.setDescription("ZSD_EIF_VBSN");
        list.add(sapFunction);
        return new PageResult<>(list);
    }

    @ResponseBody
    @RequestMapping("/queryFunctionParams")
    public JsonResult queryFunctionParams(String functionName) {

        Map map = bapiCaller.getFunctionParamsInfo(functionName);

        return JsonResult.ok().put("data", map);
    }


}
