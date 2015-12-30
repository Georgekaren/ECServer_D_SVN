/**************************************************************************************** 
 Copyright © 2015-2020 LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.srv.domain;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;

import com.lianmeng.core.framework.bo.utils.DateUtilBase;
import com.lianmeng.core.framework.exceptions.AppException;
import com.lianmeng.core.srv.dao.SrvOrderManagerDAO;


/** 
 * Description: <br> 
 *  
 * @author XXX<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2015-12-24 <br>
 * @since V8<br>
 * @see com.lianmeng.core.srv.domain <br>
 */
public class SrvOrderManager extends AbstractSrvOrderManager {

    /**
     * logger <br>
     */
    private static Logger logger = Logger.getLogger(SrvOrderManager.class);

    /**
     * SrvOrderManagerDAO <br>
     */
    private SrvOrderManagerDAO srvOrderManagerDAO;

    public void setSrvOrderManagerDAO(SrvOrderManagerDAO srvOrderManagerDAO) {
        this.srvOrderManagerDAO = srvOrderManagerDAO;
    }

    @Override
    public int add() throws AppException {
        this.setOrderId(String.valueOf(this.srvOrderManagerDAO.getSeq("SEQ_SRV_ORDER_ID")));
        this.setOrderCode(DateUtilBase.getNameFileCurrentDate().replace("_", "") + RandomUtils.nextInt(10000));
        this.srvOrderManagerDAO.insert(this);
        return 0;
    }

    @Override
    public HashMap<String, String> qryProdDataById() throws AppException {
        return this.srvOrderManagerDAO.selectById("");
    }

    @Override
    public HashMap<String, Object> qryBaseCartOrderList() throws AppException {
        
        HashMap<String, Object> cartMap = new HashMap<String, Object>();
        ArrayList<HashMap<String, String>> orderList = this.srvOrderManagerDAO.qryBaseCartOrderList(this);
        cartMap.put("productlist", orderList);
        logger.info("productlist");
        this.setProdId(orderList.get(0).get("id"));
        ArrayList<String> cartPromListsub = new ArrayList<String>();
        ArrayList<HashMap<String, String>> cartPromList = this.srvOrderManagerDAO.queryProdRelaSaleList(this);
        for (int i = 0; i < cartPromList.size(); i++) {
            cartPromListsub.add(cartPromList.get(i).get("sale_content"));
        }
        cartMap.put("cart_prom", cartPromListsub);
        HashMap<String, String> cart_addup = new HashMap<String, String>();
        logger.info("cart_prom");
        double totalCount = 0;
        double totalPrice = 0;
       // double totalPoint = 0;
        for (int i = 0; i < orderList.size(); i++) {
            HashMap<String, String> orderMap = orderList.get(i);
            totalPrice = totalPrice + Double.valueOf(orderMap.get("subtotal"));
           // totalPoint = totalPoint + Double.valueOf(orderMap.get("grade"));
            totalCount = totalCount + Double.valueOf(orderMap.get("prodNum"));
        }
        cart_addup.put("total_count", String.valueOf(totalCount));
        cart_addup.put("total_price", String.valueOf(totalPrice));
        cart_addup.put("total_point", "100");
        cartMap.put("cart_addup", cart_addup);
        logger.info("cart_addup");
        return cartMap;
    }
    
    
    @Override
    public int remove() throws AppException {
        this.srvOrderManagerDAO.delete(this);
        return 0;
    }
    
    @Override
    public int modify() throws AppException {
        this.srvOrderManagerDAO.update(this);
        return 0;
    }

    @Override
    public ArrayList<HashMap<String, String>> qryHasOrderList() throws AppException {
        return this.srvOrderManagerDAO.qryHasOrderList(this);
    }
    
}
