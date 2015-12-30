/**************************************************************************************** 
 Copyright © 2015-2020 LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.user.dao.mysql;

import java.util.ArrayList;
import java.util.HashMap;

import com.lianmeng.core.framework.exceptions.AppException;
import com.lianmeng.core.user.dao.UserManagerDAO;
import com.lianmeng.core.user.domain.AbstractUserManager;

/** 
 * Description: <br> 
 *  
 * @author XXX<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2015-12-24 <br>
 * @since V8<br>
 * @see com.lianmeng.core.srv.dao.mysql <br>
 */
public class UserManagerDAOMysqlImpl extends UserManagerDAO {

    @Override
    public void insert(AbstractUserManager paramT) throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append(" insert into im_user(id,name,password,telephone,del_state,create_date) ");
        sBuffer.append(" values(?,?,?,?,'0',now()) ");
        array.add(paramT.getId());
        array.add(paramT.getName());
        array.add(paramT.getPassword());
        array.add(paramT.getTelephone());
        this.update(sBuffer.toString(), array);
    }

    @Override
    public int update(AbstractUserManager paramT) throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append(" update im_user a set  a.modify_user= ? ,a.modify_date= now() ");
        array.add(paramT.getId());
        if (paramT.getPassword() != null && !"".equals(paramT.getPassword())) {
            sBuffer.append(" ,a.password = ? ");
            array.add(paramT.getPassword());
        }
        if (paramT.getDefaultAddressId() != null && !"".equals(paramT.getDefaultAddressId())) {
            sBuffer.append(" ,a.default_receive_addr_id = ? ");
            array.add(paramT.getDefaultAddressId());
        }
        if (paramT.getTelephone() != null && !"".equals(paramT.getTelephone())) {
            sBuffer.append(" ,a.telephone = ? ");
            array.add(paramT.getTelephone());
        }
        if (paramT.getEmail() != null && !"".equals(paramT.getEmail())) {
            sBuffer.append(" ,a.email = ? ");
            array.add(paramT.getEmail());
        }
        sBuffer.append(" where a.id= ?  and a.del_state='0'  ");
        array.add(paramT.getId());
        return this.update(sBuffer.toString(), array);
    }

    @Override
    public int delete(AbstractUserManager paramT) throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append(" update im_user a set a.del_state='1',del_date=now() ");
        sBuffer.append(" where id= ?  and del_state='0' ");
        array.add(paramT.getId());
        return this.update(sBuffer.toString(), array);
    }

    @Override
    public int deleteById(String paramString) throws AppException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public HashMap<String, String> selectById(String paramString) throws AppException {
        return null;
    }
  
    @Override
    public HashMap<String, String> qryUserByName(AbstractUserManager user) throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" select id,name,telephone,address,a.default_receive_addr_id from im_user a  ");
        sqlBuffer.append("  where name= ? and password= ? and del_state='0' ");
        array.add(user.getName());
        array.add(user.getPassword());
        ArrayList<HashMap<String, String>> qResult = this.queryList(sqlBuffer.toString(), array);
        if (qResult.size() > 0) {
            return qResult.get(0);
        }
        else {
            return null;
        }
         
    }
    
    @Override
    public HashMap<String, String> qryUserInfo(AbstractUserManager user) throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" select id userId,name usersession,10 bonus,'5' level,1 ordercount,1 favoritescount ");
        sqlBuffer.append(" ,telephone,address,a.default_receive_addr_id from im_user a  ");
        sqlBuffer.append("  where id= ? and del_state='0' ");
        array.add(user.getId());
        ArrayList<HashMap<String, String>> qResult = this.queryList(sqlBuffer.toString(), array);
        if (qResult.size() > 0) {
            return qResult.get(0);
        }
        else {
            return null;
        }
         
    }

}
