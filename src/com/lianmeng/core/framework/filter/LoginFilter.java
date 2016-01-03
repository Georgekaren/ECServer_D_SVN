package com.lianmeng.core.framework.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.redbaby.config.Constant;
import com.itheima.redbaby.service.CommonUtil;

/**
 * Description: <br>
 * 
 * @author XXX<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2016-1-3 <br>
 * @since V8<br>
 * @see com.lianmeng.core.framework.filter <br>
 */
public class LoginFilter implements Filter {

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
        HttpServletResponse resp = (HttpServletResponse) response;
        req.getSession();
        req.getSession().getId();
        String substring = req.getRequestURI().substring(req.getContextPath().length());
        if (urls.contains(substring)) {
            if (req.getSession().getAttribute("user") == null) {
                Map<String, Object> outMap = new HashMap<String, Object>();
                outMap.put(Constant.RESPONSE, "notlogin");
                CommonUtil.renderJson(resp, outMap);
                return;
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}
