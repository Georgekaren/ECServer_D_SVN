/**************************************************************************************** 
 Copyright © 2015-2020 LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.acco.dao.mysql;

import java.util.ArrayList;
import java.util.HashMap;

import com.lianmeng.core.acco.dao.PayOrderManagerDAO;
import com.lianmeng.core.acco.domain.AbstractPayOrderManager;
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
public class PayOrderManagerDAOMysqlImpl extends PayOrderManagerDAO {

    @Override
    public void insert(AbstractPayOrderManager paramT) throws AppException {
       
    }

    @Override
    public int update(AbstractPayOrderManager paramT) throws AppException {
        return 0;
    }

    @Override
    public int delete(AbstractPayOrderManager paramT) throws AppException {
        return  0;
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
    public ArrayList<HashMap<String, String>> qryPayOrderListByUser(AbstractPayOrderManager order) throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sbf = new StringBuffer();
        sbf.append(" select now() ");
        array.add(order.getUserId());
        return this.queryList(sbf.toString(), array);
    }

    @Override
    public int payOrder(AbstractPayOrderManager prod) throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append("update Srv_order a set a.code= ?,a.state= ?,a.modify_user=?,a.pay_method= ? , a.logistic_id= ? ,a.modify_date=NOW() ");
        sBuffer.append(" where user_id= ? and prod_id= ? and del_state='0' ");
        array.add(prod.getOrderNo());
        array.add(prod.getState());
        array.add(prod.getUserId());
        if ("alipay".equals(prod.getChannel())) {
            array.add("1005002");
        }
        else if ("wx".equals(prod.getChannel())) {
            array.add("1005003");
        }
        else if ("upacp".equals(prod.getChannel())) {
            array.add("1005004");
        }
        else {
            array.add("1005005"); // 缺省时 货到付款 
        }
        array.add("1006001"); //默认商家送
        array.add(prod.getUserId());
        array.add(prod.getProdId());
        return this.update(sBuffer.toString(), array);
    }
    
    @Override
    public int payFinishOrder(AbstractPayOrderManager prod) throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append("update Srv_order a set a.state= ?,a.modify_user=?,a.modify_date=NOW() ");
        sBuffer.append(" where user_id= ? and code= ? and del_state='0' ");
        
        array.add(prod.getState());
        array.add(prod.getUserId());
        array.add(prod.getUserId());
        array.add(prod.getOrderNo());
        
        return this.update(sBuffer.toString(), array);
    }

}
