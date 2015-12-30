/**************************************************************************************** 
 Copyright © 2015-2020  LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.extend.lianmeng.home.service;

import com.lianmeng.core.framework.bo.server.DynamicDict;
import com.lianmeng.core.framework.bo.server.IAction;
import com.lianmeng.core.framework.exceptions.AppException;
import com.lianmeng.core.framework.rest.app.util.ServiceObjectToJsonUtil;
import com.lianmeng.extend.lianmeng.home.domain.HomeManager;

/** 
 * Description: <br> 
 *  
 * @author XXX<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2015-12-21 <br>
 * @since V8<br>
 * @see com.lianmeng.extend.lianmeng.home.service <br>
 */

public class HomeManagerService implements IAction {

    /**
     * versionManager <br>
     */
    private HomeManager homeManager;

    public void setHomeManager(HomeManager homeManager) {
        this.homeManager = homeManager;
    }
    
    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param aDict DynamicDict
     * @return 0 
     * @throws AppException <br>
     */
    @Override
    public int perform(DynamicDict aDict) throws AppException {
        aDict.set("DATA_INFO", this.homeManager.qryHomeBarImgDataById());
        aDict.set(ServiceObjectToJsonUtil.RESPONSE_CODE, "homebar");
        return 0;
    }

}
