/**************************************************************************************** 
 Copyright © 2015-2020 LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.srv.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.lianmeng.core.framework.exceptions.AppException;
import com.lianmeng.core.framework.jdbc.BaseJdbcDAO;
import com.lianmeng.core.srv.domain.AbstractSrvOrderManager;


/** 
 * Description: <br> 
 *  
 * @author XXX<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2015-12-24 <br>
 * @since V8<br>
 * @see com.lianmeng.core.srv.dao <br>
 */
public abstract class SrvOrderManagerDAO extends BaseJdbcDAO<AbstractSrvOrderManager> {

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param order AbstractSrvOrderManager
     * @return ArrayList<HashMap<String, String>>
     * @throws AppException <br>
     */ 
    public abstract ArrayList<HashMap<String, String>> qryBaseStateOrderList(AbstractSrvOrderManager order) throws AppException;
    
    /**
     * Description: 查询产品关联的促销信息<br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param prod AbstractExtProdManager
     * @return ArrayList<HashMap<String, String>>
     * @throws AppException <br>
     */ 
    public abstract ArrayList<HashMap<String, String>> queryProdRelaSaleList(AbstractSrvOrderManager prod) throws AppException;
    /**
     * Description: 查询用户下定单信息<br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param prod AbstractExtProdManager
     * @return ArrayList<HashMap<String, String>>
     * @throws AppException <br>
     */ 
    public abstract ArrayList<HashMap<String, String>> qryHasOrderList(AbstractSrvOrderManager prod) throws AppException;

    /**
     * Description: 查询地址信息<br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param addressId String
     * @return ArrayList<HashMap<String, String>>
     * @throws AppException <br>
     */ 
    public abstract HashMap<String, String> qryAddressListById(String addressId) throws AppException;

    
}
