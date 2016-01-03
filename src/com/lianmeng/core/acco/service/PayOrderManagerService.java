package com.lianmeng.core.acco.service;


import org.apache.commons.lang.StringUtils;

import com.lianmeng.core.acco.domain.PayOrderManager;
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
 * @CreateDate 2015-12-30 <br>
 * @since V8<br>
 * @see com.lianmeng.core.addr.service <br>
 */
public class PayOrderManagerService implements IAction {

    
    /**
     * prodManager <br>
     */
    private PayOrderManager payOrderManager;

    public void setPayOrderManager(PayOrderManager payOrderManager) {
        this.payOrderManager = payOrderManager;
    }

    @Override
    public int perform(DynamicDict aDict) throws AppException {
        String action = (String) aDict.getValueByName("ACTION");
        if (StringUtils.equals(action, "MIMPAYORDERLIST")) {
            this.payOrderManager.dictToBO(aDict);
            this.payOrderManager.setState("1003002");
            this.payOrderManager.payOrder();
            aDict.set("DATA_INFO", PayOrderCharge.getCharge(this.payOrderManager.getOrderNo(),
                this.payOrderManager.getChannel(), this.payOrderManager.getAccount()));
            aDict.set("ORDERNO", this.payOrderManager.getOrderNo());
            
        }
        else if (StringUtils.equals(action, "MIMMODIFYPAYSTATEORDER")) {
            this.payOrderManager.dictToBO(aDict);
            this.payOrderManager.setState("1003003");
            this.payOrderManager.payFinishOrder();
        }
        

        aDict.set(ServiceObjectToJsonUtil.RESPONSE_CODE, "success");
        

        return 0;
    }
    
    
   

}
