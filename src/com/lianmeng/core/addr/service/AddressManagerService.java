package com.lianmeng.core.addr.service;


import org.apache.commons.lang.StringUtils;

import com.lianmeng.core.addr.domain.AddressManager;
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
public class AddressManagerService implements IAction {

    
    /**
     * prodManager <br>
     */
    private AddressManager addressManager;

    public void setAddressManager(AddressManager addressManager) {
        this.addressManager = addressManager;
    }

    @Override
    public int perform(DynamicDict aDict) throws AppException {
        String action = (String) aDict.getValueByName("ACTION");
        if (StringUtils.equals(action, "QRYADDRESSLIST")) {
            this.addressManager.dictToBO(aDict);
            aDict.set("DATA_INFO", this.addressManager.qryAddressListByUser());
        }
        else if (StringUtils.equals(action, "ADDADDRESS")) {

            this.addressManager.dictToBO(aDict);
            this.addressManager.add();
            aDict.set("DATA_INFO", this.addressManager.qryAddressListByUser());
        }
        else if (StringUtils.equals(action, "REMOVEADDRESS")) {

            this.addressManager.dictToBO(aDict);
            this.addressManager.remove();
        }
        else if (StringUtils.equals(action, "MODIFYADDRESS")) {

            this.addressManager.dictToBO(aDict);
            this.addressManager.modify();
            aDict.set("DATA_INFO", this.addressManager.qryAddressListByUser());
        }
        else if (StringUtils.equals(action, "MODIFYDEFAULT")) {

            this.addressManager.dictToBO(aDict);
            this.addressManager.modify();
            this.addressManager.setNoDefault();
        }

        aDict.set(ServiceObjectToJsonUtil.RESPONSE_CODE, "success");
        

        return 0;
    }

}
