package com.lianmeng.core.user.service;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.lianmeng.core.framework.bo.server.DynamicDict;
import com.lianmeng.core.framework.bo.server.IAction;
import com.lianmeng.core.framework.exceptions.AppException;
import com.lianmeng.core.framework.rest.app.util.ServiceObjectToJsonUtil;
import com.lianmeng.core.user.domain.UserManager;


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
public class UserManagerService implements IAction {

    
    /**
     * prodManager <br>
     */
    private UserManager userManager;

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public int perform(DynamicDict aDict) throws AppException {
        String action = (String) aDict.getValueByName("ACTION");
        if (StringUtils.equals(action, "QRYUSER")) {
            this.userManager.dictToBO(aDict);
            HashMap<String, String> hMap = this.userManager.qryUserByName();
            aDict.set("DATA_INFO", hMap);
            aDict.set("USER_INFO", hMap);
        }
        else if (StringUtils.equals(action, "ADDUSER")) {
            this.userManager.dictToBO(aDict);
            this.userManager.add();
        }
        else if (StringUtils.equals(action, "DELUSER")) {
            this.userManager.dictToBO(aDict);
            this.userManager.remove();
        }
        else if (StringUtils.equals(action, "QRYUSERINFO")) {
            this.userManager.dictToBO(aDict);
            HashMap<String, String> hMap = this.userManager.qryUserInfo();
            aDict.set("DATA_INFO", hMap);
            aDict.set("USER_INFO", hMap);
        }
        else if (StringUtils.equals(action, "LOGOUTUSER")) {
            this.userManager.dictToBO(aDict);
            HashMap<String, String> hMap = new HashMap<String, String>();
            aDict.set("DATA_INFO", hMap);
            aDict.set("USER_INFO", hMap);
        }
        
        aDict.set(ServiceObjectToJsonUtil.RESPONSE_CODE, "loginseccess");
        

        return 0;
    }

}
