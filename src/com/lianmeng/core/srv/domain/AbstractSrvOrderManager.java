/**************************************************************************************** 
 Copyright © 2015-2020 LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.srv.domain;

import java.util.ArrayList;
import java.util.HashMap;

import com.lianmeng.core.framework.bo.server.DynamicDict;
import com.lianmeng.core.framework.exceptions.AppException;


/** 
 * Description: <br> 
 *  
 * @author XXX<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2015-12-24 <br>
 * @since V8<br>
 * @see com.lianmeng.core.srv.domain <br>
 */
public abstract class AbstractSrvOrderManager {

    /**
     * orderId <br>
     */
    private String orderId;
    /**
     * orderCode <br>
     */
    private String orderCode;
    /**
     * userId <br>
     */
    private String userId;
    /**
     * prodId <br>
     */
    private String prodId;
    /**
     * prodNum <br>
     */
    private String prodNum;
    /**
     * totalPrice <br>
     */
    private String totalPrice;
    /**
     * isgift <br>
     */
    private String isgift;

    /**
     * state <br>
     */
    private String state;
    
    /**
     * prodIds <br>
     */
    private ArrayList<String> prodIds;
    
    public ArrayList<String> getProdIds() {
        return prodIds;
    }

    public void setProdIds(ArrayList<String> prodIds) {
        this.prodIds = prodIds;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getProdNum() {
        return prodNum;
    }

    public void setProdNum(String prodNum) {
        this.prodNum = prodNum;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getIsgift() {
        return isgift;
    }

    public void setIsgift(String isgift) {
        this.isgift = isgift;
    }
    
    /**
     * Description:解析dict <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param aDict DynamicDict
     * @throws AppException <br>
     */ 
    @SuppressWarnings("unchecked")
    public void dictToBO(DynamicDict aDict) throws AppException {
        if (aDict.get("orderId") != null && !"".equals(aDict.get("prodId"))) {
            this.setOrderId((String) aDict.getValueByName("orderId"));
        }
        if (aDict.get("orderNo") != null && !"".equals(aDict.get("orderNo"))) {
            this.setOrderCode((String) aDict.getValueByName("orderNo"));
        }
        if (aDict.get("prodId") != null) {
            ArrayList<String> li = (ArrayList<String>) aDict.getList("prodId");
            this.setProdIds(li);
            this.setProdId((String) aDict.getValueByName("prodId"));
        }
        if (aDict.get("userId") != null && !"".equals(aDict.get("userId"))) {
            this.setUserId((String) aDict.getValueByName("userId"));
        }
        if (aDict.get("prodNum") != null && !"".equals(aDict.get("prodNum"))) {
            this.setProdNum((String) aDict.getValueByName("prodNum"));
        }
        if (aDict.get("totalPrice") != null && !"".equals(aDict.get("totalPrice"))) {
            this.setTotalPrice((String) aDict.getValueByName("totalPrice"));
        }
        if (aDict.get("state") != null && !"".equals(aDict.get("state"))) {
            this.setState((String) aDict.getValueByName("state"));
        }

        if (aDict.get("isgift") != null && !"".equals(aDict.get("isgift"))) {
            this.setIsgift("1");
        }
        else {
            this.setIsgift("0"); 
        }
        
    }
    

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return 0
     * @throws AppException <br>
     */ 
    public abstract int add() throws AppException;

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return HashMap<String, String>
     * @throws AppException <br>
     */ 
    public abstract HashMap<String, String> qryProdDataById() throws AppException;
    
    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return ArrayList<HashMap<String, String>>
     * @throws AppException <br>
     */ 
    public abstract HashMap<String, Object> qryBaseCartOrderList() throws AppException;

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return 0
     * @throws AppException <br>
     */ 
    public abstract int remove() throws AppException;
    
    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return 0
     * @throws AppException <br>
     */ 
    public abstract int modify() throws AppException;
    
    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return ArrayList<HashMap<String, String>>
     * @throws AppException <br>
     */ 
    public abstract ArrayList<HashMap<String, String>> qryHasOrderList() throws AppException;

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return ArrayList<HashMap<String, String>>
     * @throws AppException <br>
     */ 
    public abstract HashMap<String, Object> qryHasPayOrderDetailList() throws AppException;
}
