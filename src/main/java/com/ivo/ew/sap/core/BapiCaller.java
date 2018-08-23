package com.ivo.ew.sap.core;

import com.sap.conn.jco.JCoException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangjian
 * @date 2018/8/20
 */
@Component
public class BapiCaller extends SapCallerDefault {

    /**
     *
     * @param bapiName
     * @param importParams
     * @param tableName
     * @return
     */
    public List getObjects(String bapiName, Map importParams, String tableName) {

        String[] tableNames = {tableName};
        Map map = sapCall(bapiName, importParams, null, null,
                null, null, tableNames );

        List list = (List) map.get(tableName);
        return list;
    }

    /**
     *
     * @param bapiName
     * @param importParams
     * @param tableNames
     * @return
     */
    public Map getObjects(String bapiName, Map importParams, String[] tableNames) {

        Map map = sapCall(bapiName, importParams, null, null,
                null, null, tableNames);

        return map;
    }

    /**
     *
     * @param bapiName
     * @param importParams
     * @param inStructures
     * @param inTable
     * @param exportParams
     * @param exportTables
     * @return
     */
    public Map callBapi(String bapiName, Map importParams, Map inStructures, Map inTable,
                        String[] exportParams, String exportTables) {
        String[] tableNames = {exportTables};
        Map map = sapCall(bapiName, importParams, inStructures, inTable, exportParams,null, tableNames);

        return map;
    }

    public Map saveObject(String bapiName, Map importParams, String tableName, List list,
                          String[] exportParams, String[] exportTables ) {

        Map inTable = new HashMap();
        inTable.put(tableName, list);
        Map map = sapCall(bapiName, importParams, null, inTable, exportParams, null, exportTables);

        return map;
    }

    public Map saveObjects(String bapiName, Map importParams, Map inColParams, String tableName, List list,
                           String[] exportPrams, String[] exportTabels) {

        Map inTable = new HashMap();
        inTable.put(tableName, list);

        Map map = sapCall(bapiName, importParams, inColParams, inTable, exportPrams, null, exportTabels);

        return map;
    }
}
