/**************************************************************************************** 
 Copyright © 2015-2020  LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.extend.lianmeng.extprod.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import com.lianmeng.core.framework.bo.server.DynamicDict;
import com.lianmeng.core.framework.exceptions.AppException;

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

public abstract class AbstractExtProdManager implements Serializable {

    /**
     * serialVersionUID <br>
     */
    private static final long serialVersionUID = 1680275241815984904L;

    /**
     * prodId <br>
     */
    private String prodId;
    /**
     * prodName <br>
     */
    private String prodName;
    
    /**
     * prodType <br>
     */
    private String prodType;
    
    /**
     * prodNewFlag <br>
     */
    private boolean prodNewFlag;
    
    
    /**
     * pubsFinalId <br>
     */
    private String pubsFinalId;
    /**
     * pubsFinalParentId <br>
     */
    private String pubsFinalParentId;
    /**
     * pubsFinalKeyWord <br>
     */
    private String pubsFinalKeyWord;
    
   
    /**
     * orderSeqType <br>
     */
    private String orderSeqType;
    
    /**
     * userId <br>
     */
    private String userId;
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderSeqType() {
        return orderSeqType;
    }

    public void setOrderSeqType(String orderSeqType) {
        this.orderSeqType = orderSeqType;
    }

    public String getPubsFinalId() {
        return pubsFinalId;
    }

    public void setPubsFinalId(String pubsFinalId) {
        this.pubsFinalId = pubsFinalId;
    }

    public String getPubsFinalParentId() {
        return pubsFinalParentId;
    }

    public void setPubsFinalParentId(String pubsFinalParentId) {
        this.pubsFinalParentId = pubsFinalParentId;
    }

    public String getPubsFinalKeyWord() {
        return pubsFinalKeyWord;
    }

    public void setPubsFinalKeyWord(String pubsFinalKeyWord) {
        this.pubsFinalKeyWord = pubsFinalKeyWord;
    }

    public boolean isProdNewFlag() {
        return prodNewFlag;
    }

    public void setProdNewFlag(boolean prodNewFlag) {
        this.prodNewFlag = prodNewFlag;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br> <br>
     */ 
    public void clear() {
        this.prodId = "";
        this.prodName = "";
        this.prodType = "";
        this.prodNewFlag = false;
        this.pubsFinalId = "";
        this.pubsFinalParentId = "";
        this.pubsFinalKeyWord = "";
        this.orderSeqType = "";
        this.userId = "";
    }
    /**
     * Description:解析dict <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param aDict DynamicDict
     * @throws AppException <br>
     */ 
    public void dictToBO(DynamicDict aDict) throws AppException {
        if (aDict.get("id") != null && !"".equals(aDict.get("id"))) {
            this.setProdId((String) aDict.getValueByName("id"));
        }
        if (aDict.get("userId") != null && !"".equals(aDict.get("userId"))) {
            this.setUserId((String) aDict.getValueByName("userId"));
        }
        if (aDict.get("type") != null && !"".equals(aDict.get("type"))) {
            this.setProdType((String) aDict.getValueByName("type"));
        }
        else {
            this.setProdType("");
        }
        if (aDict.get("name") != null && !"".equals(aDict.get("name"))) {
            /*if (String.valueOf(aDict.getValueByName("name")).startsWith("%")) {
                this.setProdName(URLDecoder.decode((String) aDict.getValueByName("name")));
            }
            else {
                this.setProdName((String) aDict.getValueByName("name"));
            }*/
            this.setProdName((String) aDict.getValueByName("name"));
        }
        if (aDict.get("prodNew") != null && "true".equals(aDict.get("prodNew"))) {
            this.setProdNewFlag(true);
        }
        else {
            this.setProdNewFlag(false);
        }
        
        if (aDict.get("ordertype") != null && !"".equals(aDict.get("ordertype"))) {
            this.setOrderSeqType((String) aDict.getValueByName("ordertype"));
        }
        
        if (aDict.get("finalkeyword") != null && !"".equals(aDict.get("finalkeyword"))) {
            this.setPubsFinalKeyWord((String) aDict.getValueByName("finalkeyword"));
        }
    }
    
    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return HashMap<String, String>
     * @throws AppException <br>
     */ 
    public abstract ArrayList<HashMap<String, String>> queryLimitProdList() throws AppException;
    
    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return HashMap<String, String>
     * @throws AppException <br>
     */ 
    public abstract HashMap<String, Object> queryProdDetailList() throws AppException;
    
    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return HashMap<String, String>
     * @throws AppException <br>
     */ 
    public abstract ArrayList<HashMap<String, String>> queryBaseProdList() throws AppException;
    
    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return HashMap<String, String>
     * @throws AppException <br>
     */ 
    public abstract ArrayList<HashMap<String, String>> queryProdTypeList() throws AppException;
    
    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return ArrayList<HashMap<String, String>>
     * @throws AppException <br>
     */ 
    public abstract ArrayList<HashMap<String, Object>> queryProdTypeValueList() throws AppException;
    
    /**
     * Description:查询公共静态常量--方法需要移到产品包 <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return ArrayList<HashMap<String, String>>
     * @throws AppException <br>
     */
    public abstract ArrayList<HashMap<String, String>> queryBasePubsFinalList() throws AppException;
    
    /**
     * Description:查询收藏的产品 <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return ArrayList<HashMap<String, String>>
     * @throws AppException <br>
     */
    public abstract ArrayList<HashMap<String, String>> queryBaseFavoriteList() throws AppException;
    /**
     * Description:移除收藏的产品 <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return 0
     * @throws AppException <br>
     */
    public abstract int removeFavorite() throws AppException;
    
    /**
     * Description:移除收藏的产品 <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return 0
     * @throws AppException <br>
     */
    public abstract int addFavorite() throws AppException;
    
}
