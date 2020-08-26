package com.fwtai.controller;

import com.fwtai.service.CodeService;
import com.fwtai.tool.ToolClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2018-12-09 18:13
 * @QQ号码 444141300
 * @官网 http://www.fwtai.com
*/
@Controller
public class CodeController{

    @Autowired
    private CodeService codeService;

    @RequestMapping("/query")
    @ResponseBody
    public void query(final HttpServletRequest request,final HttpServletResponse response){
        final HashMap<String,String> formFields = ToolClient.getFormFields(request);
        final String json = codeService.query(formFields);
        ToolClient.responseJson(json,response);
    }

    @RequestMapping("/create")
    @ResponseBody
    public void create(final HttpServletRequest request,final HttpServletResponse response){
        final HashMap<String,String> formFields = ToolClient.getFormFields(request);
        final String json = codeService.query(formFields);
        ToolClient.responseJson(json,response);
    }
}