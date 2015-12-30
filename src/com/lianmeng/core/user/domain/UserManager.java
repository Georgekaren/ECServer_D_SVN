/**************************************************************************************** 
 Copyright © 2015-2020 LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.user.domain;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.lianmeng.core.framework.exceptions.AppException;
import com.lianmeng.core.user.dao.UserManagerDAO;


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
public class UserManager extends AbstractUserManager {

    /**
     * logger <br>
     */
    private static Logger logger = Logger.getLogger(UserManager.class);

    /**
     * SrvOrderManagerDAO <br>
     */
    private UserManagerDAO userManagerDAO;

    public void setUserManagerDAO(UserManagerDAO userManagerDAO) {
        this.userManagerDAO = userManagerDAO;
    }

    @Override
    public int add() throws AppException {
        this.setId(String.valueOf(this.userManagerDAO.getSeq("SEQ_SRV_USER_ID")));
        this.userManagerDAO.insert(this);
        return 0;
    }

    
    
    @Override
    public int remove() throws AppException {
        this.userManagerDAO.delete(this);
        return 0;
    }
    
    @Override
    public int modify() throws AppException {
        this.userManagerDAO.update(this);
        return 0;
    }

    @Override
    public HashMap<String, String> qryUserByName() throws AppException {
        return this.userManagerDAO.qryUserByName(this);
    }
    
    @Override
    public HashMap<String, String> qryUserInfo() throws AppException {
        return this.userManagerDAO.qryUserInfo(this);
    }
    
}
