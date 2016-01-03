/**************************************************************************************** 
 Copyright © 2015-2020 LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.acco.domain;

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
public abstract class AbstractPayOrderManager {

    
    /**
     * userId <br>
     */
    private String userId;

    /**
     * id <br>
     */
    private String id;
   
    /**
     * name <br>
     */
    private String name;
    
    /**
     * channel <br>
     */
    private String channel;
    /**
     * account <br>
     */
    private String account;
    
    
    /**
     * state <br>
     */
    private String state;
    
    public String getState() {
        return state;
    }


    public void setState(String state) {
        this.state = state;
    }


    public String getUserId() {
        return userId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getChannel() {
        return channel;
    }


    public void setChannel(String channel) {
        this.channel = channel;
    }


    public String getAccount() {
        return account;
    }


    public void setAccount(String account) {
        this.account = account;
    }


    public String getOrderNo() {
        return orderNo;
    }


    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * orderNo <br>
     */
    private String orderNo;
    
    /**
     * prodId <br>
     */
    private String prodId;
    
    public String getProdId() {
        return prodId;
    }


    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

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


    /**
     * Description:解析dict <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param aDict DynamicDict
     * @throws AppException <br>
     */ 
    public void dictToBO(DynamicDict aDict) throws AppException {
       
        if (aDict.get("id") != null && !"".equals(aDict.get("id"))) {
            this.setId((String) aDict.getValueByName("id"));
        }
        if (aDict.get("userId") != null && !"".equals(aDict.get("userId"))) {
            this.setUserId((String) aDict.getValueByName("userId"));
        }
        if (aDict.get("name") != null && !"".equals(aDict.get("name"))) {
            this.setName((String) aDict.getValueByName("name"));
        }
        if (aDict.get("channel") != null && !"".equals(aDict.get("channel"))) {
            this.setChannel((String) aDict.getValueByName("channel"));
        }
        if (aDict.get("amount") != null && !"".equals(aDict.get("amount"))) {
            this.setAccount((String) aDict.getValueByName("amount"));
        }
        if (aDict.get("orderNo") != null && !"".equals(aDict.get("orderNo"))) {
            this.setOrderNo((String) aDict.getValueByName("orderNo"));
        }
        
        if (aDict.get("prodId") != null) {
            //DynamicDict prodId=(DynamicDict) aDict.get("prodId");
            ArrayList li = (ArrayList) aDict.getList("prodId");
            this.setProdIds(li);
            this.setProdId((String) aDict.getValueByName("prodId"));
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
    public abstract ArrayList<HashMap<String, String>> qryPayOrderListByUser() throws AppException;

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return 0
     * @throws AppException <br>
     */ 
    public abstract int payOrder() throws AppException;
    
    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return 0
     * @throws AppException <br>
     */ 
    public abstract int payFinishOrder() throws AppException;
    
}
