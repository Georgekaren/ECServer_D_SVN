/**************************************************************************************** 
 Copyright © 2015-2020 LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.framework.rest;

import org.glassfish.jersey.server.ResourceConfig;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

/** 
 * Description: <br> 
 *  
 * @author shen.zhi<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2015-11-19 <br>
 * @since V8<br>
 * @see com.lianmeng.core.framework.rest <br>
 */

public class RestApplication extends ResourceConfig {

    /** 
     *  constructor
     */ 
    public RestApplication() {
        // 服务类所在的包路径
        packages("com.lianmeng.core.framework.rest.app.resource");
        // 注册Json转换器
        register(JacksonJsonProvider.class);
    }
}
