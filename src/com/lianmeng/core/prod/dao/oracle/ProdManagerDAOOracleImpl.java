/**************************************************************************************** 
 Copyright © 2015-2020 LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.prod.dao.oracle;

import java.util.ArrayList;
import java.util.HashMap;

import com.lianmeng.core.framework.exceptions.AppException;
import com.lianmeng.core.prod.dao.ProdManagerDAO;
import com.lianmeng.core.prod.domain.AbstractProdManager;

/** 
 * Description: <br> 
 *  
 * @author XXX<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2015-12-20 <br>
 * @since V8<br>
 * @see com.lianmeng.core.prod.dao.oracle <br>
 */
public class ProdManagerDAOOracleImpl extends ProdManagerDAO {

    @Override
    public void insert(AbstractProdManager paramT) throws AppException {
        // TODO Auto-generated method stub

    }

    @Override
    public int update(AbstractProdManager paramT) throws AppException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(AbstractProdManager paramT) throws AppException {
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
        ArrayList<HashMap<String, String>> rtnList = (ArrayList<HashMap<String, String>>) this.queryList("select * from srv_prod ", array);
        return rtnList.get(0);
    }

}
