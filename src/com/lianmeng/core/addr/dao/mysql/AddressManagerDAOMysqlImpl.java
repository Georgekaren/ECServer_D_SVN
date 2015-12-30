/**************************************************************************************** 
 Copyright © 2015-2020 LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.addr.dao.mysql;

import java.util.ArrayList;
import java.util.HashMap;

import com.lianmeng.core.addr.dao.AddressManagerDAO;
import com.lianmeng.core.addr.domain.AbstractAddressManager;
import com.lianmeng.core.framework.exceptions.AppException;



/** 
 * Description: <br> 
 *  
 * @author XXX<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2015-12-30 <br>
 * @since V8<br>
 * @see com.lianmeng.core.addr.dao.mysql <br>
 */
public class AddressManagerDAOMysqlImpl extends AddressManagerDAO {

    @Override
    public void insert(AbstractAddressManager paramT) throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append(" insert into Im_address(id) ");
        sBuffer.append(" values(?) ");
        array.add(paramT.getId());
        this.update(sBuffer.toString(), array);
    }

    @Override
    public int update(AbstractAddressManager paramT) throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sBuffer = new StringBuffer();
      
        return this.update(sBuffer.toString(), array);
    }

    @Override
    public int delete(AbstractAddressManager paramT) throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append(" update Im_address a set a.del_state='1',del_date=now() ");
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
        ArrayList<String> array = new ArrayList<String>();
        ArrayList<HashMap<String, String>> rtnList = (ArrayList<HashMap<String, String>>) this.queryList("select now() ", array);
        return rtnList.get(0);
    }
    
    
   

    @Override
    public ArrayList<HashMap<String, String>> qryAddressListByUser(AbstractAddressManager order) throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sbf = new StringBuffer();
        sbf.append(" select now() ");
        array.add(order.getUserId());
        return this.queryList(sbf.toString(), array);
    }

}
