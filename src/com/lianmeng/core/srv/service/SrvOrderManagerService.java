package com.lianmeng.core.srv.service;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.lianmeng.core.framework.bo.server.DynamicDict;
import com.lianmeng.core.framework.bo.server.IAction;
import com.lianmeng.core.framework.exceptions.AppException;
import com.lianmeng.core.framework.rest.app.util.ServiceObjectToJsonUtil;
import com.lianmeng.core.srv.domain.SrvOrderManager;


/** 
 * Description: <br> 
 *  
 * @author XXX<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2015-12-24 <br>
 * @since V8<br>
 * @see com.lianmeng.core.srv.service <br>
 */
public class SrvOrderManagerService implements IAction {

    
    /**
     * prodManager <br>
     */
    private SrvOrderManager srvOrderManager;

    public void setSrvOrderManager(SrvOrderManager srvOrderManager) {
        this.srvOrderManager = srvOrderManager;
    }

    @Override
    public int perform(DynamicDict aDict) throws AppException {
        String action = (String) aDict.getValueByName("ACTION");
        if (StringUtils.equals(action, "QRY")) {
            aDict.set("DATA_INFO", this.srvOrderManager.qryProdDataById());
        }
        else if (StringUtils.equals(action, "ADDORDER")) {

            this.srvOrderManager.dictToBO(aDict);
            this.srvOrderManager.add();
        }
        else if (StringUtils.equals(action, "REMOVEORDER")) {

            this.srvOrderManager.dictToBO(aDict);
            this.srvOrderManager.remove();
        }
        else if (StringUtils.equals(action, "MODIFYORDER")) {

            this.srvOrderManager.dictToBO(aDict);
            this.srvOrderManager.modify();
        }
        else if (StringUtils.equals(action, "QRYBASEORDER")) {

            this.srvOrderManager.dictToBO(aDict);
            
            aDict.set("DATA_INFO", this.srvOrderManager.qryBaseCartOrderList());
            
        }
        else if (StringUtils.equals(action, "CHECKBASEORDER")) {

            this.srvOrderManager.dictToBO(aDict);
            HashMap<String, Object> ordMap = this.srvOrderManager.qryBaseCartOrderList();
            aDict.set("address_info", ordMap.get("address_info"));
            aDict.set("payment_info", ordMap.get("payment_info"));
            aDict.set("delivery_info", ordMap.get("delivery_info"));
            aDict.set("invoice_info", ordMap.get("invoice_info"));
            aDict.set("productlist", ordMap.get("productlist"));
            aDict.set("checkout_prom", ordMap.get("cart_prom"));
            aDict.set("checkout_addup", ordMap.get("cart_addup"));
        }
        else if (StringUtils.equals(action, "PAYENDDISPLAYORDER")) {

            this.srvOrderManager.dictToBO(aDict);
            HashMap<String, String> order_info = new HashMap<String, String>();
            order_info.put("orderid", "11");
            order_info.put("price", "11");
            order_info.put("paymenttype", "1");
            aDict.set("orderinfo", order_info);
           
        }
        else if (StringUtils.equals(action, "QRYHASORDER")) {

            this.srvOrderManager.dictToBO(aDict);
            
            aDict.set("DATA_INFO", this.srvOrderManager.qryHasOrderList());
            
        }
        else if (StringUtils.equals(action, "QRYHASPAYORDERDETAIL")) {
            this.srvOrderManager.dictToBO(aDict);
            HashMap<String, Object> ordMap = this.srvOrderManager.qryHasPayOrderDetailList();
            aDict.set("order_info", ordMap.get("order_info"));
            aDict.set("address_info", ordMap.get("address_info"));
            aDict.set("payment_info", ordMap.get("payment_info"));
            aDict.set("delivery_info", ordMap.get("delivery_info"));
            aDict.set("invoice_info", ordMap.get("invoice_info"));
            aDict.set("productlist", ordMap.get("productlist"));
            aDict.set("checkout_prom", ordMap.get("cart_prom"));
            aDict.set("checkout_addup", ordMap.get("cart_addup"));
            
        }
        aDict.set(ServiceObjectToJsonUtil.RESPONSE_CODE, "success");
        

        return 0;
    }

}
