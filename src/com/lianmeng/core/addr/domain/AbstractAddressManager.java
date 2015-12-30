/**************************************************************************************** 
 Copyright © 2015-2020 LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.addr.domain;

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
public abstract class AbstractAddressManager {

    
    /**
     * userId <br>
     */
    private String userId;
    /**
     * parentId <br>
     */
    private String parentId;
    

    /**
     * id <br>
     */
    private String id;
   
    /**
     * name <br>
     */
    private String name;
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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
    public abstract ArrayList<HashMap<String, String>> qryAddressListByUser() throws AppException;

}
