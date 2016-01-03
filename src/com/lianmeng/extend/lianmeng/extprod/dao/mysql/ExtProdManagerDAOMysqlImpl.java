/**************************************************************************************** 
 Copyright © 2015-2020  LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.extend.lianmeng.extprod.dao.mysql;

import java.util.ArrayList;
import java.util.HashMap;

import com.lianmeng.core.framework.exceptions.AppException;
import com.lianmeng.extend.lianmeng.extprod.dao.ExtProdManagerDAO;
import com.lianmeng.extend.lianmeng.extprod.domain.AbstractExtProdManager;

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

public class ExtProdManagerDAOMysqlImpl extends ExtProdManagerDAO {

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param paramT
     * @throws AppException <br>
     */
    @Override
    public void insert(AbstractExtProdManager paramT) throws AppException {
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
    public int update(AbstractExtProdManager paramT) throws AppException {
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
    public int delete(AbstractExtProdManager paramT) throws AppException {
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
    public ArrayList<HashMap<String, String>> queryLimitProdList() throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" select a.id,a.name,b.big_pic as pic,a.price,c.limit_price as limitprice,c.lef_time as lefttime  ");
        sqlBuffer.append(" from srv_prod a,im_picture b ,Srv_prod_limit c ");
        sqlBuffer.append("  where a.id=c.id and a.pic_id=b.id ");
        sqlBuffer.append(" and a.del_state='0' and b.del_state='0' and c.del_state='0' ");
        ArrayList<HashMap<String, String>> rtnList = (ArrayList<HashMap<String, String>>) this.queryList(sqlBuffer.toString(), array);
        return rtnList;
    }
    
    @Override
    public HashMap<String, String> queryProdDetailList(AbstractExtProdManager prod) throws AppException {
       
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" select a.id,a.addr_id,a.code,a.name,a.price,a.marketprice,a.inventory_area,if(a.state='1','YES','NO')  as available ");
        sqlBuffer.append(" ,b.lef_time as leftTime,b.buyLimit,b.limit_price,10 comment_count,a.grade score from srv_prod a ");
        sqlBuffer.append("  LEFT JOIN Srv_prod_limit b on a.id=b.id and b.del_state='0' ");
        sqlBuffer.append(" where a.del_state='0' and a.id = ? ");
        array.add(prod.getProdId());
        ArrayList<HashMap<String, String>> rtnList = (ArrayList<HashMap<String, String>>) this.queryList(sqlBuffer.toString(), array);
        HashMap<String, String> rtnMap = null;
        if (rtnList.size() > 0) {
            rtnMap = rtnList.get(0);
        }
        return rtnMap;
    }


    @Override
    public ArrayList<HashMap<String, String>> queryProdRelaPictureList(AbstractExtProdManager prod) throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" select a.prod_id,b.big_pic pic,c.big_pic big_pic from srv_prod_rela_picture a ");
        sqlBuffer.append("  LEFT JOIN im_picture b on a.pic_id=b.id and b.del_state='0' ");
        sqlBuffer.append("  LEFT JOIN im_picture c on a.big_pic_id=c.id and c.del_state='0' ");
        sqlBuffer.append("where a.prod_id= ? and a.del_state='0'   ");
        array.add(prod.getProdId());
        ArrayList<HashMap<String, String>> rtnList = (ArrayList<HashMap<String, String>>) this.queryList(sqlBuffer.toString(), array);
        return rtnList;
    }

    @Override
    public ArrayList<HashMap<String, String>> queryProdRelaSaleList(AbstractExtProdManager prod) throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" select sale_content from srv_prod_rela_sale where prod_id= ? ");
        array.add(prod.getProdId());
        ArrayList<HashMap<String, String>> rtnList = (ArrayList<HashMap<String, String>>) this.queryList(sqlBuffer.toString(), array);
        return rtnList;
    }
    
    
    @Override
    public ArrayList<HashMap<String, String>> queryBaseProdList(AbstractExtProdManager prod) throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" select a.*,b.big_pic pic from srv_prod a left join im_picture b  ");
        sqlBuffer.append(" on a.pic_id=b.id and b.del_state='0' where  a.del_state='0'  ");
        if (prod.getProdType() != null && !"".equals(prod.getProdType())) {
            sqlBuffer.append(" and a.prod_type= ?  or a.prod_type in(select id from Srvs_prod_type where parent_id = ? ) ");
            array.add(prod.getProdType());
            array.add(prod.getProdType());
        }
        if (prod.getProdName() != null && !"".equals(prod.getProdName())) {
            sqlBuffer.append(" and a.name like '%").append(prod.getProdName()).append("%'  ");
           // array.add(prod.getProdName());
        }
        if (prod.isProdNewFlag()) {
            //30天 作为新品
            sqlBuffer.append(" and a.create_date > now()-30000000 ");
        }
        
        if (prod.getProdId() != null && !"".equals(prod.getProdId())) {
            sqlBuffer.append(" and a.id= ?  ");
            array.add(prod.getProdId());
        }
        
        if ("sale_down".equals(prod.getOrderSeqType())) {
            sqlBuffer.append(" order by a.sale_count desc ");
        }
        else if ("sale_up".equals(prod.getOrderSeqType())) {
            sqlBuffer.append(" order by a.sale_count asc ");
        }
        else if ("price_up".equals(prod.getOrderSeqType())) {
            sqlBuffer.append(" order by a.price  asc ");
        }
        else if ("price_down".equals(prod.getOrderSeqType())) {
            sqlBuffer.append(" order by a.price desc  ");
        }
        else if ("comment_down".equals(prod.getOrderSeqType())) {
            sqlBuffer.append(" order by a.comment_count  desc ");
        }
        else if ("comment_up".equals(prod.getOrderSeqType())) {
            sqlBuffer.append(" order by a.comment_count asc  ");
        }
        else if ("shelves_down".equals(prod.getOrderSeqType())) {
            sqlBuffer.append(" order by a.create_date  desc ");
        }
        else if ("shelves_up".equals(prod.getOrderSeqType())) {
            sqlBuffer.append(" order by a.create_date asc  ");
        }
        
        
        ArrayList<HashMap<String, String>> rtnList = (ArrayList<HashMap<String, String>>) this.queryList(sqlBuffer.toString(), array);
        return rtnList;
    }

    @Override
    public ArrayList<HashMap<String, String>> queryProdTypeList(AbstractExtProdManager prod) throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" select a.id,a.name,a.parent_id,b.big_pic pic,a.tag,if(a.parent_id is not null ,'true','false') as isleafnode ");
        sqlBuffer.append(" from Srvs_prod_type a,im_picture b where a.del_state='0' ");
        sqlBuffer.append("  and a.pic_id=b.id ");
        if (prod.getProdType() != null && !"".equals(prod.getProdType())) {
            sqlBuffer.append(" and a.id= ?  ");
            array.add(prod.getProdType());
        }
        if (prod.getProdName() != null && !"".equals(prod.getProdName())) {
            sqlBuffer.append(" and a.name= ?  ");
            array.add(prod.getProdName());
        }
        sqlBuffer.append(" order by parent_id ");
        ArrayList<HashMap<String, String>> rtnList = (ArrayList<HashMap<String, String>>) this.queryList(sqlBuffer.toString(), array);
        return rtnList;
    }

    @Override
    public ArrayList<HashMap<String, String>> queryBasePubsFinalList(AbstractExtProdManager prod) throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" select id,name from pubs_final a where a.del_state='0' ");
        if (prod.getPubsFinalId() != null && !"".equals(prod.getPubsFinalId())) {
            sqlBuffer.append(" and a.id= ?  ");
            array.add(prod.getPubsFinalId());
        }
        if (prod.getPubsFinalParentId() != null && !"".equals(prod.getPubsFinalParentId())) {
            sqlBuffer.append(" and a.parent_id= ?  ");
            array.add(prod.getPubsFinalParentId());
        }
        if (prod.getPubsFinalKeyWord() != null && !"".equals(prod.getPubsFinalKeyWord())) {
            sqlBuffer.append(" and a.keyword= ?  ");
            array.add(prod.getPubsFinalKeyWord());
        }
        sqlBuffer.append(" order by parent_id,id ");
        ArrayList<HashMap<String, String>> rtnList = (ArrayList<HashMap<String, String>>) this.queryList(sqlBuffer.toString(), array);
        return rtnList;
    }

    @Override
    public ArrayList<HashMap<String, String>> queryBaseFavoriteList(AbstractExtProdManager prod) throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" select a.*,b.big_pic pic from srv_prod a  ");
        sqlBuffer.append(" left join im_picture b on a.pic_id=b.id and b.del_state='0' ");
        sqlBuffer.append(" left join Srv_prod_favorite c on c.prod_id=a.id and c.del_state='0' ");
        sqlBuffer.append("  where  a.del_state='0' and c.user_id= ? ");
        array.add(prod.getUserId());

        ArrayList<HashMap<String, String>> rtnList = (ArrayList<HashMap<String, String>>) this.queryList(sqlBuffer.toString(), array);
        return rtnList;
    }

    @Override
    public int addFavorite(AbstractExtProdManager prod) throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append("insert into Srv_prod_favorite (user_id,prod_id,del_state) values(?,?,'0')  ");
        array.add(prod.getUserId());
        array.add(prod.getProdId());
        return this.update(sBuffer.toString(), array);
    }

    @Override
    public int removeFavorite(AbstractExtProdManager prod) throws AppException {
        ArrayList<String> array = new ArrayList<String>();
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append("update Srv_prod_favorite a set a.del_state='1',a.del_date=NOW() where user_id= ?  and del_state='0' ");
        array.add(prod.getUserId());
        if (prod.getProdId() != null && "".equals(prod.getProdId())) {
            sBuffer.append("  and prod_id=?  ");
            array.add(prod.getProdId());
        }
        return this.update(sBuffer.toString(), array);
    }

}
