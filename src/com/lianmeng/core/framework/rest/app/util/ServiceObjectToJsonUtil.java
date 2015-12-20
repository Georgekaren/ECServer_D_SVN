/**************************************************************************************** 
 Copyright © 2015-2020 LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.framework.rest.app.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.map.ListOrderedMap;

import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;


import com.lianmeng.core.framework.bo.server.DynamicDict;
import com.lianmeng.core.framework.bo.utils.BOUtils;
import com.lianmeng.core.framework.bo.utils.StringUtil;
import com.lianmeng.core.framework.exceptions.AppException;




/** 
 * Description: <br> 
 *  
 * @author shen.zhi<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2015-11-20 <br>
 * @since V8<br>
 * @see com.lianmeng.core.framework.rest.app.util <br>
 */

public class ServiceObjectToJsonUtil {

    /**
     * 字符集设置<br>
     */
    public static final String LOCAL_CHARSET = "UTF-8";
    /**
     * 
     * DynamicDict转换成JSON <br> 
     *  
     * @author shen.zhi<br>
     * @taskId <br>
     * @param dict <br>
     * @return JSON <br>
     * @throws AppException <br>
     */
    public static String bo2JsonString(DynamicDict dict) throws AppException {
        String xml = BOUtils.bo2xml(dict, "");
        return xml2Json(xml);
    }
    
    /**
     * 
     * XML转换成JSON <br> 
     *  
     * @author shen.zhi<br>
     * @taskId <br>
     * @param xml <br>
     * @return JSON <br>
     */
    public static String xml2Json(String xml) {
        return new XMLSerializer().read(xml).toString();
    }

   
    
    
    /**
     * Description: 将对象类型转换成 Json，支持三种格式(ArrayList\Map\DynamicDict)<br>
     * 
     * @author shen.zhi<br>
     * @taskId <br>
     * @param obj Object
     * @return <br>
     */
    @SuppressWarnings("rawtypes")
    public static String getJsonData(Object obj) {
        String rtnString = "";
        if (obj instanceof ArrayList) {
            rtnString = getJsonStringByList((List) obj);
        }
        else if (obj instanceof DynamicDict) {
            rtnString = getJsonStringByDynamicDict((DynamicDict) obj);
        }
        else if (obj instanceof HashMap) {
            rtnString = getJsonStringByMap((HashMap) obj);
        }
        else if (obj instanceof ListOrderedMap) {
            rtnString = getJsonStringByListOrderMap((ListOrderedMap) obj);
        }
        if (rtnString.endsWith(",")) {
            rtnString = rtnString.substring(0, rtnString.lastIndexOf(","));
        }
        return rtnString;
    }

    /**
     * Description: 通过list 获取json String<br>
     * 
     * @author shen.zhi<br>
     * @taskId <br>
     * @param jsonList List
     * @return <br>
     */
    @SuppressWarnings({
        "unchecked", "rawtypes"
        })
    public static String getJsonStringByList(List jsonList) {
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append("[");
        for (int j = 0; j < jsonList.size(); j++) {
            Object obj = jsonList.get(j);
            if (obj instanceof DynamicDict) {
                sBuffer.append(getJsonStringByDynamicDict((DynamicDict) obj));
            }
            else if (obj instanceof HashMap) {
                sBuffer.append(getJsonStringByMap((HashMap<String, Object>) obj));
            }
            else if (obj instanceof ListOrderedMap) {
                sBuffer.append(getJsonStringByListOrderMap((ListOrderedMap) obj));
            }
            else if (obj instanceof ArrayList) {
                sBuffer.append(getJsonStringByList((List) obj));
            }
            else {
                sBuffer.append("'").append(jsonList.get(j)).append("',");
            }
            if (j == jsonList.size() - 1 && sBuffer.toString().endsWith(",")) {
                String sString = sBuffer.toString().substring(0, sBuffer.toString().lastIndexOf(","));
                sBuffer.setLength(0);
                sBuffer.append(sString);
            }
        }

        sBuffer.append("],");

        return sBuffer.toString();
    }

    /**
     * Description: 通过DynamicDict 获取json String<br>
     * 
     * @author shen.zhi<br>
     * @taskId <br>
     * @param dict DynamicDict
     * @return <br>
     */
    @SuppressWarnings("rawtypes")
    public static String getJsonStringByDynamicDict(DynamicDict dict) {
        StringBuffer sBuffer = new StringBuffer();
        String rtnString = "";
        sBuffer.append("{");
        HashMap<String, Object> valueMap = dict.valueMap;
        for (Iterator subit = valueMap.entrySet().iterator(); subit.hasNext();) {
            Entry sube = (Entry) subit.next();
            sBuffer.append("'").append(sube.getKey()).append("':");
            if (sube.getValue() instanceof ArrayList) {
                sBuffer.append(getJsonStringByList((List) sube.getValue()));
            }
            else if (sube.getValue() instanceof DynamicDict) {
                sBuffer.append(getJsonStringByDynamicDict((DynamicDict) sube.getValue()));
            }
            else if (sube.getValue() instanceof HashMap) {
                sBuffer.append(getJsonStringByMap((HashMap) sube.getValue()));
            }
            else if (sube.getValue() instanceof ListOrderedMap) {
                sBuffer.append(getJsonStringByListOrderMap((ListOrderedMap) sube.getValue()));
            }
            else {
                sBuffer.append("'").append(sube.getValue() == null ? "" : sube.getValue()).append("',");
            }
        }
        rtnString = sBuffer.toString();
        if (rtnString.length() > 0 && rtnString.endsWith(",")) {
            rtnString = rtnString.substring(0, rtnString.lastIndexOf(","));
        }
        rtnString += "},";
        return rtnString;
    }

    /**
     * Description: 通过HashMap 获取json String<br>
     * 
     * @author shen.zhi<br>
     * @taskId <br>
     * @param dMap dMap
     * @return <br>
     */
    @SuppressWarnings({
        "rawtypes", "unchecked"
        })
    public static String getJsonStringByMap(HashMap dMap) {
        StringBuffer sBuffer = new StringBuffer();
        String rtnString = "";
        sBuffer.append("{");
        HashMap<String, Object> valueMap = dMap;
        for (Iterator subit = valueMap.entrySet().iterator(); subit.hasNext();) {
            Entry sube = (Entry) subit.next();
            sBuffer.append("'").append(sube.getKey()).append("':");
            if (sube.getValue() instanceof ArrayList) {
                sBuffer.append(getJsonStringByList((List) sube.getValue()));
            }
            else if (sube.getValue() instanceof DynamicDict) {
                sBuffer.append(getJsonStringByDynamicDict((DynamicDict) sube.getValue()));
            }
            else if (sube.getValue() instanceof HashMap) {
                sBuffer.append(getJsonStringByMap((HashMap) sube.getValue()));
            }
            else if (sube.getValue() instanceof ListOrderedMap) {
                sBuffer.append(getJsonStringByListOrderMap((ListOrderedMap) sube.getValue()));
            }
            else {
                sBuffer.append("'").append(sube.getValue() == null ? "" : sube.getValue()).append("',");
            }
        }
        rtnString = sBuffer.toString();
        if (rtnString.length() > 0 && rtnString.endsWith(",")) {
            rtnString = rtnString.substring(0, rtnString.lastIndexOf(","));
        }
        rtnString += "},";
        return rtnString;
    }
    
    
    /**
     * Description: 通过HashMap 获取json String<br>
     * 
     * @author shen.zhi<br>
     * @taskId <br>
     * @param dMap dMap
     * @return <br>
     */
    @SuppressWarnings({
        "rawtypes"
        })
    public static String getJsonStringByListOrderMap(ListOrderedMap dMap) {
        StringBuffer sBuffer = new StringBuffer();
        String rtnString = "";
        sBuffer.append("{");
        ListOrderedMap valueMap = dMap;
        for (Iterator subit = valueMap.entrySet().iterator(); subit.hasNext();) {
            Entry sube = (Entry) subit.next();
            sBuffer.append("'").append(sube.getKey()).append("':");
            if (sube.getValue() instanceof ArrayList) {
                sBuffer.append(getJsonStringByList((List) sube.getValue()));
            }
            else if (sube.getValue() instanceof DynamicDict) {
                sBuffer.append(getJsonStringByDynamicDict((DynamicDict) sube.getValue()));
            }
            else if (sube.getValue() instanceof HashMap) {
                sBuffer.append(getJsonStringByMap((HashMap) sube.getValue()));
            }
            else if (sube.getValue() instanceof ListOrderedMap) {
                sBuffer.append(getJsonStringByListOrderMap((ListOrderedMap) sube.getValue()));
            }
            else {
                sBuffer.append("'").append(sube.getValue() == null ? "" : sube.getValue()).append("',");
            }
        }
        rtnString = sBuffer.toString();
        if (rtnString.length() > 0 && rtnString.endsWith(",")) {
            rtnString = rtnString.substring(0, rtnString.lastIndexOf(","));
        }
        rtnString += "},";
        return rtnString;
    }
    
    /**
     * Description:字符串转JSON <br> 
     *  
     * @author shen.zhi<br>
     * @taskId <br>
     * @param jsonStr 参数
     * @return JSONObject<br>
     */ 
    public static JSONObject toJson(String jsonStr) {
        JSONObject json = JSONObject.fromObject(jsonStr);
        Object data = json.remove("Data");
        if ((data != null) && ((data instanceof JSONObject))) {
            json.putAll((JSONObject) data);
        }
        else {
            json.put("Data", data);
        }
        return json;
    }
    

    /**
     * Description: <br> 
     *  
     * @author tanghuiyao<br>
     * @taskId <br>
     * @param json 参数
     * @return DynamicDict
     * @throws AppException <br>
     */ 
    @SuppressWarnings("rawtypes")
    public static DynamicDict json2BO(JSONObject json) throws AppException {
        DynamicDict dict = new DynamicDict();
        if (json != null) {
            for (Iterator i = json.entrySet().iterator(); i.hasNext();) {
                Map.Entry entry = (Map.Entry) i.next();
                String key = (String) entry.getKey();
                Object value = entry.getValue();
                dict.set(key, obj2BoInnerObj(value));
            }
            if (StringUtil.isNotEmpty(json.getString("ServiceName"))) {
                dict.setServiceName(json.getString("ServiceName"));
            }
        }
        return dict;
    }
    
    

    /**
     * Description: obj转dict<br> 
     *  
     * @author tanghuiyao<br>
     * @taskId <br>
     * @param obj 参数
     * @return dict object
     * @throws AppException <br>
     */ 
    @SuppressWarnings({
        "rawtypes", "unchecked"
        })
    private static Object obj2BoInnerObj(Object obj) throws AppException {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Map)) {
            DynamicDict dict = new DynamicDict();
            for (Iterator i = ((Map) obj).entrySet().iterator(); i.hasNext();) {
                Map.Entry entry = (Map.Entry) i.next();
                String key = entry.getKey().toString();
                Object value = entry.getValue();
                dict.set(key, obj2BoInnerObj(value));
            }
            return dict;
        }
        if ((obj instanceof Iterable)) {
            List list = new ArrayList();
            for (Iterator i = ((Iterable) obj).iterator(); i.hasNext();) {
                Object subObj = i.next();
                list.add(obj2BoInnerObj(subObj));
            }
            return list;
        }
        if (obj.getClass().isArray()) {
            List list = new ArrayList();
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                Object subobj = Array.get(obj, i);
                list.add(obj2BoInnerObj(subobj));
            }
            return list;
        }
        return obj;
    }
    
    
    /**
     * Description: 通过HashMap 获取json String<br>
     * 
     * @author shen.zhi<br>
     * @taskId <br>
     * @param dMap dMap
     * @return <br>
     */
    @SuppressWarnings({"rawtypes"})
    public static HashMap<String, String> getHashMapByListOrderMap(ListOrderedMap dMap) {
        ListOrderedMap valueMap = dMap;
        HashMap<String, String> rtnMap = new HashMap<String, String>();
        for (Iterator subit = valueMap.entrySet().iterator(); subit.hasNext();) {
            Entry sube = (Entry) subit.next();
            if (sube.getKey() != null) {
                rtnMap.put(sube.getKey().toString(), sube.getValue() == null ? "" : sube.getValue().toString());
            }
        }
        return rtnMap;
    }
}
