package com.fwtai.tool;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2018-12-09 18:23
 * @QQ号码 444141300
 * @官网 http://www.fwtai.com
 */
public final class ToolString{

    /**
     * 验证是否为空,为空时返回true,否则返回false,含obj是否为 _单独的下划线特殊字符,是则返回true,否则返回false
     * @作者: 田应平
     * @主页 www.fwtai.com
     * @创建日期 2016年8月18日 17:34:24
     */
    public final static boolean isBlank(final Object obj){
        if(obj == null)return true;
        final String temp = String.valueOf(obj);
        if(temp.toLowerCase().equals("null"))return true;
        final String key = obj.toString().replaceAll("\\s*", "");
        if(key.equals("") || key.length() <= 0 )return true;
        if(key.length() == 1 && key.equals("_"))return true;
        if(obj instanceof List<?>){
            final List<?> list = (List<?>) obj;
            return list == null || list.size() <= 0;
        }
        if(obj instanceof Map<?,?>){
            final Map<?,?> map = (Map<?,?>) obj;
            return map == null || map.size() <= 0;
        }
        if(obj instanceof String[]){
            boolean flag = false;
            final String[] require = (String[])obj;
            for(int i = 0; i < require.length; i++){
                if(require[i] == null || require[i].length() == 0 || require[i].replaceAll("\\s*", "").length() == 0){
                    flag = true;
                    break;
                }
            }
            return flag;
        }
        if(obj instanceof HashMap<?,?>){
            final HashMap<?, ?> hashMap = (HashMap<?,?>) obj;
            return hashMap == null || hashMap.size() <= 0;
        }
        if(obj instanceof JSONObject){
            final JSONObject json = (JSONObject)obj;
            return json.isEmpty();
        }
        return false;
    }
}