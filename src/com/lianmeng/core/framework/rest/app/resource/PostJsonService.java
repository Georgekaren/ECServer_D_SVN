/**************************************************************************************** 
 Copyright © 2015-2020 LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.framework.rest.app.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.lianmeng.core.framework.exceptions.AppException;
import com.lianmeng.core.framework.web.BusiFactoryServlet;


/** 
 * Description: <br> 
 *  
 * @author shen.zhi<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2015-11-19 <br>
 * @since V8<br>
 * @see com.lianmeng.core.framework.rest.app.resource <br>
 */
@Path("/lianmeng/postJsonService")
public class PostJsonService {

     /**
     * Description: <br> 
     * @author shen.zhi<br>
     * @taskId <br>
     * @param restModel restModel
     * @return <br>
     * @throws AppException 
     */ 
    @POST
    @Produces("application/json")
    public String ivokeService(String restModel) throws AppException {
        // 将参数转为json
        String rtnData = "";
        rtnData = BusiFactoryServlet.initRestService(restModel);
        return rtnData;
    }
    
    
    
}
