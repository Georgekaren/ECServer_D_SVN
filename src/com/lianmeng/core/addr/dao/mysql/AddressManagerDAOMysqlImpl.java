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
        sBuffer.append(" insert into Im_address(id,user_id,name,tele_no,fixed_tele_no,province_id,city_id,area_id,detail,"); 
        sBuffer.append(" zipcode,is_default,level,position,note,del_state,create_date) ");
        sBuffer.append(" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,'0',now()) ");
        array.add(paramT.getId());
        array.add(paramT.getUserId());
        array.add(paramT.getName());
        array.add(paramT.getTeleNo());
        array.add(paramT.getFixedTelNo());
        array.add(paramT.getProvinceId());
        array.add(paramT.getCityId());
        array.add(paramT.getAreaId());
        array.add(paramT.getDetail());
        array.add(paramT.getZipCode());
        array.add(paramT.getIsDefault());
        array.add(paramT.getLevel());
        array.add(paramT.getPosition());
        array.add(paramT.getNote());
        this.update(sBuffer.toString(), array);
    }

    @Override
    public int update(AbstractAddressManager paramT) throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append("update Im_address a set a.modify_user = ?, a.modify_date = NOW() ");
        array.add(paramT.getUserId());
        if (paramT.getName() != null && !"".equals(paramT.getName())) {
            sBuffer.append(",a.name = ? ");
            array.add(paramT.getName());
        }
        if (paramT.getTeleNo() != null && !"".equals(paramT.getTeleNo())) {
            sBuffer.append(",a.tele_no = ? ");
            array.add(paramT.getTeleNo());
        }
        if (paramT.getFixedTelNo() != null && !"".equals(paramT.getFixedTelNo())) {
            sBuffer.append(",a.fixed_tele_no = ? ");
            array.add(paramT.getFixedTelNo());
        }
        if (paramT.getProvinceId() != null && !"".equals(paramT.getProvinceId())) {
            sBuffer.append(",a.province_id = ? ");
            array.add(paramT.getProvinceId());
        }
        if (paramT.getCityId() != null && !"".equals(paramT.getCityId())) {
            sBuffer.append(",a.city_id = ? ");
            array.add(paramT.getCityId());
        }
        if (paramT.getAreaId() != null && !"".equals(paramT.getAreaId())) {
            sBuffer.append(",a.area_id = ? ");
            array.add(paramT.getAreaId());
        }
        if (paramT.getDetail() != null && !"".equals(paramT.getDetail())) {
            sBuffer.append(",a.detail = ? ");
            array.add(paramT.getDetail());
        }
        if (paramT.getZipCode() != null && !"".equals(paramT.getZipCode())) {
            sBuffer.append(",a.zipcode = ? ");
            array.add(paramT.getZipCode());
        }
        if (paramT.getIsDefault() != null && !"".equals(paramT.getIsDefault())) {
            sBuffer.append(",a.is_default = ? ");
            array.add(paramT.getIsDefault());
        }
        if (paramT.getLevel() != null && !"".equals(paramT.getLevel())) {
            sBuffer.append(",a.level = ? ");
            array.add(paramT.getLevel());
        }
        if (paramT.getPosition() != null && !"".equals(paramT.getPosition())) {
            sBuffer.append(",a.position = ? ");
            array.add(paramT.getPosition());
        }
        if (paramT.getNote() != null && !"".equals(paramT.getNote())) {
            sBuffer.append(",a.note = ? ");
            array.add(paramT.getNote());
        }
        sBuffer.append(" where id = ? and del_state = '0' ");
        array.add(paramT.getId());
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
        String sql = "select * from Im_address where id = ? and del_state = '0' ";
        array.add(paramString);
        ArrayList<HashMap<String, String>> rtnList = (ArrayList<HashMap<String, String>>) this.queryList(sql, array);
        return rtnList.get(0);
    }
    
    
   

    @Override
    public ArrayList<HashMap<String, String>> qryAddressListByUser(AbstractAddressManager order) throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sbf = new StringBuffer();
        sbf.append(" select id,name,a.tele_no phonenumber,a.fixed_tele_no fixedtel,a.is_default isdefault ");
        sbf.append(" ,a.province_id provinceid,a.city_id cityid,a.area_id areaid,a.detail areadetail,a.zipcode ");
        sbf.append("  ,get_cant_name_by_id(a.province_id) provinceName ,get_cant_name_by_id(a.city_id) cityName");
        sbf.append("   ,get_cant_name_by_id(a.area_id) areaName  ");
        sbf.append("  from Im_address a where user_id= ? and a.del_state='0' ");
        array.add(order.getUserId());
        return this.queryList(sbf.toString(), array);
    }

    @Override
    public int setNoDefault(AbstractAddressManager paramT) throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append("update Im_address a set a.modify_user = ?, a.modify_date = NOW(),a.is_default = '0'  ");
        sBuffer.append(" where id <> ? and a.user_id= ? and del_state = '0' ");
        array.add(paramT.getUserId());
        array.add(paramT.getId());
        array.add(paramT.getUserId());
        return this.update(sBuffer.toString(), array);
    }

}
