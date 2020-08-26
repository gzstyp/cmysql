package com.fwtai.tool;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fwtai.config.ConfigFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2018-12-09 18:18
 * @QQ号码 444141300
 * @官网 http://www.fwtai.com
 */
public final class ToolClient{

    /**
     * 生成简单类型json字符串,仅用于查询返回,客户端只需判断code是否为200才操作,仅用于查询操作,除了list集合之外都可以用data.map获取数据,list的是data.listData
     * @作者 田应平
     * @注意 如果传递的是List则在客户端解析listData的key值,即data.listData;是map或HashMap或PageFormData解析map的key值,即data.map;否则解析obj的key值即data.obj或data.map
     * @用法 解析后判断data.code == AppKey.code.code200 即可
     * @返回值类型 返回的是json字符串,内部采用JSONObject封装,不可用于redis缓存value
     * @创建时间 2017年1月11日 上午10:27:53
     * @QQ号码 444141300
     * @主页 http://www.fwtai.com
    */
    public final static String queryJson(final Object object){
        final JSONObject json = new JSONObject();
        if(ToolString.isBlank(object)){
            return queryEmpty();
        }
        if(object instanceof Map<?,?>){
            final Map<?,?> map = (Map<?,?>) object;
            if(map == null || map.size() <= 0){
                queryEmpty();
            }else {
                json.put(ConfigFile.code,ConfigFile.code200);
                json.put(ConfigFile.msg,ConfigFile.msg200);
                json.put(ConfigFile.map,object);
                return json.toJSONString();
            }
        }
        if(object instanceof List<?>){
            final List<?> list = (List<?>) object;
            if(list == null || list.size() <= 0){
                return queryEmpty();
            }else {
                if (ToolString.isBlank(list.get(0))){
                    return queryEmpty();
                }else {
                    json.put(ConfigFile.code,ConfigFile.code200);
                    json.put(ConfigFile.msg,ConfigFile.msg200);
                    json.put(ConfigFile.listData,object);
                    final String jsonObj = json.toJSONString();
                    final JSONObject j = JSONObject.parseObject(jsonObj);
                    final String listData = j.getString(ConfigFile.listData);
                    if (listData.equals("[{}]")){
                        return queryEmpty();
                    }
                    return jsonObj;
                }
            }
        }
        if(String.valueOf(object).toLowerCase().equals("null") || String.valueOf(object).replaceAll("\\s*", "").length() == 0){
            return queryEmpty();
        }else {
            json.put(ConfigFile.code,ConfigFile.code200);
            json.put(ConfigFile.msg,ConfigFile.msg200);
            json.put(ConfigFile.obj,object);
            final String jsonObj = json.toJSONString();
            final JSONObject j = JSONObject.parseObject(jsonObj);
            final String obj = j.getString(ConfigFile.obj);
            if (obj.equals("{}")){
                return queryEmpty();
            }
            return jsonObj;
        }
    }

    /**
     * 查询时得到的数据为空返回的json字符串
     * @作者 田应平
     * @返回值类型 String
     * @创建时间 2017年1月11日 下午9:40:21
     * @QQ号码 444141300
     * @主页 http://www.fwtai.com
     */
    private static final String queryEmpty(){
        final JSONObject json = new JSONObject();
        json.put(ConfigFile.code,ConfigFile.code201);
        json.put(ConfigFile.msg,ConfigFile.msg201);
        return json.toJSONString();
    }

    /**
     * 获取表单的请求参数,不含文件域,返回的是HashMap<String,String>
     * @param request
     * @作者:田应平
     * @创建时间 2017年10月21日 16:03:16
     * @主页 www.fwtai.com
     */
    public final static HashMap<String,String> getFormFields(final HttpServletRequest request){
        final HashMap<String,String> params = new HashMap<String,String>();
        final Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()){
            final String key = paramNames.nextElement();
            final String[] values = request.getParameterValues(key);
            String value = "";
            if(values == null){
                value = "";
            }else {
                for (int i = 0; i < values.length; i++){
                    value = values[i] + ",";
                }
                value = value.substring(0,value.length() - 1);
            }
            params.put(key,value);
        }
        return params;
    }

    /**
     * 通用的响应json返回json对象,只能在是controller层调用
     * @param jsonObject,可以是Bean对象,map;HashMap;List
     * @param response
     * @注意 不能在service层调用
     * @作者 田应平
     * @创建时间 2016年8月18日 17:53:18
     * @QQ号码 444141300
     * @官网 http://www.fwtai.com
     */
    public final static void responseJson(final Object jsonObject,final HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Cache-Control","no-cache");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            if(jsonObject instanceof String){
                writer.write(JSON.parse(jsonObject.toString()).toString());
                writer.flush();
                writer.close();
                return;
            }else{
                writer.write(JSONArray.toJSONString(jsonObject));
                writer.flush();
                writer.close();
                return;
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            if(!ToolString.isBlank(writer)){
                writer.close();
            }
        }
    }

    /**
     * 响应返回客户端字符串,该obj对象字符串不是标准的json字符串!
     * @param
     * @作者 田应平
     * @QQ 444141300
     * @创建时间 2018年1月7日 17:31:10
     */
    public final static void responseObj(final Object obj,final HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Cache-Control","no-cache");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write(String.valueOf(obj));
            writer.flush();
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            if(writer != null){
                writer.close();
            }
        }
    }
}