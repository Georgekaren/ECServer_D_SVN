/**************************************************************************************** 
 Copyright © 2015-2020  LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.extend.lianmeng.extprod.domain;

import java.util.ArrayList;
import java.util.HashMap;

import com.lianmeng.core.framework.exceptions.AppException;
import com.lianmeng.extend.lianmeng.extprod.dao.ExtProdManagerDAO;

/** 
 * Description: <br> 
 *  
 * @author XXX<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2015-12-21 <br>
 * @since V8<br>
 * @see com.lianmeng.extend.lianmeng.home.domain <br>
 */

public class ExtProdManager extends AbstractExtProdManager {

    /**
     * serialVersionUID <br>
     */
    private static final long serialVersionUID = -37984139298003341L;

    /**
     * homenManagerDAO <br>
     */
    private ExtProdManagerDAO extProdManagerDAO;

    public void setExtProdManagerDAO(ExtProdManagerDAO extProdManagerDAO) {
        this.extProdManagerDAO = extProdManagerDAO;
    }
    
    @Override
    public ArrayList<HashMap<String, String>> queryLimitProdList() throws AppException {
        return this.extProdManagerDAO.queryLimitProdList();
    }
    
    @Override
    public HashMap<String, Object> queryProdDetailList() throws AppException {
        HashMap<String, Object> rtnProdDetail = new HashMap<String, Object>();
        HashMap<String, String> finBaseProd = this.extProdManagerDAO.queryProdDetailList(this);
        if (finBaseProd != null) {
            rtnProdDetail.putAll(finBaseProd);
            ArrayList<String> piclist = new ArrayList<String>();
            ArrayList<String> bigpiclist = new ArrayList<String>();

            ArrayList<HashMap<String, String>> picPicBiglist = this.extProdManagerDAO.queryProdRelaPictureList(this);
            for (int i = 0; i < picPicBiglist.size(); i++) {
                HashMap<String, String> picMap = picPicBiglist.get(i);
                if (picMap != null && picMap.get("pic") != null && !"".equals(picMap.get("pic"))) {
                    piclist.add(picMap.get("pic"));
                }
                if (picMap != null && picMap.get("big_pic") != null && !"".equals(picMap.get("big_pic"))) {
                    bigpiclist.add(picMap.get("big_pic"));
                }
            }
            rtnProdDetail.put("pic", piclist);
            rtnProdDetail.put("bigPic", bigpiclist);
            rtnProdDetail.put("product_prom", this.extProdManagerDAO.queryProdRelaSaleList(this));
        }
        return rtnProdDetail;
    }
   

    @Override
    public ArrayList<HashMap<String, String>> queryBaseProdList() throws AppException {
        return this.extProdManagerDAO.queryBaseProdList(this);
    }
    
    @Override
    public ArrayList<HashMap<String, String>> queryProdTypeList() throws AppException {
        //ArrayList<HashMap<String, Object>> rtnProdTypelist = new ArrayList<HashMap<String, Object>>();
        return this.extProdManagerDAO.queryProdTypeList(this);
        /*
         * for (int i = 0; i < prodBiglist.size(); i++) { HashMap<String, Object> rtnProdBigMap = new HashMap<String, Object>(); HashMap<String,
         * String> prodBigMap = prodBiglist.get(i); if (prodBigMap.get("parent_id") == null || "".equals(prodBigMap.get("parent_id"))) {
         * ArrayList<HashMap<String, String>> iProdTypelist = new ArrayList<HashMap<String, String>>(); for (int j = 0; j < prodBiglist.size(); j++) {
         * HashMap<String, String> jprodBigMap = prodBiglist.get(j); if (jprodBigMap.get("parent_id") != null &&
         * prodBigMap.get("id").equals(jprodBigMap.get("parent_id"))) { iProdTypelist.add(jprodBigMap); } } rtnProdBigMap.put("key",
         * prodBigMap.get("name")); rtnProdBigMap.put("value", iProdTypelist); rtnProdTypelist.add(rtnProdBigMap); } }
         */
      //  return rtnProdTypelist;
    }
    
    @Override
    public ArrayList<HashMap<String, Object>> queryProdTypeValueList() throws AppException {
        ArrayList<HashMap<String, Object>> rtnProdTypelist = new ArrayList<HashMap<String, Object>>();
        ArrayList<HashMap<String, String>> prodBiglist = this.extProdManagerDAO.queryProdTypeList(this);
        for (int i = 0; i < prodBiglist.size(); i++) {
            HashMap<String, Object> rtnProdBigMap = new HashMap<String, Object>();
            HashMap<String, String> prodBigMap = prodBiglist.get(i);
            if (prodBigMap.get("parent_id") == null || "".equals(prodBigMap.get("parent_id"))) {
                ArrayList<HashMap<String, String>> iProdTypelist = new ArrayList<HashMap<String, String>>();
                for (int j = 0; j < prodBiglist.size(); j++) {
                    HashMap<String, String> jprodBigMap = prodBiglist.get(j);
                    if (jprodBigMap.get("parent_id") != null && prodBigMap.get("id").equals(jprodBigMap.get("parent_id"))) {
                        iProdTypelist.add(jprodBigMap);
                    }
                }
                rtnProdBigMap.put("key", prodBigMap.get("name"));
                rtnProdBigMap.put("value", iProdTypelist);
                rtnProdTypelist.add(rtnProdBigMap);
            }
        }

        return rtnProdTypelist;
    }

       
    @Override
    public ArrayList<HashMap<String, String>> queryBasePubsFinalList() throws AppException {
        return this.extProdManagerDAO.queryBasePubsFinalList(this);
    }
    
    @Override
    public ArrayList<HashMap<String, String>> queryBaseFavoriteList() throws AppException {
        return this.extProdManagerDAO.queryBaseFavoriteList(this);
    }
    
    
    @Override
    public int removeFavorite() throws AppException {
        return this.extProdManagerDAO.removeFavorite(this);
    }
    
    @Override
    public int addFavorite() throws AppException {
        return this.extProdManagerDAO.addFavorite(this);
    }
}
