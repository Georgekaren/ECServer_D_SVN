/**************************************************************************************** 
 Copyright © 2015-2020 LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.srv.domain;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

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
        for (int i = 0; i < this.getProdIds().size(); i++) {
            this.setOrderId(String.valueOf(this.srvOrderManagerDAO.getSeq("SEQ_SRV_ORDER_ID")));
            this.setOrderCode("0");
            this.setProdId(this.getProdIds().get(i));
            this.srvOrderManagerDAO.insert(this);
        }
        return 0;
    }

    @Override
    public HashMap<String, String> qryProdDataById() throws AppException {
        return this.srvOrderManagerDAO.selectById("");
    }

    @Override
    public HashMap<String, Object> qryBaseCartOrderList() throws AppException {
        this.setState("1003001");
        return getOrderBaseMap();
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
    
    @Override
    public HashMap<String, Object> qryHasPayOrderDetailList() throws AppException {
        if (this.getState() == null || "".equals(this.getState())) {
            this.setState("1003003");
        }
        HashMap<String, Object> hMap = getOrderBaseMap();
        return hMap;
    }
    
    
    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return HashMap<String, Object>
     * @throws AppException <br>
     */ 
    public HashMap<String, Object> getOrderBaseMap() throws AppException {
        HashMap<String, Object> cartMap = new HashMap<String, Object>();
        ArrayList<HashMap<String, String>> orderList = this.srvOrderManagerDAO.qryBaseStateOrderList(this);
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
        double totalPoint = 0;
        for (int i = 0; i < orderList.size(); i++) {
            HashMap<String, String> orderMap = orderList.get(i);
            totalPrice = totalPrice + Double.valueOf(orderMap.get("subtotal"));
            totalPoint = totalPoint + Double.valueOf(orderMap.get("grade"));
            totalCount = totalCount + Double.valueOf(orderMap.get("prodNum"));
        }
        cart_addup.put("total_count", String.valueOf(totalCount));
        cart_addup.put("total_price", String.valueOf(totalPrice));
        cart_addup.put("total_point", String.valueOf(totalPoint));
        cart_addup.put("freight", "0");  //运费 暂不处理
        cart_addup.put("prom_cut", "0"); //减价
        
        cartMap.put("cart_addup", cart_addup);
        logger.info("cart_addup");
        
        HashMap<String, String> address_info = new HashMap<String, String>();
        if (orderList.get(0).get("addr_id") != null && !"".equals(orderList.get(0).get("addr_id"))) {
            address_info = this.srvOrderManagerDAO.qryAddressListById(String.valueOf(orderList.get(0).get("addr_id")));
        }
        else if (orderList.get(0).get("addr_id") != null && !"".equals(orderList.get(0).get("addr_id"))) {
            address_info.put("id", "0");
            address_info.put("name", "缺");
            address_info.put("areadetail", "缺");
            address_info.put("address_detail", "缺");
        }
        cartMap.put("address_info", address_info);

        HashMap<String, String> invoice_info = new HashMap<String, String>();
        invoice_info.put("id", "1");
        invoice_info.put("title", "无");
        invoice_info.put("content", " ");
        cartMap.put("invoice_info", invoice_info);
        
        HashMap<String, String> payment_info = new HashMap<String, String>();
        payment_info.put("type", orderList.get(0).get("pay_method"));

        HashMap<String, String> delivery_info = new HashMap<String, String>();
        delivery_info.put("type", orderList.get(0).get("logistic_id"));

        cartMap.put("payment_info", payment_info);
        cartMap.put("delivery_info", delivery_info);
        
        HashMap<String, String> ords = new HashMap<String, String>();
        ords.put("time", orderList.get(0).get("finish_date"));
        ords.put("status", orderList.get(0).get("order_state"));
        ords.put("orderid", orderList.get(0).get("orderNo"));
        ords.put("flag", "1");
        
        cartMap.put("order_info", ords);
        
        return cartMap;
    }
}
