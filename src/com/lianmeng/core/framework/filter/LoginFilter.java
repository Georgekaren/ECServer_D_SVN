package com.lianmeng.core.framework.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.lianmeng.core.framework.bo.server.DynamicDict;
import com.lianmeng.core.framework.exceptions.AppException;
import com.lianmeng.core.framework.rest.app.util.ServiceObjectToJsonUtil;

/**
 * Description: <br>
 * 
 * @author shen.zhi<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2016-1-3 <br>
 * @since V8<br>
 * @see com.lianmeng.core.framework.filter <br>
 */
public class LoginFilter implements Filter {

    /**
     * logger <br>
     */
    private static final Logger logger = Logger.getLogger(LoginFilter.class);
    /**
     * urls <br>
     */
    public static Set<String> urls = new HashSet<String>();

    static {
       // urls.add("/BusiServlet");
      //  urls.add("/LoginServlet");
        urls.add("/LoginJsonServlet");
        
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        req.getSession();
        req.getSession().getId();
        String substring = req.getRequestURI().substring(req.getContextPath().length());
        if (urls.contains(substring)) {
            if (req.getSession().getAttribute("user") == null) {
                DynamicDict dict = new DynamicDict();
                try {
                    dict.set(ServiceObjectToJsonUtil.RESPONSE_CODE, "notlogin");
                    dict.set("isSuccess", "true");
                }
                catch (AppException e) {
                    try {
                        dict.set("isSuccess", "false");

                        dict.set("MsgCode", "SYS-0002");
                        dict.set("Msg", e.getMessage());
                    }
                    catch (AppException e1) {
                        logger.debug("filterErro.");
                    }
                }
                String returnValue = ServiceObjectToJsonUtil.getJsonData(dict);
                PrintWriter out = response.getWriter();
                out.print(returnValue);
                out.close();
                return;
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}
