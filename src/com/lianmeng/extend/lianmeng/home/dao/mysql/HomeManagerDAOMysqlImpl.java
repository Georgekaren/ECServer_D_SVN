/**************************************************************************************** 
 Copyright © 2015-2020  LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.extend.lianmeng.home.dao.mysql;

import java.util.ArrayList;
import java.util.HashMap;

import com.lianmeng.core.framework.exceptions.AppException;
import com.lianmeng.extend.lianmeng.home.dao.HomeManagerDAO;
import com.lianmeng.extend.lianmeng.home.domain.AbstractHomeManager;

/** 
 * Description: <br> 
 *  
 * @author XXX<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2015-12-21 <br>
 * @since V8<br>
 * @see com.lianmeng.extend.lianmeng.home.dao.mysql <br>
 */

public class HomeManagerDAOMysqlImpl extends HomeManagerDAO {

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param paramT
     * @throws AppException <br>
     */
    @Override
    public void insert(AbstractHomeManager paramT) throws AppException {
        // TODO Auto-generated method stub

    }

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param paramT
     * @return
     * @throws AppException <br>
     */
    @Override
    public int update(AbstractHomeManager paramT) throws AppException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param paramT
     * @return
     * @throws AppException <br>
     */
    @Override
    public int delete(AbstractHomeManager paramT) throws AppException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param paramString
     * @return
     * @throws AppException <br>
     */
    @Override
    public int deleteById(String paramString) throws AppException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param paramString
     * @return
     * @throws AppException <br>
     */
    @Override
    public HashMap<String, String> selectById(String paramString) throws AppException {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public ArrayList<HashMap<String, String>> queryHomeImgList() throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" select a.id,a.title,b.big_pic as url from pub_home_bar_lianmeng a,im_picture b  ");
        sqlBuffer.append(" where a.url=b.id and a.del_state='0' and b.del_state='0' ");
        ArrayList<HashMap<String, String>> rtnList = (ArrayList<HashMap<String, String>>) this.queryList(sqlBuffer.toString(), array);
        return rtnList;
    }

}
