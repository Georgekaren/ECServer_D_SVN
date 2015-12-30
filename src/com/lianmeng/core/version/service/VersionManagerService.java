/**************************************************************************************** 
 Copyright © 2015-2020  LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.version.service;


import com.lianmeng.core.framework.bo.server.DynamicDict;
import com.lianmeng.core.framework.bo.server.IAction;
import com.lianmeng.core.framework.exceptions.AppException;
import com.lianmeng.core.framework.rest.app.util.ServiceObjectToJsonUtil;
import com.lianmeng.core.version.domain.VersionManager;

/** 
 * Description: <br> 
 *  
 * @author XXX<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2015-12-21 <br>
 * @since V8<br>
 * @see com.lianmeng.core.version.service <br>
 */

public class VersionManagerService implements IAction {

    /**
     * versionManager <br>
     */
    private VersionManager versionManager;

    public void setVersionManager(VersionManager versionManager) {
        this.versionManager = versionManager;
    }
    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param aDict  DynamicDict
     * @return 0
     * @throws AppException <br>
     */
    @Override
    public int perform(DynamicDict aDict) throws AppException {
        aDict.set("DATA_INFO", this.versionManager.qryVersionDataById());
        aDict.set(ServiceObjectToJsonUtil.RESPONSE_CODE, "version");
        return 0;
    }

}
