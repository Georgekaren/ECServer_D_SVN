/**************************************************************************************** 
 Copyright © 2015-2020 LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.addr.domain;

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
 * @CreateDate 2015-12-24 <br>
 * @since V8<br>
 * @see com.lianmeng.core.srv.domain <br>
 */
public abstract class AbstractAddressManager {

    
    /**
     * userId <br>
     */
    private String userId;
    /**
     * parentId <br>
     */
    private String parentId;
    

    /**
     * id <br>
     */
    private String id;
   
    /**
     * name <br>
     */
    private String name;
    
    /**
     * teleNo <br>
     */
    private String teleNo;
    
    /**
     * fixedTelNo <br>
     */
    private String fixedTelNo;
    
    /**
     * provinceId <br>
     */
    private String provinceId;
    
    /**
     * cityId <br>
     */
    private String cityId;
    
    /**
     * areaId <br>
     */
    private String areaId;
    
    /**
     * detail <br>
     */
    private String detail;
    
    /**
     * zipCode <br>
     */
    private String zipCode;
    
    /**
     * idDefault <br>
     */
    private String isDefault;
    
    /**
     * level <br>
     */
    private String level;
    
    /**
     * position <br>
     */
    private String position;
    
    /**
     * note <br>
     */
    private String note;

   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
   
    
    public String getTeleNo() {
        return teleNo;
    }

    public void setTeleNo(String teleNo) {
        this.teleNo = teleNo;
    }

    public String getFixedTelNo() {
        return fixedTelNo;
    }

    public void setFixedTelNo(String fixedTelNo) {
        this.fixedTelNo = fixedTelNo;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
            this.setId((String) aDict.getValueByName("id"));
        }
        if (aDict.get("userId") != null && !"".equals(aDict.get("userId"))) {
            this.setUserId((String) aDict.getValueByName("userId"));
        }
        if (aDict.get("name") != null && !"".equals(aDict.get("name"))) {
            this.setName((String) aDict.getValueByName("name"));
        }
        if (aDict.get("teleNo") != null && !"".equals(aDict.get("teleNo"))) {
            this.setTeleNo((String) aDict.getValueByName("teleNo"));
        }
        if (aDict.get("fixedTelNo") != null && !"".equals(aDict.get("fixedTelNo"))) {
            this.setFixedTelNo((String) aDict.getValueByName("fixedTelNo"));
        }
        if (aDict.get("provinceId") != null && !"".equals(aDict.get("provinceId"))) {
            this.setProvinceId((String) aDict.getValueByName("provinceId"));
        }
        if (aDict.get("cityId") != null && !"".equals(aDict.get("cityId"))) {
            this.setCityId((String) aDict.getValueByName("cityId"));
        }
        if (aDict.get("areaId") != null && !"".equals(aDict.get("areaId"))) {
            this.setAreaId((String) aDict.getValueByName("areaId"));
        }
        if (aDict.get("detail") != null && !"".equals(aDict.get("detail"))) {
            this.setDetail((String) aDict.getValueByName("detail"));
        }
        if (aDict.get("zipCode") != null && !"".equals(aDict.get("zipCode"))) {
            this.setZipCode((String) aDict.getValueByName("zipCode"));
        }
        if (aDict.get("isDefault") != null && !"".equals(aDict.get("isDefault"))) {
            this.setIsDefault((String) aDict.getValueByName("isDefault"));
        }
        if (aDict.get("level") != null && !"".equals(aDict.get("level"))) {
            this.setLevel((String) aDict.getValueByName("level"));
        }
        if (aDict.get("position") != null && !"".equals(aDict.get("position"))) {
            this.setPosition((String) aDict.getValueByName("position"));
        }
        if (aDict.get("note") != null && !"".equals(aDict.get("note"))) {
            this.setNote((String) aDict.getValueByName("note"));
        }
    }
    

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return 0
     * @throws AppException <br>
     */ 
    public abstract int add() throws AppException;

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return 0
     * @throws AppException <br>
     */ 
    public abstract int remove() throws AppException;
    
    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return 0
     * @throws AppException <br>
     */ 
    public abstract int modify() throws AppException;
    
    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return ArrayList<HashMap<String, String>>
     * @throws AppException <br>
     */ 
    public abstract ArrayList<HashMap<String, String>> qryAddressListByUser() throws AppException;

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return 0
     * @throws AppException <br>
     */ 
    public abstract int setNoDefault() throws AppException;
}
