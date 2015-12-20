/**************************************************************************************** 
 Copyright © 2015-2020 LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.framework.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

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
public class BusiServlet extends HttpServlet {

    /**
     * serialVersionUID <br>
     */
    private static final long serialVersionUID = -3555951126111128846L;

    /**
     * logger <br>
     */
    private static Logger logger = Logger.getLogger(BusiServlet.class);


    /** 
     *  BusiServlet
     */ 
    public BusiServlet() {
        super();
    }

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br> <br>
     */ 
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
    }

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException <br>
     * @throws IOException <br>
     */ 
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding(ServiceObjectToJsonUtil.LOCAL_CHARSET);
        String data = request.getParameter("data");
        response.setContentType("text/html; charset=" + ServiceObjectToJsonUtil.LOCAL_CHARSET);
        Long tid = Thread.currentThread().getId();
        String returnValue = null;
        try {
            logger.info("[" + tid + "]service begin.....");
            returnValue = BusiFactoryServlet.initService(data, this.getServletContext());
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
            returnValue = e.getMessage();
        }
        finally {
            logger.debug("[" + tid + "]sreturnValue=" + returnValue);
            logger.info("[" + tid + "]service end.....");
        }
        PrintWriter out = response.getWriter();
        out.print(returnValue);
        out.close();
    }

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException <br>
     * @throws IOException <br>
     */ 
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(ServiceObjectToJsonUtil.LOCAL_CHARSET);
        response.setContentType("text/html; charset=" + ServiceObjectToJsonUtil.LOCAL_CHARSET);
        Long tid = Thread.currentThread().getId();
        String returnValue = null;
        try {
            logger.info("[" + tid + "]service begin.....");
            returnValue = BusiFactoryServlet.initService(receivePost(request), this.getServletContext());
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
            returnValue = e.getMessage();
        }
        finally {
            logger.debug("[" + tid + "]sreturnValue=" + returnValue);
            logger.info("[" + tid + "]service end.....");
        }
        PrintWriter out = response.getWriter();
        out.print(returnValue);
        out.close();

    }

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param request HttpServletRequest
     * @return String 
     * @throws IOException <br>
     */ 
    public static String receivePost(HttpServletRequest request) throws IOException {

        // 读取请求内容
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        // 将资料解码
        String reqBody = sb.toString();
        return URLDecoder.decode(reqBody, ServiceObjectToJsonUtil.LOCAL_CHARSET);
    }

}
