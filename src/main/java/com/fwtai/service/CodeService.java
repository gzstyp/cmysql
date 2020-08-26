package com.fwtai.service;

import com.fwtai.dao.DaoBase;
import com.fwtai.tool.ToolClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2018-12-09 18:52
 * @QQ号码 444141300
 * @官网 http://www.fwtai.com
*/
@Service
public class CodeService{

    @Autowired
    private DaoBase daoBase;

    public String query(final HashMap<String,String> params){
        try{
            final Integer total = daoBase.queryForInteger("sys_tables.queryTotal");
            params.put("total",total+"");
        }catch(Exception e){
            e.printStackTrace();
        }
        return ToolClient.queryJson(params);
    }
}