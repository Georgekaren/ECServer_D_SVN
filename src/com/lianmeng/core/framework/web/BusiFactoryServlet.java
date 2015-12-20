/**************************************************************************************** 
 Copyright © 2015-2020 LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.framework.web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import net.sf.json.JSONObject;

import com.lianmeng.core.framework.bo.server.DynamicDict;
import com.lianmeng.core.framework.bo.server.IAction;
import com.lianmeng.core.framework.exceptions.AppException;
import com.lianmeng.core.framework.rest.app.util.ServiceObjectToJsonUtil;


/** 
 * Description: <br> 
 *  
 * @author XXX<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2015-12-20 <br>
 * @since V8<br>
 * @see com.lianmeng.core.framework.web <br>
 */
public class BusiFactoryServlet extends HttpServlet {

    /**
     * logger <br>
     */
    private static final Logger logger = Logger.getLogger(BusiFactoryServlet.class);

    /**
     * ctx <br>
     */
    private static WebApplicationContext ctx;


    /**
     * serialVersionUID <br>
     */
    private static final long serialVersionUID = 3412647653268849195L;

    /** 
     *  BusiFactoryServlet
     */ 
    public BusiFactoryServlet() {
        super();
        ctx = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
    }

    /**
     * Description: <br> 
     *  
     * @author shen.zhi<br>
     * @taskId <br>
     * @param requestData String
     * @param context ServletContext
     * @return String
     * @throws ServletException
     * @throws SystemException
     * @throws AppException <br>
     */ 
    public static String initService(String requestData, ServletContext context) throws  AppException {
        long serviceId;
        DynamicDict dict = new DynamicDict();
        long start;
        long end;
        serviceId = 0L;
        start = System.currentTimeMillis();
        logger.debug("Runtime层开始执行......");
        try {
            // {"ServiceName":"testJdbcSu" , "Data":{"PROJ_ORD_NO":"CR201512180464"}}
            String jsonString = requestData;
            // jsonString="{\"ServiceName\":\"testJdbcSu\" , \"Data\":{\"PROJ_ORD_NO\":\"CR201512180464\"}}";
            JSONObject json = ServiceObjectToJsonUtil.toJson(jsonString);
            dict = ServiceObjectToJsonUtil.json2BO(json);
            String servicename = dict.getServiceName();
            if (ctx == null) {
                ctx = WebApplicationContextUtils.getWebApplicationContext(context);
            }
            IAction iaction = (IAction) ctx.getBean(servicename);
            iaction.perform(dict);
            dict.set("isSuccess", "true");
        }
        catch (Exception e) {
            dict.set("isSuccess", "false");
            dict.set("MsgCode", "SYS-0002");
            dict.set("Msg", e.getMessage());
        }
        finally {
            end = System.currentTimeMillis();
        }

        end = System.currentTimeMillis();
        logger.debug("[" + serviceId + "],Runtime\u5C42\u6267\u884C\u7ED3\u675F\uFF0C\u6D88\u8017\u65F6\u95F4:" + (end - start));
        return ServiceObjectToJsonUtil.getJsonData(dict);
    }

    /**
     * Description: <br>
     * 
     * @author shen.zhi<br>
     * @taskId <br>
     * @param requestData requestData
     * @return String
     * @throws AppException <br>
     */
    public static String initRestService(String requestData) throws AppException {
        long serviceId;
        DynamicDict dict = new DynamicDict();
        long start;
        long end;
        serviceId = 0L;
        start = System.currentTimeMillis();
        logger.debug("Runtime层开始执行......");
        try {
            String jsonString = requestData;
            JSONObject json = ServiceObjectToJsonUtil.toJson(jsonString);
            dict = ServiceObjectToJsonUtil.json2BO(json);
            String servicename = dict.getServiceName();
            IAction iaction = (IAction) SpringInit.getApplicationContext().getBean(servicename);
            iaction.perform(dict);
            dict.set("isSuccess", "true");
        }
        catch (Exception e) {
            dict.set("isSuccess", "false");
            dict.set("MsgCode", "SYS-0002");
            dict.set("Msg", e.getMessage());
        }
        finally {
            end = System.currentTimeMillis();
        }

        end = System.currentTimeMillis();
        logger.debug("[" + serviceId + "],Runtime\u5C42\u6267\u884C\u7ED3\u675F\uFF0C\u6D88\u8017\u65F6\u95F4:" + (end - start));
        return ServiceObjectToJsonUtil.getJsonData(dict);
    }

}
