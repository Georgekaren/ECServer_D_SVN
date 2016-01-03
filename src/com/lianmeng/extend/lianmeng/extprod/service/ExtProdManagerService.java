/**************************************************************************************** 
 Copyright © 2015-2020  LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.extend.lianmeng.extprod.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.lianmeng.core.framework.bo.server.DynamicDict;
import com.lianmeng.core.framework.bo.server.IAction;
import com.lianmeng.core.framework.exceptions.AppException;
import com.lianmeng.core.framework.rest.app.util.ServiceObjectToJsonUtil;
import com.lianmeng.extend.lianmeng.extprod.domain.ExtProdManager;

/** 
 * Description: <br> 
 *  
 * @author XXX<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2015-12-21 <br>
 * @since V8<br>
 * @see com.lianmeng.extend.lianmeng.home.service <br>
 */

public class ExtProdManagerService implements IAction {

    /**
     * extProdManager <br>
     */
    private ExtProdManager extProdManager;

    public void setExtProdManager(ExtProdManager extProdManager) {
        this.extProdManager = extProdManager;
    }
    
    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param aDict DynamicDict
     * @return 0 
     * @throws AppException <br>
     */
    @Override
    public int perform(DynamicDict aDict) throws AppException {
        String action = (String) aDict.getValueByName("ACTION");
        this.extProdManager.clear();
        if (StringUtils.equals(action, "QRYLIMITPROD")) {
            aDict.set("DATA_INFO", this.extProdManager.queryLimitProdList());
            aDict.set(ServiceObjectToJsonUtil.RESPONSE_CODE, "limitBuy");
        }
        else if (StringUtils.equals(action, "QRYBASECONTENTPROD")) {
            this.extProdManager.dictToBO(aDict);
            aDict.set("DATA_INFO", this.extProdManager.queryBaseProdList());
            aDict.set(ServiceObjectToJsonUtil.RESPONSE_CODE, "prodBase");
        }
        else if (StringUtils.equals(action, "QRYBASECONTENTANDCOLORPROD")) {
            this.extProdManager.dictToBO(aDict);
            ArrayList<HashMap<String, String>> baseProdList = this.extProdManager.queryBaseProdList();
            aDict.set("DATA_INFO", baseProdList);
            aDict.set("DATA_CNT", baseProdList.size());
            
            ArrayList<HashMap<String, Object>> fcsMapList = new ArrayList<HashMap<String, Object>>();
            
            this.extProdManager.setPubsFinalParentId("");
            this.extProdManager.setPubsFinalKeyWord("COLOR");
            HashMap<String, String> colorMap = this.extProdManager.queryBasePubsFinalList().get(0);
            HashMap<String, Object> colorMapKey = new HashMap<String, Object>();
            colorMapKey.put("key", colorMap.get("name"));
            this.extProdManager.setPubsFinalKeyWord("SUBCOLOR");
            this.extProdManager.setPubsFinalParentId(colorMap.get("id"));
            colorMapKey.put("value", this.extProdManager.queryBasePubsFinalList());
            fcsMapList.add(colorMapKey);

            this.extProdManager.setPubsFinalParentId("");
            this.extProdManager.setPubsFinalKeyWord("BRAND");
            HashMap<String, String> brandMap = this.extProdManager.queryBasePubsFinalList().get(0);
            HashMap<String, Object> brandMapKey = new HashMap<String, Object>();
            brandMapKey.put("key", brandMap.get("name"));
            this.extProdManager.setPubsFinalKeyWord("SUBBRAND");
            this.extProdManager.setPubsFinalParentId(brandMap.get("id"));
            brandMapKey.put("value", this.extProdManager.queryBasePubsFinalList());
            fcsMapList.add(brandMapKey);
            
            aDict.set("PUBS_FINALS", fcsMapList);
            aDict.set(ServiceObjectToJsonUtil.RESPONSE_CODE, "prodBaseAndColor");
        }
        else if (StringUtils.equals(action, "QRYPRODDETAIL")) {
            this.extProdManager.dictToBO(aDict);
            aDict.set("DATA_INFO", this.extProdManager.queryProdDetailList());
            aDict.set(ServiceObjectToJsonUtil.RESPONSE_CODE, "prodDetail");
        }
        else if (StringUtils.equals(action, "QRYPRODTYPEVALUELIST")) {
            this.extProdManager.dictToBO(aDict);
            aDict.set("DATA_INFO", this.extProdManager.queryProdTypeValueList());
            aDict.set(ServiceObjectToJsonUtil.RESPONSE_CODE, "prodValueType");
        }
        else if (StringUtils.equals(action, "QRYPRODTYPELIST")) {
            
            this.extProdManager.dictToBO(aDict);
            aDict.set("DATA_INFO", this.extProdManager.queryProdTypeList());
            aDict.set(ServiceObjectToJsonUtil.RESPONSE_CODE, "prodType");
        }
        else if (StringUtils.equals(action, "QRYPRODFINALSLIST")) {
            this.extProdManager.dictToBO(aDict);
            ArrayList<HashMap<String, String>> basList = this.extProdManager.queryBasePubsFinalList();
            
            aDict.set("DATA_INFO", basList);
            aDict.set(ServiceObjectToJsonUtil.RESPONSE_CODE, "prodType");
        }
        else if (StringUtils.equals(action, "QRYBASEFAVORITEPROD")) {
            this.extProdManager.dictToBO(aDict);
            aDict.set("DATA_INFO", this.extProdManager.queryBaseFavoriteList());
            aDict.set(ServiceObjectToJsonUtil.RESPONSE_CODE, "favorites"); 
        }
        else if (StringUtils.equals(action, "MIMREMOVEFAVORITEPROD")) {
            this.extProdManager.dictToBO(aDict);
            this.extProdManager.removeFavorite();
            aDict.set(ServiceObjectToJsonUtil.RESPONSE_CODE, "removefavorites"); 
        }
        else if (StringUtils.equals(action, "MIMADDFAVORITEPROD")) {
            this.extProdManager.dictToBO(aDict);
            this.extProdManager.addFavorite();
            aDict.set(ServiceObjectToJsonUtil.RESPONSE_CODE, "addfavorites"); 
        }
        else {
            aDict.set(ServiceObjectToJsonUtil.RESPONSE_CODE, "extProd");
        }
        
        
        
        
        return 0;
    }

    
    
    
}
