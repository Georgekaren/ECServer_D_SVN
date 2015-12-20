package com.lianmeng.core.prod.service;

import org.apache.commons.lang.StringUtils;

import com.lianmeng.core.framework.bo.server.DynamicDict;
import com.lianmeng.core.framework.bo.server.IAction;
import com.lianmeng.core.framework.exceptions.AppException;
import com.lianmeng.core.prod.domain.ProdManager;

/** 
 * Description: <br> 
 *  
 * @author XXX<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2015-12-20 <br>
 * @since V8<br>
 * @see com.lianmeng.core.prod.service <br>
 */
public class ProdManagerService implements IAction {

    /**
     * prodManager <br>
     */
    private ProdManager prodManager;

    public void setProdManager(ProdManager prodManager) {
        this.prodManager = prodManager;
    }

    @Override
    public int perform(DynamicDict aDict) throws AppException {
        String action = (String) aDict.getValueByName("ACTION");
        if (StringUtils.equals(action, "QRY")) {
            aDict.set("DATA_INFO", this.prodManager.qryProdDataById());
        }

        return 0;
    }

}
