/**************************************************************************************** 
 Copyright © 2015-2020 LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.user.dao;

import java.util.HashMap;

import com.lianmeng.core.framework.exceptions.AppException;
import com.lianmeng.core.framework.jdbc.BaseJdbcDAO;
import com.lianmeng.core.user.domain.AbstractUserManager;


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
public abstract class UserManagerDAO extends BaseJdbcDAO<AbstractUserManager> {

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param order AbstractUserManager
     * @return ArrayList<HashMap<String, String>>
     * @throws AppException <br>
     */ 
    public abstract HashMap<String, String> qryUserByName(AbstractUserManager order) throws AppException;
    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param order AbstractUserManager
     * @return ArrayList<HashMap<String, String>>
     * @throws AppException <br>
     */ 
    public abstract HashMap<String, String> qryUserInfo(AbstractUserManager order) throws AppException;
    
    
    
}
