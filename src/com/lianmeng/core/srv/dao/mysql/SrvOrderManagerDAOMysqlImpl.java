/**************************************************************************************** 
 Copyright © 2015-2020 LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.srv.dao.mysql;

import java.util.ArrayList;
import java.util.HashMap;

import com.lianmeng.core.framework.exceptions.AppException;
import com.lianmeng.core.srv.dao.SrvOrderManagerDAO;
import com.lianmeng.core.srv.domain.AbstractSrvOrderManager;


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
public class SrvOrderManagerDAOMysqlImpl extends SrvOrderManagerDAO {

    @Override
    public void insert(AbstractSrvOrderManager paramT) throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append(" insert into Srv_order(id,code,state,prod_id,user_id,apply_date,prod_num,total_price,isgift,del_state,create_date) ");
        sBuffer.append(" values(?,?,'1003001',?,'1',now(),?,?,?,'0',now()) ");
        array.add(paramT.getOrderId());
        array.add(paramT.getOrderCode());
        array.add(paramT.getProdId());
        array.add(paramT.getProdNum());
        array.add(paramT.getProdNum());
        array.add(paramT.getIsgift());
        this.update(sBuffer.toString(), array);
    }

    @Override
    public int update(AbstractSrvOrderManager paramT) throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append(" update Srv_order a set a.modify_user= ? ,a.modify_date= now() ");
        array.add(paramT.getUserId());
        if (paramT.getProdNum() != null && !"".equals(paramT.getProdNum())) {
            sBuffer.append(" ,a.prod_num= ? ");
            array.add(paramT.getProdNum());
        }
        if (paramT.getTotalPrice() != null && !"".equals(paramT.getTotalPrice())) {
            sBuffer.append(" ,a.total_price= ? ");
            array.add(paramT.getTotalPrice());
        }
        sBuffer.append(" where user_id= ? and a.prod_id= ? and del_state='0' and state='1003001' ");
        array.add(paramT.getUserId());
        array.add(paramT.getProdId());
        return this.update(sBuffer.toString(), array);
    }

    @Override
    public int delete(AbstractSrvOrderManager paramT) throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append(" update Srv_order a set a.del_state='1',del_date=now() ");
        sBuffer.append(" where user_id= ? and a.prod_id= ? and del_state='0' ");
        array.add(paramT.getUserId());
        array.add(paramT.getProdId());
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
        ArrayList<HashMap<String, String>> rtnList = (ArrayList<HashMap<String, String>>) this.queryList("select * from srv_prod ", array);
        return rtnList.get(0);
    }
    
    
    @Override
    public ArrayList<HashMap<String, String>> qryBaseStateOrderList(AbstractSrvOrderManager order) throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sbf = new StringBuffer();
        sbf.append(" select a.code orderId,a.finish_date,a.code orderNo,b.id,a.code,b.name,d.name order_state ");
        sbf.append(" ,b.price,c.big_pic pic,if(a.isgift=1,'true','false') isgift ,a.addr_id  ");
        sbf.append(" ,a.prod_num prodNum,a.total_price subtotal,b.stock number,0 uplimit,b.grade,a.logistic_id,a.pay_method ");
        sbf.append(" from Srv_order a,srv_prod b,im_picture c,pubs_final d where a.del_state='0' and a.user_id= ?  ");
        sbf.append(" and a.prod_id=b.id and b.pic_id=c.id and a.state=d.id ");
        array.add(order.getUserId());
        
        
        if (order.getOrderCode() != null && !"".equals(order.getOrderCode())) {
            sbf.append(" and a.code = ? ");
            array.add(order.getOrderCode());
        }
        else if (order.getOrderCode() != null && !"".equals(order.getOrderCode())) {
            sbf.append(" and a.state= ? ");
            array.add(order.getState());
        }
        return this.queryList(sbf.toString(), array);
    }
    
    @Override
    public ArrayList<HashMap<String, String>> queryProdRelaSaleList(AbstractSrvOrderManager prod) throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" select sale_content from srv_prod_rela_sale where prod_id= ? ");
        array.add(prod.getProdId());
        ArrayList<HashMap<String, String>> rtnList = (ArrayList<HashMap<String, String>>) this.queryList(sqlBuffer.toString(), array);
        return rtnList;
    }

    @Override
    public ArrayList<HashMap<String, String>> qryHasOrderList(AbstractSrvOrderManager order) throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sbf = new StringBuffer();
        sbf.append(" select a.code orderId,a.state status,b.id,a.code,b.name,b.price,c.big_pic pic ");
        sbf.append(" ,if(a.isgift=1,'true','false') isgift,a.prod_num prodNum,date_format(a.create_date,'%Y-%m-%d %H:%i:%s') time,'1' flag ");
        sbf.append(" ,a.total_price subtotal,b.stock number,0 uplimit,b.grade,a.addr_id  ");
        sbf.append(" from Srv_order a,srv_prod b,im_picture c where a.del_state='0' and a.user_id= ? ");
        sbf.append(" and a.prod_id=b.id and b.pic_id=c.id ");
        array.add(order.getUserId());
        return this.queryList(sbf.toString(), array);
    }
    
    @Override
    public HashMap<String, String> qryAddressListById(String addressId) throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sbf = new StringBuffer();
        sbf.append(" select id,name,a.tele_no phonenumber,a.fixed_tele_no fixedtel,a.is_default isdefault,a.province_id provinceid ");
        sbf.append(" ,a.city_id cityid,a.area_id areaid,a.area_id address_area,a.detail areadetail,a.detail address_detail,a.zipcode ");
        sbf.append("  from Im_address a where id= ? "); //and a.del_state='0' 
        array.add(addressId);
        return this.queryList(sbf.toString(), array).get(0);
    }

}
