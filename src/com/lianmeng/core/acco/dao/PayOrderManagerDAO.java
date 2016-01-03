/**************************************************************************************** 
 Copyright © 2015-2020 LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.acco.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.lianmeng.core.acco.domain.AbstractPayOrderManager;
import com.lianmeng.core.framework.exceptions.AppException;
import com.lianmeng.core.framework.jdbc.BaseJdbcDAO;



/** 
 * Description: <br> 
 *  
 * @author XXX<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2015-12-30 <br>
 * @since V8<br>
 * @see com.lianmeng.core.addr.dao <br>
 */
public abstract class PayOrderManagerDAO extends BaseJdbcDAO<AbstractPayOrderManager> {

     /**
     * Description: 查询产品关联的促销信息<br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param prod AbstractExtProdManager
     * @return ArrayList<HashMap<String, String>>
     * @throws AppException <br>
     */ 
    public abstract ArrayList<HashMap<String, String>> qryPayOrderListByUser(AbstractPayOrderManager prod) throws AppException;

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param prod AbstractPayOrderManager
     * @return 0
     * @throws AppException <br>
     */ 
    public abstract int payOrder(AbstractPayOrderManager prod) throws AppException;
    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param prod AbstractPayOrderManager
     * @return 0
     * @throws AppException <br>
     */ 
    public abstract int payFinishOrder(AbstractPayOrderManager prod) throws AppException;

}
