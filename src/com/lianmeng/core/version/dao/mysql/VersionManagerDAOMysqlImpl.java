/**************************************************************************************** 
 Copyright © 2015-2020  LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.version.dao.mysql;

import java.util.ArrayList;
import java.util.HashMap;

import com.lianmeng.core.framework.exceptions.AppException;
import com.lianmeng.core.version.dao.VersionManagerDAO;
import com.lianmeng.core.version.domain.AbstractVersionManager;

/** 
 * Description: <br> 
 *  
 * @author XXX<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2015-12-21 <br>
 * @since V8<br>
 * @see com.lianmeng.core.version.dao.mysql <br>
 */

public class VersionManagerDAOMysqlImpl extends VersionManagerDAO {

   
    @Override
    public void insert(AbstractVersionManager paramT) throws AppException {
        // TODO Auto-generated method stub

    }

    
    @Override
    public int update(AbstractVersionManager paramT) throws AppException {
        // TODO Auto-generated method stub
        return 0;
    }

   
    @Override
    public int delete(AbstractVersionManager paramT) throws AppException {
        // TODO Auto-generated method stub
        return 0;
    }

   
    @Override
    public int deleteById(String paramString) throws AppException {
        // TODO Auto-generated method stub
        return 0;
    }

   
    @Override
    public HashMap<String, String> selectById(String paramString) throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        String sql = "SELECT * FROM Pub_version where state='1' ";
        ArrayList<HashMap<String, String>> rtnList = (ArrayList<HashMap<String, String>>) this.queryList(sql, array);
        return rtnList.get(0);
    }

}
