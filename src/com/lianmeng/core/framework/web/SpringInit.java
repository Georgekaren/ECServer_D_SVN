/**************************************************************************************** 
 Copyright © 2015-2020 LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.framework.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


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
public class SpringInit implements ServletContextListener {
    

    /**
     * springContext <br>
     */
    private static WebApplicationContext springContext;
    
    /** 
     *  SpringInit
     */ 
    public SpringInit() {
        super();
    }
    
    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param event ServletContextEvent<br>
     */ 
    public void contextInitialized(ServletContextEvent event) {
        springContext = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
    }
    

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param event ServletContextEvent<br>
     */ 
    public void contextDestroyed(ServletContextEvent event) {
    }
    
    public static ApplicationContext getApplicationContext() {
        return springContext;
    }

    
}
